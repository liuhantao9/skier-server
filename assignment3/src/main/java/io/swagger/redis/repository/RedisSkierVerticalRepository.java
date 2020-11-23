package io.swagger.redis.repository;

import io.swagger.model.SkierVertical;
import io.swagger.redis.model.SkierVerticalWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class RedisSkierVerticalRepository implements SkierVerticalRepository {

  private RedisTemplate<String, SkierVerticalWrapper> template;
  private HashOperations hashOperations;

  @Autowired
  public RedisSkierVerticalRepository(RedisTemplate<String, SkierVerticalWrapper> template) {
    this.template = template;
    this.hashOperations = template.opsForHash();
  }

  @Override
  public SkierVerticalWrapper find(String resortID, String dayID,
      String skierID) {
    log.info("REDIS       |   reading one day record: " + resortID + ", " + dayID + ", " + skierID);
    return (SkierVerticalWrapper)hashOperations.get("SkierVerticalWrapper", resortID + dayID + skierID);
  }

  @Override
  public void save(SkierVerticalWrapper skierVerticalWrapper) {
    log.info("REDIS       |   saving: " + skierVerticalWrapper.toString() + "-> to cache");
    hashOperations.put("SkierVerticalWrapper",
        skierVerticalWrapper.getResortID() + skierVerticalWrapper.getDayID() + skierVerticalWrapper.getSkierID(),
        skierVerticalWrapper);
  }

  @Override
  public void update(String resortID, String dayID, String skierID, String liftID) {
    log.info("REDIS       |   updating key: " + resortID + ", " + dayID + ", " + skierID + " -> cache");

    SkierVerticalWrapper skw = find(resortID, dayID, skierID);
    if (skw != null) {
      skw.increment(Integer.parseInt(liftID) * 10);
      save(skw);
    }
  }
}
