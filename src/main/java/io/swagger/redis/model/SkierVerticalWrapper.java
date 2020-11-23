package io.swagger.redis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("SkierVerticalWrapper")
@Data
@AllArgsConstructor
public class SkierVerticalWrapper implements Serializable {

  private static final long serialVersionUID = 7681572934675275930L;
  private String resortID;
  private Integer totalVert;
  private String skierID;
  private String dayID;

  public void increment(Integer totalVert) {
    this.totalVert += totalVert;
  }
}
