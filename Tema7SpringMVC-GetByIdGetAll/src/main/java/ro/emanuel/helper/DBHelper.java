package ro.emanuel.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
   private static Connection conn;

   public DBHelper() {
   }

   public static Connection getConnection() throws SQLException, ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");
      if (conn == null || conn.isClosed()) {
         Properties connectionProps = new Properties();
         connectionProps.put("user", "root");
         connectionProps.put("password", "");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024", connectionProps);
      }

      return conn;
   }

   public static void closeConnection() throws SQLException {
      conn.close();
   }
}