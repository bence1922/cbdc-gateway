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
 * ApproveGreenCbdcBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-12T13:47:43.333Z[GMT]")


public class ApproveGreenCbdcBody   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("totalPayout")
  private BigDecimal totalPayout = null;

  @JsonProperty("deadlineInDays")
  private BigDecimal deadlineInDays = null;

  public ApproveGreenCbdcBody address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @Schema(description = "")
  
    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public ApproveGreenCbdcBody totalPayout(BigDecimal totalPayout) {
    this.totalPayout = totalPayout;
    return this;
  }

  /**
   * Get totalPayout
   * @return totalPayout
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getTotalPayout() {
    return totalPayout;
  }

  public void setTotalPayout(BigDecimal totalPayout) {
    this.totalPayout = totalPayout;
  }

  public ApproveGreenCbdcBody deadlineInDays(BigDecimal deadlineInDays) {
    this.deadlineInDays = deadlineInDays;
    return this;
  }

  /**
   * Get deadlineInDays
   * @return deadlineInDays
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getDeadlineInDays() {
    return deadlineInDays;
  }

  public void setDeadlineInDays(BigDecimal deadlineInDays) {
    this.deadlineInDays = deadlineInDays;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApproveGreenCbdcBody approveGreenCbdcBody = (ApproveGreenCbdcBody) o;
    return Objects.equals(this.address, approveGreenCbdcBody.address) &&
        Objects.equals(this.totalPayout, approveGreenCbdcBody.totalPayout) &&
        Objects.equals(this.deadlineInDays, approveGreenCbdcBody.deadlineInDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, totalPayout, deadlineInDays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApproveGreenCbdcBody {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    totalPayout: ").append(toIndentedString(totalPayout)).append("\n");
    sb.append("    deadlineInDays: ").append(toIndentedString(deadlineInDays)).append("\n");
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
