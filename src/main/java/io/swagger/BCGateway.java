package io.swagger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EventListener;
import java.util.regex.Pattern;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Transaction;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;
import org.hyperledger.fabric.protos.common.Common;
import org.hyperledger.fabric.protos.peer.ChaincodeEventPackage.ChaincodeEvent;
import org.hyperledger.fabric.sdk.BlockEvent;
import org.hyperledger.fabric.sdk.BlockchainInfo;
import org.hyperledger.fabric.sdk.ChaincodeEventListener;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.TransactionInfo;
import org.yaml.snakeyaml.events.Event;


public class BCGateway {
    static Gateway.Builder builder;
    public static void init() throws IOException, ContractException {
        // Load an existing wallet holding identities used to access the network.
        Path walletDirectory = Paths.get("Org1Wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletDirectory);

        // Path to a common connection profile describing the network.
        Path networkConfigFile = Paths.get("connection.json");

        // Configure the gateway connection used to access the network.
        builder = Gateway.createBuilder()
                .identity(wallet, "Org1 Admin")
                .networkConfig(networkConfigFile);
        System.out.println("BC init done");
    }
    public static String ConnectivityTest(){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            contract.evaluateTransaction("ping");
            System.out.println("ping done");
            return "ping done";
        } catch (Exception e) {
            System.out.println(e.toString());
            return e.toString();
        }
    }
    public static String ApplyForGreenCbdc(String address, String lockedUserAmount, String requestedAmount,String verifierDocUri){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            Transaction t = contract.createTransaction("applyForGreenCbdc").setEndorsingPeers(network.getChannel().getPeers());
            t.submit(address, lockedUserAmount,requestedAmount,verifierDocUri);
            System.out.println("Apply for green CBDC On Fabric done.");
            return "successful green CBDC request";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return e.toString();
        }
    }
    public static String ApproveGreenCbdc(String address, String totalPayout, String deadlineInDays){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            Transaction t = contract.createTransaction("approveGreenCbdc").setEndorsingPeers(network.getChannel().getPeers());
            t.submit(address,totalPayout,deadlineInDays);
            System.out.println("Approve green CBDC On Fabric done.");
            return "successful green CBDC request";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return e.toString();
        }
    }
    public static String Transfer(String from, String to, String value,String pocket,String nextNonce, String v, String r, String s){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            
            Transaction t = contract.createTransaction("transferFromPocket").setEndorsingPeers(network.getChannel().getPeers());
            t.submit(from, to,value,pocket,nextNonce, v, r, s);
            System.out.println("Transfer On Fabric done.");
            return "succesfull transfer";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return e.toString();
        }
    }
    public static String getNonce(String address){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            System.out.println(Integer.parseInt(new String(contract.evaluateTransaction("getNonce",address), StandardCharsets.UTF_8)) + 1);
            return String.valueOf(Integer.parseInt(new String(contract.evaluateTransaction("getNonce",address), StandardCharsets.UTF_8)) + 1);
        }catch(Exception e){
            System.out.print(e.toString());
            return e.toString();
        }
        
            
    }
    public static String checkTransfer(String transferID, String from, String to, String value){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            TransactionInfo ti =  network.getChannel().queryTransactionByID(transferID);
            System.out.println("TransactionID: " + ti.getTransactionID() + " ,valid: " + ti.getValidationCode());
            /*FabricProposalResponse.ProposalResponsePayload pl = FabricProposalResponse.ProposalResponsePayload.parseFrom(ti.getProcessedTransaction().getTransactionEnvelope().getPayload());
            char per = 92;
            String[] data = pl.toString().replace(per+"","separate").split("separate");
            int balanceIndex = indexOfIntArray(data, "022transferFromPocket");
            
            String from1 = data[balanceIndex+1].substring(2);
            String to1 = data[balanceIndex+2].substring(2);
            if(from.equals(from1) && to.equals(to1) && transfered(data)>-1 && ti.getValidationCode().toString().equals("VALID")){
                return "VALID";
            }*/
            return ti.getValidationCode() + "";
        } catch (Exception e) {
            System.out.print(e.toString());
            return "INVALID";
        }
        
    }
    public static int indexOfIntArray(String[] array, String key) {
        for (int i = 0; i < array.length; ++i) {
            if (key.equals(array[i])) 
                return i;
        }
        return -1;
    }
    public static int transfered(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].contains("UnitsTransferred"))
                return Integer.parseInt(array[i].replace("UnitsTransferred",""));
        }
        return -1;
    }
    public static String transferId(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].contains("epengo"))
            {
                String temp = array[i].split("@")[1];
                return temp.substring(0,temp.length()-1);
            }
        }
        return null;
    }
    public static String getBalance(@NotNull String address) {
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            return String.valueOf(Integer.parseInt(new String(contract.evaluateTransaction("getBalance",address), StandardCharsets.UTF_8)));
        }catch(Exception e){
            System.out.print(e.toString());
            return e.toString();
        }
    }
    public static String createAddress(@NotNull String address, @NotNull String initialNonce, String v,
            @NotNull String r, @NotNull String s) {
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            
            Transaction t = contract.createTransaction("createAddress").setEndorsingPeers(network.getChannel().getPeers());
            t.submit(address, initialNonce,v, r, s);
            System.out.println("Address creation On Fabric done.");
            return "succesfull creation";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return e.toString();
        }
    }
    public static String mintUnits(@NotNull String address, String amount, String nonce, String v,
            @NotNull String r, @NotNull String s) {
                try (Gateway gateway = builder.connect()) {
                    Network network = gateway.getNetwork("channel1");
                    Contract contract = network.getContract("cbdc");
                    
                    Transaction t = contract.createTransaction("mintUnits").setEndorsingPeers(network.getChannel().getPeers());
                    t.submit(address, amount, nonce, v, r, s);
                    System.out.println("Mint On Fabric done.");
                    return "succesfull minting";
                }
                catch (Exception e){
                    System.out.println(e.toString());
                    return e.toString();
                }
    }
    public static String unlockUnits(String address, String amount) {
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            Contract contract = network.getContract("cbdc");
            
            Transaction t = contract.createTransaction("unlockUnits").setEndorsingPeers(network.getChannel().getPeers());
            t.submit(address, amount);
            System.out.println("unlockUnits On Fabric done.");
            return "succesfull unlockUnit";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return e.toString();
        }
    }

    public static void listeningForChaincodeEvents(){
        try (Gateway gateway = builder.connect()) {
            Network network = gateway.getNetwork("channel1");
            ChaincodeEventListener eventListener = new ChaincodeEventListener() {
                @Override
                public void received(String handle, BlockEvent blockEvent,
                        org.hyperledger.fabric.sdk.ChaincodeEvent chaincodeEvent) {
                    if(chaincodeEvent.getChaincodeId() != null){
                        System.out.println("event name: " + chaincodeEvent.getEventName() + "; payload: " + chaincodeEvent.getPayload());
                        String str = "event name: " + chaincodeEvent.getEventName() + "; payload: " + chaincodeEvent.getPayload();
                        BufferedWriter writer;
                        try {
                            writer = new BufferedWriter(new FileWriter("filename.txt", true));
                            writer.append('\n');
                            writer.append(str);
                            writer.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            };
            network.getChannel().registerChaincodeEventListener( Pattern.compile(".*"),  Pattern.compile(".*"), eventListener);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}