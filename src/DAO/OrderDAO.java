package DAO;

import bean.Order;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
    public void insert(Order o) {
        try {
            Connection c = DBUtil.getConnection();
            String sql = "INSERT INTO order_ VALUE (NULL ,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,o.getUser().getId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                o.setId(id);
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
