package it.ss.mymoviesserver.model.mapper;

import it.ss.mymoviesserver.model.MovieView;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<MovieView> {

    @Override
    public MovieView mapRow(ResultSet rs, int rowNum) throws SQLException {
        final MovieView movie = new MovieView();
        movie.setId(rs.getLong("ID"));
        movie.setTitle(rs.getString("TITLE"));
        movie.setGenre(rs.getString("GENRE"));
        movie.setDirector(rs.getString("DIRECTOR"));
        movie.setCountry(rs.getString("COUNTRY"));
        movie.setReleaseDate(rs.getDate("RELEASE_DATE"));
        return movie;
    }
}
