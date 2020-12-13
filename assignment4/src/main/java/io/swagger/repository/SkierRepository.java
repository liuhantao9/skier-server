package io.swagger.repository;

import io.swagger.model.LiftRide;
import io.swagger.model.SkierVertical;
import io.swagger.model.mapper.SkiVerticalMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SkierRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public SkierVertical getSkierDayVertical(String resortID, String dayID, String skierID) {
    SkierVertical skierVertical = new SkierVertical();

    String tableName = resortID.replaceAll("\\s+","") + dayID;
    String selectStmt = "SELECT SUM(LiftId) AS totalVertical"
        + " FROM skier_data"
        + " WHERE ResortId = ? AND DayId = ? AND SkierId = ?";

    try {
      skierVertical = jdbcTemplate.queryForObject(selectStmt, new Object[]{resortID, dayID, skierID}, new SkiVerticalMapper());
      skierVertical.setResortID(resortID);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }

    return skierVertical;
  }

  public SkierVertical getSkierResortTotals(String skierID, List<String> resort) {
    SkierVertical skierVertical = new SkierVertical();

    try {
      int sum = 0;
      String selectStmt = "SELECT SUM(LiftId) AS vertical"
          + " FROM skier_data"
          + " WHERE SkierId = ?;";
      Integer vertical = jdbcTemplate.queryForObject(selectStmt, new Object[]{skierID}, Integer.class);
      sum += vertical == null ? 0 : vertical * 10;
      skierVertical.setTotalVert(sum);
      skierVertical.setResortID(resort.get(0));
    } catch (EmptyResultDataAccessException e) {
      return null;
    }

    return skierVertical;
  }

  public void writeNewLiftRide(LiftRide liftRide) {
    String tableName = liftRide.getResortID().replaceAll("\\s+","") + liftRide.getDayID();

    String insertResortDayStmt = "INSERT IGNORE INTO skier_data (ResortId, DayId, SkierId, Time, LiftId) VALUES (?, ?, ?, ?, ?)";
    jdbcTemplate.update(insertResortDayStmt, new Object[]{liftRide.getResortID(),
        liftRide.getDayID(), liftRide.getSkierID(), liftRide.getTime(), liftRide.getLiftID()});
  }

//  private boolean hasTable(String resortId, String dayId) {
//    String selectStmt = "SELECT Reference FROM resort_day WHERE resortId = ? AND dayId = ?";
//    try {
//      jdbcTemplate.queryForObject(selectStmt, new Object[]{resortId, dayId}, String.class);
//    } catch (EmptyResultDataAccessException e) {
//      return false;
//    }
//    return true;
//  }
}
