import dao.UserDaoFileImpl;
import services.UserServices;
import services.UserServicesImpl;

import dao.UserDao;
import dao.UserDaoListImpl;
import user.User;

import java.util.Scanner;

public class Main {
    private static UserDao userDao;
    private static UserServices userServices;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        userDao = new UserDaoListImpl();
        userDao = new UserDaoFileImpl();
        userServices = new UserServicesImpl(userDao);

        boolean quit = false;

        printActions();
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    showAll();;
                    break;

                case 2:
                    addUser();
                    break;

                case 3:
                    updateUser();
                    break;

                case 4:
                    deleteUsers();
                    break;

                case 5:
                    queryUser();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }
    }




    private static void printActions() {
        System.out.println("0  - Выход\n" +
                            "1  - Распечатать список пользователей\n" +
                            "2  - Добавить пользователя\n" +
                            "3  - Обновить пользователя\n" +
                            "4  - Удалить пользователя\n" +
                            "5  - Найти пользователя\n" +
                            "6  - Распечатать список команд.");
        System.out.println("Выберите команду: ");
    }

    private static void showAll(){
        userServices.showAllUsers();

    }

    private static void addUser(){

        System.out.println("Введите ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя пользователя");
        String name = scanner.nextLine();
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        User user = new User(id,name, login, password);
        userServices.addUser(user);
    }

    private static void updateUser() {
        System.out.println("Введите ID пользователя");
        int tempID = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите новое имя пользователя");
        String newName = scanner.nextLine();
        System.out.println("Введите новый логин пользователя");
        String newLogin = scanner.nextLine();
        System.out.println("Введите новый пароль пользователя");
        String newPassword = scanner.nextLine();
        User newUser = new User(tempID, newName, newLogin, newPassword);
        userServices.updateUser(newUser);
    }

    private static void deleteUsers() {
        System.out.println("Введите ID пользователя");
        int tempID = Integer.getInteger(scanner.nextLine());
        userServices.removeUsers(tempID);
    }

    private static void queryUser() {
        System.out.println("Введите id пользователя");
        int id = Integer.parseInt(scanner.nextLine());
        if(userServices.isRegistred(id)){
            System.out.println("Пользователь сущетсвует в базе");
        } else {
            System.out.println("Пользователь не найден");
        }
    }


}
