package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/users/update")
public class UserUpdateServlet extends HttpServlet {

    private UserDao userDao;
    public UserUpdateServlet() {
        this.userDao = new UserDao();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try{
            User user = userDao.findById(id);
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/formularz-edycji.jsp");
            rd.forward(req, resp);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. odbierz dane z formularza
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("imie");
        String lastName = req.getParameter("nazwisko");
        String email = req.getParameter("email");
        //2. stworz obiekt user
        User user = new User(id, firstName, lastName, email);
        //3. wykonaj update z userDao

        //4. przekieruj usera do listy
    }
}
