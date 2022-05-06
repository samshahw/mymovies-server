//package it.ss.mymoviesserver.dao.impl;
//
//import it.ss.mymoviesserver.model.Director;
//import it.ss.mymoviesserver.model.mapper.DirectorRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//
//public class DirectorsDAOimpl {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public DirectorsDAOimpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Director> findAll() {
//        final String query = "SELECT * FROM mymovies.directors_list ORDER BY id DESC";
//        return this.jdbcTemplate.query(query, new DirectorRowMapper());
//    }
//
//    public List<Director> findAllStartWithName(String name, String country) {
//        if (country != null) {
//            final String query = "SELECT * FROM mymovies.directors_list WHERE LOWER(name) "
//                                 + "LIKE LOWER(?) AND country = ? ORDER BY id DESC";
//            return this.jdbcTemplate.query(query, new DirectorRowMapper(),
//                                           String.format("%s%%", name), country);
//        } else {
//            final String query = "SELECT * FROM mymovies.directors_list WHERE LOWER(name) "
//                                 + "LIKE LOWER(?) ORDER BY id DESC";
//            return this.jdbcTemplate.query(query, new DirectorRowMapper(),
//                                           String.format("%s%%", name));
//        }
//    }
//
//    public List<Director> findAllByName(String name, String country) {
//        if (country != null) {
//            final String query = "SELECT * FROM mymovies.directors_list WHERE LOWER(name) "
//                                 + "LIKE LOWER(?) AND country = ? ORDER BY id DESC";
//            return this.jdbcTemplate.query(query, new DirectorRowMapper(), name, country);
//        } else {
//            final String query = "SELECT * FROM mymovies.directors_list WHERE LOWER(name) "
//                                 + "LIKE LOWER(?) ORDER BY id DESC";
//            return this.jdbcTemplate.query(query, new DirectorRowMapper(), name);
//        }
//    }
//
//    public List<Director> findAllByCountry(String country) {
//        final String query = "SELECT * FROM mymovies.directors_list WHERE country = ?";
//        return this.jdbcTemplate.query(query, new DirectorRowMapper(), country);
//    }
//
//    public Director findById(Long id) {
//        final String query = "SELECT * FROM mymovies.directors_list WHERE id = ? ORDER BY id
//        DESC";
//        return this.jdbcTemplate.queryForObject(query, new DirectorRowMapper(), id);
//    }
//}
