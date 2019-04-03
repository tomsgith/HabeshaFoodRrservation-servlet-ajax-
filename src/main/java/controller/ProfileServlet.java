package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = (String)request.getSession().getAttribute("email");

        UserDao db = (UserDao)getServletContext().getAttribute("db");
        User user = db.getUser(email);
        if (user != null) {
            request.setAttribute("user", user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("error_login", "Incorrect email");
            request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(request,response);
        }

    }
}
