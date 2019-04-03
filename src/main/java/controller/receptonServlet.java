package controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reception")
public class receptonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao=new UserDao();
        User customer=dao.getUser(request.getParameter("email"));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(customer.getEmail());

        try{
            response.getWriter().print(mapper.writeValueAsString(customer));
        }catch (JsonGenerationException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/reception.jsp").forward(request, response);
    }
}
