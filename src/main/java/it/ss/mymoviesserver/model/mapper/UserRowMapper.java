package it.ss.mymoviesserver.model.mapper;

import it.ss.mymoviesserver.model.User;
import it.ss.mymoviesserver.model.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        final User user = new User();
        user.setId(rs.getLong("ID"));
        user.setUsername(rs.getString("USERNAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setRole(UserRole.getRoleByName(rs.getString("ROLE")));
        return user;
    }
}
