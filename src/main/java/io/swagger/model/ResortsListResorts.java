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
 * ResortsListResorts
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-24T07:26:28.713Z[GMT]")


public class ResortsListResorts   {
  @JsonProperty("resortName")
  private String resortName = null;

  public ResortsListResorts resortName(String resortName) {
    this.resortName = resortName;
    return this;
  }

  /**
   * Get resortName
   * @return resortName
  **/
  @ApiModelProperty(value = "")
  
    public String getResortName() {
    return resortName;
  }

  public void setResortName(String resortName) {
    this.resortName = resortName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResortsListResorts resortsListResorts = (ResortsListResorts) o;
    return Objects.equals(this.resortName, resortsListResorts.resortName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resortName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResortsListResorts {\n");
    
    sb.append("    resortName: ").append(toIndentedString(resortName)).append("\n");
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
