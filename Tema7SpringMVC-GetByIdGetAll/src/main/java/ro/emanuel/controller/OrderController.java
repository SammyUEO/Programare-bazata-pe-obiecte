package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.DAO.OrderDAO;
import ro.emanuel.pojo.Order;

@Controller
public class OrderController {
   public OrderController() {
   }

   @GetMapping({"/order"})
   public String singleOrder(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
      Order o = OrderDAO.getById(id);
      model.addAttribute("o", o);
      return "order";
   }

   @GetMapping({"/orders"})
   public String allOrders(Model model) throws ClassNotFoundException, SQLException {
      ArrayList<Order> allOrders = OrderDAO.getAll();
      model.addAttribute("all", allOrders);
      return "orders";
   }
}
