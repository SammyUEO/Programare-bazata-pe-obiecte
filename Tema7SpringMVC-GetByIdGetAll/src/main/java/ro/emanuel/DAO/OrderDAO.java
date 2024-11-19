package ro.emanuel.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Order;

public class OrderDAO {
   public OrderDAO() {
   }

   public static Order getById(int id) throws SQLException, ClassNotFoundException {
      Connection conn = DBHelper.getConnection();
      String query = "select * from orders where id=?";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
         Order order = new Order(rs.getInt("id"), rs.getString("customerName"), rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"));
         DBHelper.closeConnection();
         return order;
      } else {
         DBHelper.closeConnection();
         return null;
      }
   }

   public static ArrayList<Order> getAll() throws ClassNotFoundException, SQLException {
      Connection conn = DBHelper.getConnection();
      String query = "select * from orders";
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);
      ArrayList<Order> orders = new ArrayList<Order>();

      while(rs.next()) {
         Order order = new Order(rs.getInt("id"), rs.getString("customerName"), rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"));
         orders.add(order);
      }

      DBHelper.closeConnection();
      return orders;
   }

}
