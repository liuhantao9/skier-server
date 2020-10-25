package io.swagger.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.TopTen;
import io.swagger.model.TopTenTopTenSkiers;
import io.swagger.model.mapper.TopTenTopTenSkiersMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResortRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public TopTen getTopTenVert(String resortId, String dayId) {
    String tableName = resortId.replaceAll("\\s+","") + dayId;
    String selectStmt = "SELECT SkierId, SUM(LiftId) AS Sum"
        + " FROM " + tableName
        + " GROUP BY SkierId"
        + " ORDER BY SUM(LiftId) DESC "
        + " LIMIT 10";

    TopTen topTen = new TopTen();

    try {
      List<TopTenTopTenSkiers> list = jdbcTemplate.query(selectStmt, new TopTenTopTenSkiersMapper());
      topTen.setTopTenSkiers(list);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return topTen;
  }
}
