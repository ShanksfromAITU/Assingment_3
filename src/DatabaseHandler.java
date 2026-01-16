import java.sql.*;
import java.util.*;

public class DatabaseHandler {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "A1m2i3r4";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    //UPDATE
    public void updateStudentGpa(int id, double gpa) {
        String sql = "UPDATE students SET gpa = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, gpa);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println(">> Student GPA updated!");
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }
    //DELETE
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println(">> Student deleted!");
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }



    // WRITE
    public void addStudent(Student s) {
        String sql = "INSERT INTO students(name, age, gpa) VALUES(?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, s.getName());
            pstmt.setInt(2, s.getAge());
            pstmt.setDouble(3, s.getGpa());
            pstmt.executeUpdate();
            System.out.println(">> Student saved to DB!");
        } catch (SQLException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }

    // READ
    public void readAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | GPA: " + rs.getDouble("gpa"));
            }
        } catch (SQLException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}