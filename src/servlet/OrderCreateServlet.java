package servlet;

import DAO.OrderDAO;
import DAO.OrderItemDAO;
import bean.Order;
import bean.OrderItem;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderCreateServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            response.sendRedirect("/login.jsp");
            return;
        }
        Order order = new Order();
        order.setUser(user);
        new OrderDAO().insert(order);
        List<OrderItem> orderItemList = (List<OrderItem>) request.getSession().getAttribute("orderItemList");
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrder(order);
            new OrderItemDAO().insert(orderItem);
            System.out.println(orderItem);
        }
        orderItemList.clear();

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("订单创建成功");
    }
}
