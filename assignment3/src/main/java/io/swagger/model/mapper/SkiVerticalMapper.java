package io.swagger.model.mapper;

import io.swagger.model.SkierVertical;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SkiVerticalMapper implements RowMapper<SkierVertical> {

  @Override
  public SkierVertical mapRow(ResultSet resultSet, int i) throws SQLException {
    SkierVertical skierVertical = new SkierVertical();
    skierVertical.setTotalVert(resultSet.getInt("totalVertical") * 10);

    return skierVertical;
  }
}
