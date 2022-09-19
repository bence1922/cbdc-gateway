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
 * Information for account creation.
 */
@Schema(description = "Information for account creation.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-12T13:47:43.333Z[GMT]")


public class CreateAddress   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("initialNonce")
  private BigDecimal initialNonce = null;

  @JsonProperty("v")
  private BigDecimal v = null;

  @JsonProperty("r")
  private String r = null;

  @JsonProperty("s")
  private String s = null;

  public CreateAddress address(String address) {
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

  public CreateAddress initialNonce(BigDecimal initialNonce) {
    this.initialNonce = initialNonce;
    return this;
  }

  /**
   * Get initialNonce
   * @return initialNonce
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getInitialNonce() {
    return initialNonce;
  }

  public void setInitialNonce(BigDecimal initialNonce) {
    this.initialNonce = initialNonce;
  }

  public CreateAddress v(BigDecimal v) {
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

  public CreateAddress r(String r) {
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

  public CreateAddress s(String s) {
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
    CreateAddress createAddress = (CreateAddress) o;
    return Objects.equals(this.address, createAddress.address) &&
        Objects.equals(this.initialNonce, createAddress.initialNonce) &&
        Objects.equals(this.v, createAddress.v) &&
        Objects.equals(this.r, createAddress.r) &&
        Objects.equals(this.s, createAddress.s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, initialNonce, v, r, s);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAddress {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    initialNonce: ").append(toIndentedString(initialNonce)).append("\n");
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
