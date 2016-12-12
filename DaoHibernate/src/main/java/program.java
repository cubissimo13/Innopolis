import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserServicesImpl;


public class program {


    public static void main(String[] args) {
        User tmpUser = new User("ivan",12, "rkf");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserServicesImpl service = (UserServicesImpl) context.getBean("service");
        System.out.println(service.showAllUsers());
//        service.addUser(tmpUser);
//        System.out.println(service.showAllCars());
//        System.out.println(service.findUser(1));
    }
}
