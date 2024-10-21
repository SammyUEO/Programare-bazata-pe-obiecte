package ro.emanuel.violin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.DBHelper;
import ro.emanuel.pojo.Violin;

public class ViolinDAO {

    public static Violin getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM violin WHERE id=?";
        PreparedStatement getViolin = conn.prepareStatement(query);
        getViolin.setInt(1, id);
        
        ResultSet rs = getViolin.executeQuery();
        Violin violin = null;
        if (rs.next()) {
            violin = new Violin(rs.getString("brand"), rs.getString("model"), rs.getInt("strings"));
        }
        DBHelper.closeConnection();
        return violin;
    }

    public static ArrayList<Violin> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM violin";
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Violin> violinList = new ArrayList<Violin>();
        while (rs.next()) {
            String brand = rs.getString("brand");
            String model = rs.getString("model");
            int strings = rs.getInt("strings");
            violinList.add(new Violin(brand, model, strings));
        }
        DBHelper.closeConnection();
        return violinList;
    }

    public static boolean create(Violin violin) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        String query = "INSERT INTO `violin`(`brand`, `model`, `strings`) VALUES (?,?,?)";
        PreparedStatement createViolin = conn.prepareStatement(query);
        
        createViolin.setString(1, violin.getBrand());
        createViolin.setString(2, violin.getModel());
        createViolin.setInt(3, violin.getStrings());
        boolean response = createViolin.executeUpdate() > 0;
        DBHelper.closeConnection();
        return response;
    }

    public static boolean delete(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        String query = "DELETE FROM `violin` WHERE id=?";
        PreparedStatement deleteViolin = conn.prepareStatement(query);
        
        deleteViolin.setInt(1, id);
        boolean response = deleteViolin.executeUpdate() > 0;
        DBHelper.closeConnection();
        return response;
    }

    public static boolean update(Violin violin, int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        String query = "UPDATE `violin` SET `brand`=?, `model`=?, `strings`=? WHERE id=?";
        PreparedStatement updateViolin = conn.prepareStatement(query);
        
        updateViolin.setString(1, violin.getBrand());
        updateViolin.setString(2, violin.getModel());
        updateViolin.setInt(3, violin.getStrings());
        updateViolin.setInt(4, id);
        
        boolean response = updateViolin.executeUpdate() > 0;
        DBHelper.closeConnection();
        return response;
    }
}
