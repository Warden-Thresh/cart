<%--
  Created by IntelliJ IDEA.
  User: Warden
  Date: 2017/9/9
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>购物车</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('a').addClass("btn btn-default btn-xs");

        });
    </script>
</head>
<body>
<h1 align="center">购物车</h1>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${orderItemList}" var="orderItem" varStatus="st">
        <tr>
            <td>${orderItem.product.name}</td>
            <td>${orderItem.product.price}</td>
            <td>${orderItem.num}</td>
            <td>${orderItem.product.price*orderItem.num}</td>
            <td><a href="deleteOrderItem?pid=${orderItem.product.id}">删除</a></td>
        </tr>
    </c:forEach>
    <c:if test="${!empty orderItemList}">
        <tr>
            <td colspan="4" align="right">
                <a href="createOrder">生成订单</a>
            </td>
        </tr>
    </c:if>
</table>
</body>
</html>
