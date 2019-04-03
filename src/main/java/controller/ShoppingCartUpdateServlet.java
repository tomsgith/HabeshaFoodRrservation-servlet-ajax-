package controller;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ShoppingCartDao;
import mapper.ProductMapper;

@WebServlet("/shopping-cart/update")
public class ShoppingCartUpdateServlet extends HttpServlet {
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
    ProductMapper updatedItem = mapper.readValue(req.getParameter("product"), ProductMapper.class);
    System.out.println("Updated Items: " + updatedItem.toString() );
    shoppingCartDao.updateQty(updatedItem.getId(), updatedItem.getQty());
    resp.setContentType("text/plain");

    writer.write(Integer.toString(shoppingCartDao.getNumberOfProducts()));
  }
}
