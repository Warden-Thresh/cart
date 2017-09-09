package DAO;

import bean.OrderItem;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDAO {
    public static void main(String[] args) {

    }
    public void insert(OrderItem oi) {
        try {
            Connection c = DBUtil.getConnection();
            String sql = "INSERT into orderitem VALUES(null,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, oi.getProduct().getId());
            ps.setInt(2, oi.getNum());
            ps.setInt(3,oi.getOrder().getId());
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
