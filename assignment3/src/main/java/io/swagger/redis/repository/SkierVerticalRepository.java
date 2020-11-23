package io.swagger.redis.repository;

import io.swagger.redis.model.SkierVerticalWrapper;

public interface SkierVerticalRepository {

  SkierVerticalWrapper find(String resortID, String dayID, String skierID);

  void save(SkierVerticalWrapper skierVerticalWrapper);

  void update(String resortID, String dayID, String skierID, String liftID);
}
