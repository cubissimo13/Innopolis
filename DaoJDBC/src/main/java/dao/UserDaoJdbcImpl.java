package dao;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    private Connection connection;

    // language=SQL
    private static final String SQL_SELECT_ALL_USER =
            "SELECT * FROM person ORDER BY id;";

    // language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO person(name, age, city) VALUES(?, ?, ?);";

    // language=SQL
    private static final String SQL_DELETE_USER =
            "DELETE FROM person WHERE id = ?;";

    // language=SQL
    private static final String SQL_SELECT_USER =
            "SELECT * FROM person WHERE id = ?;";

    // language=SQL
    private static final String SQL_UPDATE_USER =
            "UPDATE person SET name = ?, age = ?, city= ? WHERE id = ?;";

    public UserDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USER);
            List<User> resultList = new ArrayList<User>();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("name");
                int userAge = resultSet.getInt("age");
                String userCity = resultSet.getString("city");
                User user = User.newBuilder().setId(userId).setName(userName).setAge(userAge).setCity(userCity).build();
                resultList.add(user);
            }
            return resultList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public User find(int id) {
        PreparedStatement preparedStatement = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int userId = result.getInt("id");
                String userName = result.getString("name");
                int userAge = result.getInt("age");
                String userCity = result.getString("city");
                user = User.newBuilder().setId(userId).setName(userName).setAge(userAge).setCity(userCity).build();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return user;
    }

    public void save(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getCity());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void update(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getCity());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
