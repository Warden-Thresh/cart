package servlet;

import DAO.ProductDAO;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products = new ProductDAO().ListProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("listProduct.jsp").forward(request,response);
    }
}
