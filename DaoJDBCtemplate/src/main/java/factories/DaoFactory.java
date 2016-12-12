package factories;
        import dao.CarDao;
        import dao.UserDao;

        import javax.sql.DataSource;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.lang.reflect.Constructor;
        import java.lang.reflect.InvocationTargetException;
        import java.sql.Connection;
        import java.util.Properties;

public class DaoFactory {
    private static DaoFactory instance;
    private UserDao userDao;
    private CarDao carDao;
    private Properties properties;

    static {
        instance = new DaoFactory();
    }

    private DaoFactory() {
        properties = new Properties();
        try {
//            properties.load(new FileInputStream("src/main/resources/application.properties"));
            properties.load(new FileInputStream("C:\\Users\\ENDER\\java\\DaoJDBC\\src\\main\\resources\\application.properties"));

            String daoUserClassName = properties.getProperty("users.dao.class");
            String daoCarClassName = properties.getProperty("cars.dao.class");

            Constructor constructor = Class.forName(daoUserClassName).getConstructor(DataSource.class);
            userDao = (UserDao)constructor.newInstance(DataSourceFactory.getInstance().getDataSource());
            constructor = Class.forName(daoCarClassName).getConstructor(Connection.class);
            carDao = (CarDao)constructor.newInstance(ConnectionFactory.getInstance().getConnection());

        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public UserDao getUsersDao() {
        return userDao;
    }

    public CarDao getCarDao() {
        return carDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}
