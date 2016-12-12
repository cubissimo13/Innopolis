package dao;

import model.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoJdbcImpl implements CarDao {
    private Connection connection;

    // language=SQL
    private static final String SQL_SELECT_CARS =
            "SELECT * FROM cars;";

    //Language=SQL
    private static final String SQL_INSERT_CAR =
            "INSERT INTO cars (model, ownerid, trip) VALUES(?, ?, ?);";

    // language=SQL
    private static final String SQL_DELETE_CAR =
            "DELETE FROM cars WHERE id = ?;";

    // language=SQL
    private static final String SQL_SELECT_CAR =
            "SELECT * FROM cars WHERE id = ?;";

    // language=SQL
    private static final String SQL_UPDATE_CAR =
            "UPDATE cars SET model = ?, trip = ?, ownerid= ? WHERE id = ?;";

    // language=SQL
    private static final String SQL_FIND_BY_OWNER =
            "SELECT * FROM cars WHERE ownerid = ?;";


    public CarDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Car> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_CARS);
            List<Car> resultList = new ArrayList<Car>();

            while (resultSet.next()) {
                int carId = resultSet.getInt("id");
                String model = resultSet.getString("model");
                int ownerId = resultSet.getInt("ownerid");
                int trip = resultSet.getInt("trip");
                Car car = Car.newBuilder().setId(carId).setModel(model).setOwnerId(ownerId).setTrip(trip).build();
                resultList.add(car);
            }

            return resultList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Car find(int id) {
        PreparedStatement preparedStatement = null;
        Car car = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_CAR);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int carId = result.getInt("id");
                String carModel = result.getString("model");
                int carTrip = result.getInt("trip");
                int carOwnerId = result.getInt("ownerid");
                car = Car.newBuilder().setId(carId).setModel(carModel).setTrip(carTrip).setOwnerId(carOwnerId).build();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return car;
    }

    public void save(Car car) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_CAR);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getOwnerId());
            preparedStatement.setInt(3, car.getTrip());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_CAR);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void update(Car car) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_CAR);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getTrip());
            preparedStatement.setInt(3, car.getOwnerId());
            preparedStatement.setInt(4, car.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<Car> findByOwner(int userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_OWNER);
            preparedStatement.setInt(1, userId);
            ResultSet result = preparedStatement.executeQuery();
            List<Car> resultList = new ArrayList<Car>();

            while (result.next()) {
                int carId = result.getInt("id");
                String model = result.getString("model");
                int ownerId = result.getInt("ownerid");
                int trip = result.getInt("trip");
                Car car = Car.newBuilder().setId(carId).setModel(model).setOwnerId(ownerId).setTrip(trip).build();
                resultList.add(car);
            }

            return resultList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
