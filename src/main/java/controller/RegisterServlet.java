package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String pw = request.getParameter("password");;
        String fullname = request.getParameter("fullname");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        UserDao db = (UserDao)getServletContext().getAttribute("db");
        boolean success = db.addUser(email,pw,fullname,telephone,address);
        if (success) {
            Cookie cookie = new Cookie("cart-email", email);
            cookie.setMaxAge(3600);
            Cookie cookie2 = new Cookie("cart-pass", pw);
            cookie2.setMaxAge(3600);
            response.addCookie(cookie2);
            response.addCookie(cookie);

            request.getSession().setAttribute("email", email);
            response.sendRedirect("profile");
        }
        else{
            request.setAttribute("error_login", "Email was be used before. Try different one.");
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
    }
}
