package StudentRegistration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student s) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name,email,course) VALUES(?,?,?)");
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());
        ps.executeUpdate();
        con.close();
    }

    public List<Student> getAllStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course")
            ));
        }
        con.close();
        return list;
    }

    public void updateStudent(Student s) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, email=?, course=? WHERE id=?");
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());
        ps.setInt(4, s.getId());
        ps.executeUpdate();
        con.close();
    }

    public void deleteStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
