package ro.emanuel.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Phone;

public class PhoneDAO {
	   public PhoneDAO() {
	   }

	   public static Phone getById(int id) throws SQLException, ClassNotFoundException {
	      Connection conn = DBHelper.getConnection();
	      String query = "select * from phone where id=?";
	      PreparedStatement ps = conn.prepareStatement(query);
	      ps.setInt(1, id);
	      ResultSet rs = ps.executeQuery();
	      if (rs.next()) {
	         Phone phone = new Phone(rs.getInt("id"), rs.getString("brand"), rs.getDouble("price"), rs.getInt("ram"), rs.getInt("storage"));
	         DBHelper.closeConnection();
	         return phone;
	      } else {
	         DBHelper.closeConnection();
	         return null;
	      }
	   }

	   public static ArrayList<Phone> getAll() throws ClassNotFoundException, SQLException {
	      Connection conn = DBHelper.getConnection();
	      String query = "select * from phone";
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ArrayList<Phone> phones = new ArrayList<Phone>();

	      while(rs.next()) {
	         Phone phone = new Phone(rs.getInt("id"), rs.getString("brand"), rs.getDouble("price"), rs.getInt("ram"), rs.getInt("storage"));
	         phones.add(phone);
	      }

	      DBHelper.closeConnection();
	      return phones;
	   }
	}
