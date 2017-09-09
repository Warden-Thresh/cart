package servlet;

import bean.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDeleteServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        List<OrderItem> orderItemList = (List<OrderItem>) request.getSession().getAttribute("orderItemList");
        List<OrderItem> orderItems4Delete = new ArrayList<>();
        if (null != orderItemList) {
            for (OrderItem orderItem : orderItemList) {
                if (orderItem.getProduct().getId() == pid) {
                    System.out.println(orderItem.getProduct().getName());
                    orderItems4Delete.add(orderItem);
                }
            }
        }
        orderItemList.removeAll(orderItems4Delete);
        response.sendRedirect("/listOrderItem");
    }
}
