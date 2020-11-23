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
 * TopTenTopTenSkiers
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-24T07:26:28.713Z[GMT]")


public class TopTenTopTenSkiers   {
  @JsonProperty("skierID")
  private String skierID = null;

  @JsonProperty("VertcialTotal")
  private Integer vertcialTotal = null;

  public TopTenTopTenSkiers skierID(String skierID) {
    this.skierID = skierID;
    return this;
  }

  /**
   * Get skierID
   * @return skierID
  **/
  @ApiModelProperty(example = "888899", value = "")
  
    public String getSkierID() {
    return skierID;
  }

  public void setSkierID(String skierID) {
    this.skierID = skierID;
  }

  public TopTenTopTenSkiers vertcialTotal(Integer vertcialTotal) {
    this.vertcialTotal = vertcialTotal;
    return this;
  }

  /**
   * Get vertcialTotal
   * @return vertcialTotal
  **/
  @ApiModelProperty(example = "30400", value = "")
  
    public Integer getVertcialTotal() {
    return vertcialTotal;
  }

  public void setVertcialTotal(Integer vertcialTotal) {
    this.vertcialTotal = vertcialTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopTenTopTenSkiers topTenTopTenSkiers = (TopTenTopTenSkiers) o;
    return Objects.equals(this.skierID, topTenTopTenSkiers.skierID) &&
        Objects.equals(this.vertcialTotal, topTenTopTenSkiers.vertcialTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(skierID, vertcialTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopTenTopTenSkiers {\n");
    
    sb.append("    skierID: ").append(toIndentedString(skierID)).append("\n");
    sb.append("    vertcialTotal: ").append(toIndentedString(vertcialTotal)).append("\n");
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
