package dao;
import model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoJdbcImpl implements UserDao {

    // language=SQL
    private static final String SQL_SELECT_ALL_USER =
            "SELECT * FROM person;";

    // language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO person(name, age, city) VALUES(:name, :age, :city);";

    // language=SQL
    private static final String SQL_DELETE_USER =
            "DELETE FROM person WHERE id = :userId;";

    // language=SQL
    private static final String SQL_SELECT_USER =
            "SELECT * FROM person WHERE id = :userId;";

    // language=SQL
    private static final String SQL_UPDATE_USER =
            "UPDATE person SET name = :name, age = :age, city= :city WHERE id = :userId;";

    private NamedParameterJdbcTemplate template;

    public UserDaoJdbcImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            int userId = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            int userAge = resultSet.getInt("age");
            String userCity = resultSet.getString("city");
            return User.newBuilder().setId(userId).setName(userName).setAge(userAge).setCity(userCity).build();
        }
    };

    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL_USER, userRowMapper);
    }

    public User find(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", id);
        return template.queryForObject(SQL_SELECT_USER, params, userRowMapper);
    }

    public void save(User user) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("name",user.getName());
        params.put("age", user.getAge());
        params.put("city", user.getCity());
        template.update(SQL_INSERT_USER, params);
    }

    public void delete(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", id);
        template.update(SQL_DELETE_USER, params);
    }

    public void update(User user) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("userId", user.getId());
        params.put("name",user.getName());
        params.put("age", user.getAge());
        params.put("city", user.getCity());
        template.update(SQL_UPDATE_USER, params);
    }
}
