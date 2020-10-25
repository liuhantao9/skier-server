package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SkierVertical
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-24T07:26:28.713Z[GMT]")


public class SkierVertical   {
  @JsonProperty("resortID")
  private String resortID = null;

  @JsonProperty("totalVert")
  private Integer totalVert = null;

  public SkierVertical resortID(String resortID) {
    this.resortID = resortID;
    return this;
  }

  /**
   * Get resortID
   * @return resortID
  **/
  @ApiModelProperty(example = "Mission Ridge", value = "")
  
    public String getResortID() {
    return resortID;
  }

  public void setResortID(String resortID) {
    this.resortID = resortID;
  }

  public SkierVertical totalVert(Integer totalVert) {
    this.totalVert = totalVert;
    return this;
  }

  /**
   * Get totalVert
   * @return totalVert
  **/
  @ApiModelProperty(example = "56734", value = "")
  
    public Integer getTotalVert() {
    return totalVert;
  }

  public void setTotalVert(Integer totalVert) {
    this.totalVert = totalVert;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SkierVertical skierVertical = (SkierVertical) o;
    return Objects.equals(this.resortID, skierVertical.resortID) &&
        Objects.equals(this.totalVert, skierVertical.totalVert);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resortID, totalVert);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SkierVertical {\n");
    
    sb.append("    resortID: ").append(toIndentedString(resortID)).append("\n");
    sb.append("    totalVert: ").append(toIndentedString(totalVert)).append("\n");
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
