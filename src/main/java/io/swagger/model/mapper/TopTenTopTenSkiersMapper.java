package io.swagger.model.mapper;

import io.swagger.model.TopTenTopTenSkiers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TopTenTopTenSkiersMapper implements RowMapper<TopTenTopTenSkiers> {

  @Override
  public TopTenTopTenSkiers mapRow(ResultSet resultSet, int i) throws SQLException {
    TopTenTopTenSkiers topTenTopTenSkiers = new TopTenTopTenSkiers();
    topTenTopTenSkiers.setSkierID(Integer.toString(resultSet.getInt("SkierId")));
    topTenTopTenSkiers.setVertcialTotal(resultSet.getInt("Sum") * 10);
    
    return topTenTopTenSkiers;
  }
}
