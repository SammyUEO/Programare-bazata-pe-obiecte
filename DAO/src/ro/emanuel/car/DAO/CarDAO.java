package ro.emanuel.car.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.DBHelper;
import ro.emanuel.pojo.Car;

public class CarDAO {
    
    public static Car getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM car where id=?";
        PreparedStatement getCar = conn.prepareStatement(query);
        getCar.setInt(1, id);
        
        ResultSet rs = getCar.executeQuery();
        Car car = null;
        if (rs.next())
            car = new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getDouble("fabrication"));
        DBHelper.closeConnection();
        if (car != null)
            return car;
        return null;
    }
    
    public static ArrayList<Car> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM car";
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Car> carList = new ArrayList<Car>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            String model = rs.getString("model");
            Double fabrication = (double) rs.getInt("fabrication");
            carList.add(new Car(id, brand, model, fabrication));
        }
        DBHelper.closeConnection();
        return carList;
    }
    
    public static boolean create(Car car) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        String query = "INSERT INTO `car`(`brand`, `model`, `fabrication`) VALUES (?,?,?)";
        PreparedStatement createCar = conn.prepareStatement(query);
        
        createCar.setString(1, car.getBrand());
        createCar.setString(2, car.getModel());
        createCar.setDouble(3, car.getFabrication());
        boolean response = createCar.executeUpdate() > 0;
        DBHelper.closeConnection();
        return response;
    }
    
    public static boolean delete(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        String query = "DELETE FROM `car` WHERE id=?";
        PreparedStatement deleteCar = conn.prepareStatement(query);
        
        deleteCar.setInt(1, id);
        
        boolean response = deleteCar.executeUpdate() > 0;
        DBHelper.closeConnection();
        return response;
    }
    
    public static boolean update(Car car) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        String query = "UPDATE `car` SET `brand`=?, `model`=?, `fabrication`=? WHERE id=?";
        PreparedStatement updateCar = conn.prepareStatement(query);
        
        updateCar.setString(1, car.getBrand());
        updateCar.setString(2, car.getModel());
        updateCar.setDouble(3, car.getFabrication());
        
        
        boolean response = updateCar.executeUpdate() > 0;
        DBHelper.closeConnection();
        return response;
    }
}
