package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDao;
import dao.ShoppingCartDao;
import domain.Product;

@WebServlet({"/product-list", ""})
public class ProductListServlet extends HttpServlet {

  private ProductDao productDao = new ProductDao();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    List<Product> allProducts = productDao.getProductByCategoryId(2);
    request.setAttribute("products", allProducts);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
    requestDispatcher.forward(request, response);
  }
}
