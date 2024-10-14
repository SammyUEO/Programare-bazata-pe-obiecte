package emanuel.oop.bdd;

import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Configurare conexiune MySQL
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");

        // Conexiunea la baza de date
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", connectionProps);

        // Inserare în tabela student
        String studentName = "John Doe";
        int studentAge = 21;
        String studentEmail = "john.doe@example.com";

        String sqlInsertStudent = "INSERT INTO student (name, age, email) VALUES (?, ?, ?)";
        PreparedStatement psStudent = conn.prepareStatement(sqlInsertStudent);
        psStudent.setString(1, studentName);
        psStudent.setInt(2, studentAge);
        psStudent.setString(3, studentEmail);
        psStudent.executeUpdate();
        System.out.println("Student inserted successfully.");

        // Inserare în tabela course
        String courseName = "Java Programming";
        int courseDuration = 12;
        String courseTeacher = "Mr. Smith";

        String sqlInsertCourse = "INSERT INTO course (course_name, duration, teacher) VALUES (?, ?, ?)";
        PreparedStatement psCourse = conn.prepareStatement(sqlInsertCourse);
        psCourse.setString(1, courseName);
        psCourse.setInt(2, courseDuration);
        psCourse.setString(3, courseTeacher);
        psCourse.executeUpdate();
        System.out.println("Course inserted successfully.");

        // Actualizare student
        String updateStudent = "UPDATE student SET email = ? WHERE name = ?";
        PreparedStatement psUpdateStudent = conn.prepareStatement(updateStudent);
        psUpdateStudent.setString(1, "new.email@example.com");
        psUpdateStudent.setString(2, "John Doe");
        psUpdateStudent.executeUpdate();
        System.out.println("Student updated successfully.");

        // Actualizare curs
        String updateCourse = "UPDATE course SET duration = ? WHERE course_name = ?";
        PreparedStatement psUpdateCourse = conn.prepareStatement(updateCourse);
        psUpdateCourse.setInt(1, 15);
        psUpdateCourse.setString(2, "Java Programming");
        psUpdateCourse.executeUpdate();
        System.out.println("Course updated successfully.");

        // Afișare date din tabela student
        System.out.println("Students:");
        Statement stmt = conn.createStatement();
        ResultSet rsStudents = stmt.executeQuery("SELECT * FROM student");
        while (rsStudents.next()) {
            int studentId = rsStudents.getInt("id");
            String name = rsStudents.getString("name");
            int age = rsStudents.getInt("age");
            String email = rsStudents.getString("email");
            System.out.println(studentId + " | " + name + " | " + age + " | " + email);
        }

        // Afișare date din tabela course
        System.out.println("Courses:");
        ResultSet rsCourses = stmt.executeQuery("SELECT * FROM course");
        while (rsCourses.next()) {
            int courseId = rsCourses.getInt("id");
            String courseNameRes = rsCourses.getString("course_name");
            int duration = rsCourses.getInt("duration");
            String teacher = rsCourses.getString("teacher");
            System.out.println(courseId + " | " + courseNameRes + " | " + duration + " weeks | " + teacher);
        }

        // Închidere conexiune
        conn.close();
    }
}
