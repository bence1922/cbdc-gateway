package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information for mint unit.
 */
@Schema(description = "Information for mint unit.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-12T13:47:43.333Z[GMT]")


public class MintUnits   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("nonce")
  private BigDecimal nonce = null;

  @JsonProperty("v")
  private BigDecimal v = null;

  @JsonProperty("r")
  private String r = null;

  @JsonProperty("s")
  private String s = null;

  public MintUnits address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public MintUnits amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public MintUnits nonce(BigDecimal nonce) {
    this.nonce = nonce;
    return this;
  }

  /**
   * Get nonce
   * @return nonce
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getNonce() {
    return nonce;
  }

  public void setNonce(BigDecimal nonce) {
    this.nonce = nonce;
  }

  public MintUnits v(BigDecimal v) {
    this.v = v;
    return this;
  }

  /**
   * Get v
   * @return v
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getV() {
    return v;
  }

  public void setV(BigDecimal v) {
    this.v = v;
  }

  public MintUnits r(String r) {
    this.r = r;
    return this;
  }

  /**
   * Get r
   * @return r
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getR() {
    return r;
  }

  public void setR(String r) {
    this.r = r;
  }

  public MintUnits s(String s) {
    this.s = s;
    return this;
  }

  /**
   * Get s
   * @return s
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MintUnits mintUnits = (MintUnits) o;
    return Objects.equals(this.address, mintUnits.address) &&
        Objects.equals(this.amount, mintUnits.amount) &&
        Objects.equals(this.nonce, mintUnits.nonce) &&
        Objects.equals(this.v, mintUnits.v) &&
        Objects.equals(this.r, mintUnits.r) &&
        Objects.equals(this.s, mintUnits.s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, amount, nonce, v, r, s);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MintUnits {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("    v: ").append(toIndentedString(v)).append("\n");
    sb.append("    r: ").append(toIndentedString(r)).append("\n");
    sb.append("    s: ").append(toIndentedString(s)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
