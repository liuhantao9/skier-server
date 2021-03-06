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

    if (!hasTable(resortID, dayID)) return skierVertical;

    String tableName = resortID.replaceAll("\\s+","") + dayID;
    String selectStmt = "SELECT SUM(LiftId) AS totalVertical"
        + " FROM " + tableName
        + " WHERE SkierId = ?";

    try {
      skierVertical = jdbcTemplate.queryForObject(selectStmt, new Object[]{skierID}, new SkiVerticalMapper());
      skierVertical.setResortID(resortID);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }

    return skierVertical;
  }

  public SkierVertical getSkierResortTotals(String skierID, List<String> resort) {
    SkierVertical skierVertical = new SkierVertical();

    String selectTables = "SELECT Reference FROM resort_day WHERE ResortId = ?";
    List<String> tableNames = new ArrayList<>();

    try {
      tableNames = jdbcTemplate.queryForList(selectTables, new Object[]{resort.get(0)}, String.class);
      int sum = 0;
      for (String name : tableNames) {
        String selectStmt = "SELECT SUM(LiftId) AS vertical"
            + " FROM " + name
            + " WHERE SkierId = ?;";
        Integer vertical = jdbcTemplate.queryForObject(selectStmt, new Object[]{skierID}, Integer.class);
        sum += vertical == null ? 0 : vertical * 10;
      }
      skierVertical.setTotalVert(sum);
      skierVertical.setResortID(resort.get(0));
    } catch (EmptyResultDataAccessException e) {
      return null;
    }

    return skierVertical;
  }

  public void writeNewLiftRide(LiftRide liftRide) {
    String tableName = liftRide.getResortID().replaceAll("\\s+","") + liftRide.getDayID();
    if (!hasTable(liftRide.getResortID(), liftRide.getDayID())) {
      String createStmt = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
          + " SkierId INT NOT NULL,"
          + " Time BIGINT NOT NULL,"
          + " LiftId INT NOT NULL"
          + ");";
      jdbcTemplate.execute(createStmt);

      String insertResortDayStmt = "INSERT IGNORE INTO resort_day (ResortId, DayId, Reference) VALUES (?, ?, ?)";
      jdbcTemplate.update(insertResortDayStmt, new Object[]{liftRide.getResortID(), liftRide.getDayID(), tableName});
    }

    String insertReferenceTable = "INSERT INTO " + tableName + " (SkierId, Time, LiftId) VALUES (?, ?, ?)";
    jdbcTemplate.update(insertReferenceTable, new Object[]{liftRide.getSkierID(), liftRide.getTime(), liftRide.getLiftID()});
  }

  private boolean hasTable(String resortId, String dayId) {
    String selectStmt = "SELECT Reference FROM resort_day WHERE resortId = ? AND dayId = ?";
    try {
      jdbcTemplate.queryForObject(selectStmt, new Object[]{resortId, dayId}, String.class);
    } catch (EmptyResultDataAccessException e) {
      return false;
    }
    return true;
  }
}
