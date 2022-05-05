package it.ss.mymoviesserver.model.mapper;

import it.ss.mymoviesserver.model.DirectorView;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorRowMapper implements RowMapper<DirectorView> {

    @Override
    public DirectorView mapRow(ResultSet rs, int rowNum) throws SQLException {
        final DirectorView director = new DirectorView();
        director.setId(rs.getLong("ID"));
        director.setName(rs.getString("NAME"));
        director.setCountry(rs.getString("COUNTRY"));
        return director;
    }
}
