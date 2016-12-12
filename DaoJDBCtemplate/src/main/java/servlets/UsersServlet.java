package servlets;

import factories.ServiceFactory;
import model.User;
import services.UserServices;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class UsersServlet extends HttpServlet {
    private UserServices userService = ServiceFactory.getInstance().getUserService();
    private List<User> tmpList;

    @Override
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            throw new IllegalStateException();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String city = request.getParameter("city");

        User user = User.newBuilder().setName(name).setAge(age).setCity(city).build();
        userService.addUser(user);
//        request.setAttribute("user_list", tmpList);
        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        tmpList = userService.showAllUsers();
        request.setAttribute("user_list", tmpList);
        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);

    }
}
