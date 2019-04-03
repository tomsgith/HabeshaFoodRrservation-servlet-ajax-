package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ShoppingCartDao;
import mapper.ProductMapper;

@WebServlet("/shopping-cart/remove")
public class ShoppingCartRemoveServlet extends HttpServlet {
  private ShoppingCartDao shoppingCartDao;
  private ObjectMapper mapper = new ObjectMapper();
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession(true);
    if(session != null && session.getAttribute("shoppingCartDao") != null){
      shoppingCartDao = (ShoppingCartDao) session.getAttribute("shoppingCartDao");
    }else {
      shoppingCartDao = new ShoppingCartDao();
      session.setAttribute("shoppingCartDao", shoppingCartDao);
    }
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();
    List<ProductMapper> products = mapper.readValue(req.getParameter("products"),
                                  mapper.getTypeFactory().constructCollectionType(List.class, ProductMapper.class));
    System.out.println("Removed Items: " + products.toString() );
    List<ProductMapper> removedProducts = new ArrayList<>();
    for (ProductMapper p : products) {
      shoppingCartDao.removeProduct(p.getId());
      ProductMapper removedItem = new ProductMapper();
      removedItem.setId(p.getId());
      removedProducts.add(removedItem);
    }
    writer.print(mapper.writeValueAsString(removedProducts));
    System.out.println("products: " + products.size());
  }
}
