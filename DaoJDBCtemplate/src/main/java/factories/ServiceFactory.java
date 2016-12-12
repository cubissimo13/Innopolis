package factories;

import dao.CarDao;
import dao.UserDao;
import services.UserServices;
import services.UserServicesImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ServiceFactory {
    private static final ServiceFactory instance;
    private UserServices userService;
    private Properties properties;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        properties = new Properties();
        try {
//            properties.load(new FileInputStream("src/main/resources/application.properties"));
            properties.load(new FileInputStream("C:\\Users\\ENDER\\java\\DaoJDBC\\src\\main\\resources\\application.properties"));

            String serviceClassName = properties.getProperty("users.service.class");

            Constructor constructor = Class.forName(serviceClassName).getConstructor(UserDao.class, CarDao.class);
            UserDao userDao = DaoFactory.getInstance().getUsersDao();
            CarDao carDao = DaoFactory.getInstance().getCarDao();
            userService = (UserServices)constructor.newInstance(userDao, carDao);

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

    public UserServices getUserService() {
        return userService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
