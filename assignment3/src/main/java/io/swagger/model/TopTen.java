package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.TopTenTopTenSkiers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TopTen
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-24T07:26:28.713Z[GMT]")


public class TopTen   {
  @JsonProperty("topTenSkiers")
  @Valid
  private List<TopTenTopTenSkiers> topTenSkiers = null;

  public TopTen topTenSkiers(List<TopTenTopTenSkiers> topTenSkiers) {
    this.topTenSkiers = topTenSkiers;
    return this;
  }

  public TopTen addTopTenSkiersItem(TopTenTopTenSkiers topTenSkiersItem) {
    if (this.topTenSkiers == null) {
      this.topTenSkiers = new ArrayList<TopTenTopTenSkiers>();
    }
    this.topTenSkiers.add(topTenSkiersItem);
    return this;
  }

  /**
   * Get topTenSkiers
   * @return topTenSkiers
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<TopTenTopTenSkiers> getTopTenSkiers() {
    return topTenSkiers;
  }

  public void setTopTenSkiers(List<TopTenTopTenSkiers> topTenSkiers) {
    this.topTenSkiers = topTenSkiers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopTen topTen = (TopTen) o;
    return Objects.equals(this.topTenSkiers, topTen.topTenSkiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topTenSkiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopTen {\n");
    
    sb.append("    topTenSkiers: ").append(toIndentedString(topTenSkiers)).append("\n");
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
