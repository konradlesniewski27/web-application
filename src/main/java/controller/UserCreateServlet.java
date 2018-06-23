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

@WebServlet("/users/create")
public class UserCreateServlet extends HttpServlet {

    private UserDao userDao;
    public UserCreateServlet(){
        this.userDao = new UserDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/create.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. odczytaj dane z requestu
        String firstName = req.getParameter("imie");
        String lastName = req.getParameter("nazwisko");
        String email = req.getParameter("email");
        //2. na podstawie danych utworz obiekt User
        User user = new User(firstName, lastName, email);

        //3. zapisz obiekt User do bazy
        try{
            userDao.save(user);
        } catch (SQLException e){
            e.printStackTrace();
        }

        //4. przekieruj uzytkownika do listy userow
        resp.sendRedirect("/users");
    }
}
