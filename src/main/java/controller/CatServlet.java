package controller;

import dao.ProductDao;
import domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cat")
public class CatServlet extends HttpServlet {
    private ProductDao productDao = new ProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramName = "id";
        String paramValue = request.getParameter(paramName);
        List<Product> allProducts;
        if (paramValue!=null) {
            allProducts = productDao.getProductByCategoryId(Integer.parseInt(paramValue));
        }
        else{
            allProducts = productDao.getProductByCategoryId(1);
        }
        request.setAttribute("products", allProducts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
