import factories.ServiceFactory;
import model.*;
import services.UserServices;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private static User tmpUser;
    private static Car tmpCar;
    private static UserServices userService = ServiceFactory.getInstance().getUserService();

    public static void main(String[] args) {

//        tmpUser = User.newBuilder().setId(3).setName("Masha").setAge(24).setCity("msc").build();
//        tmpCar = Car.newBuilder().setId(4).setModel("Mazda").setOwnerId(1).setTrip(10000).build();
//        userService.addCar(tmpCar);
//        showAllUsers();
//        showAllCar();
//        userService.updateUser(tmpUser);
//        userService.delCar(3);
//        System.out.println(userService.findCar(4));
//        userService.updateCar(tmpCar);

        List<User> tmpListUser = userService.showAllUsers();
        for (User user : tmpListUser) {
            System.out.println("Машины для " + user.getName());
            List<Car> tmpListCar = userService.showAllCarsByOwner(user.getId());
            for (Car car : tmpListCar) {
                System.out.println(car);
            }
        }
    }

    private static void showAllUsers() {
        List<User> tempList = new ArrayList<User>(userService.showAllUsers());
        for (User currentUser : tempList){
            System.out.println(currentUser);

        }
    }

    private static void showAllCar(){
        List<Car> tempList = new ArrayList<Car>(userService.showAllCars());
        for (Car currentCar : tempList){
            System.out.println(currentCar);
        }
    }
}

