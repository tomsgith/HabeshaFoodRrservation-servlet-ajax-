package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    String email="";
    String password = "";
    for (Cookie cookie : req.getCookies()) {
      if (cookie.getName().equals("cart-email")) {
        email = cookie.getValue();
      } else if(cookie.getName().equals("cart-pass")){
        password = cookie.getValue();
      }
    }
    if(!email.isEmpty() && !password.isEmpty()){
      req.setAttribute("emailCk", email);
      req.setAttribute("password", password);
      req.setAttribute("remember", "checked");
    }
    req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("email");
    String pw = req.getParameter("password");

    UserDao uDao = (UserDao)getServletContext().getAttribute("db");

    if(uDao.checkExistUser(email, pw)){
      if((req.getParameter("remember") != null) && req.getParameter("remember").equals("1")){
        Cookie cookie = new Cookie("cart-email", email);
        cookie.setMaxAge(3600);
        Cookie cookie2 = new Cookie("cart-pass", pw);
        cookie2.setMaxAge(3600);
        resp.addCookie(cookie2);
        resp.addCookie(cookie);
      }
      req.getSession().setAttribute("email" , email);

      if(req.getSession().getAttribute("oldServlet") != null){
        String oldServlet = (String) req.getSession().getAttribute("oldServlet");
        req.getSession().setAttribute("oldServlet", null);
        resp.sendRedirect(oldServlet);
      }else{
        resp.sendRedirect("/cart");
      }
    }else{
      req.setAttribute("error_login", "Incorrect email or password");
      req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
    }
  }
}