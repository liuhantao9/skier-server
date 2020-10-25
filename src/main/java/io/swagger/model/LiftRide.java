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
 * LiftRide
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-24T07:26:28.713Z[GMT]")


public class LiftRide   {
  @JsonProperty("resortID")
  private String resortID = null;

  @JsonProperty("dayID")
  private String dayID = null;

  @JsonProperty("skierID")
  private String skierID = null;

  @JsonProperty("time")
  private String time = null;

  @JsonProperty("liftID")
  private String liftID = null;

  public LiftRide resortID(String resortID) {
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

  public LiftRide dayID(String dayID) {
    this.dayID = dayID;
    return this;
  }

  /**
   * Get dayID
   * @return dayID
  **/
  @ApiModelProperty(example = "23", value = "")
  
    public String getDayID() {
    return dayID;
  }

  public void setDayID(String dayID) {
    this.dayID = dayID;
  }

  public LiftRide skierID(String skierID) {
    this.skierID = skierID;
    return this;
  }

  /**
   * Get skierID
   * @return skierID
  **/
  @ApiModelProperty(example = "7889", value = "")
  
    public String getSkierID() {
    return skierID;
  }

  public void setSkierID(String skierID) {
    this.skierID = skierID;
  }

  public LiftRide time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(example = "217", value = "")
  
    public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public LiftRide liftID(String liftID) {
    this.liftID = liftID;
    return this;
  }

  /**
   * Get liftID
   * @return liftID
  **/
  @ApiModelProperty(example = "21", value = "")
  
    public String getLiftID() {
    return liftID;
  }

  public void setLiftID(String liftID) {
    this.liftID = liftID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiftRide liftRide = (LiftRide) o;
    return Objects.equals(this.resortID, liftRide.resortID) &&
        Objects.equals(this.dayID, liftRide.dayID) &&
        Objects.equals(this.skierID, liftRide.skierID) &&
        Objects.equals(this.time, liftRide.time) &&
        Objects.equals(this.liftID, liftRide.liftID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resortID, dayID, skierID, time, liftID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiftRide {\n");
    
    sb.append("    resortID: ").append(toIndentedString(resortID)).append("\n");
    sb.append("    dayID: ").append(toIndentedString(dayID)).append("\n");
    sb.append("    skierID: ").append(toIndentedString(skierID)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    liftID: ").append(toIndentedString(liftID)).append("\n");
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
