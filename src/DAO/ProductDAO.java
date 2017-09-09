package DAO;

import bean.Product;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static void main(String[] args) {
        System.out.println();
    }

    public Product getProduct(int id) {
        Product result = null;
        try {
            Connection c = DBUtil.getConnection();
            String sql = "SELECT * FROM  product WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new Product();
                result.setId(id);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                result.setName(name);
                result.setPrice(price);
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Product> ListProduct(){
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = util.DBUtil.getConnection();
            System.out.println(connection);
            String sql = "SELECT * FROM product ORDER BY id DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);

                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
