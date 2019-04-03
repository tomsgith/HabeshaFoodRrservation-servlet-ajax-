package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ShoppingCartDao;
import dao.UserDao;
import domain.CartProduct;
import domain.Order;
import domain.OrderItem;
import domain.User;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

  private ShoppingCartDao shoppingCartDao;
  private ObjectMapper mapper = new ObjectMapper();
  private UserDao db;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession(true);
    if (session != null && session.getAttribute("shoppingCartDao") != null) {
      shoppingCartDao = (ShoppingCartDao) session.getAttribute("shoppingCartDao");
    } else {
      shoppingCartDao = new ShoppingCartDao();
      session.setAttribute("shoppingCartDao", shoppingCartDao);
    }

    db = (UserDao)getServletContext().getAttribute("db");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    User user = db.getUser((String) req.getSession().getAttribute("email"));
    req.setAttribute("user", user);
    req.getRequestDispatcher("/WEB-INF/jsp/checkout.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse resp)
      throws ServletException, IOException {

    if (request.getParameter("order") != null) {
      Order order = mapper.readValue(request.getParameter("order"), Order.class);
      HttpSession session = request.getSession();
      String email = (String)session.getAttribute("email");
      User user = db.getUserByEmail(email);
      order.setUserId(user.getId());
      List<OrderItem> items = new ArrayList<>();
      // build the item list
      for (CartProduct cart: shoppingCartDao.getMyCart()) {
        OrderItem item = new OrderItem(UUID.randomUUID().toString(),cart.getQty(), cart.getProduct());
        items.add(item);
      }
      order.setOrderItems(items);
      request.getSession().setAttribute("shoppingCartDao", null);
    }

    resp.getWriter().print("success");
  }
}
