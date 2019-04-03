package controller;




import dao.ProductDao;
import domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private ProductDao productDao = new ProductDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramName = "id";
        String paramValue = request.getParameter(paramName);
        Product product = productDao.getProductById(Integer.parseInt(paramValue));
        if (product != null){
            request.setAttribute("product", product);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/product.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("error_login", "Incorrect product");
            request.getRequestDispatcher("/WEB-INF/jsp/product.jsp").forward(request,response);
        }
    }
}
