package DAO;

import bean.User;

import java.sql.*;

public class UserDAO {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("hhhh");
        User user2 = new User();
        user2 = user1;
        user2.setName("bvbbb");
        System.out.println(user1.getName());
        System.out.println(new UserDAO());
    }

    public User getUser(String name, String password) {
        User result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8", "root", "admin");

            String sql ="SELECT * FROM user WHERE name = ? AND password = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new User();
                result.setId(rs.getInt(1));
                result.setPassword(password);
                result.setName(name);
            }
            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
