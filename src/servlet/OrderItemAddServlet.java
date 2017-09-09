package servlet;

import DAO.ProductDAO;
import bean.OrderItem;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemAddServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        Product p = new ProductDAO().getProduct(pid);
        OrderItem orderItem = new OrderItem();
        orderItem.setNum(num);
        orderItem.setProduct(p);

        List<OrderItem> orderItemList = (List<OrderItem>) request.getSession().getAttribute("orderItemList");
        if (null == orderItemList) {
            orderItemList = new ArrayList<>();
            request.getSession().setAttribute("orderItemList", orderItemList);
        }
        boolean found = false;
        for (OrderItem oi : orderItemList) {
            if (orderItem.getProduct().getId() == oi.getProduct().getId()) {
                oi.setNum(oi.getNum() + orderItem.getNum());
                found = true;
                break;
            }
        }
        if (!found) {
            orderItemList.add(orderItem);
        }
    }
}
