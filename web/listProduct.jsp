<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  bean.User: Warden
  Date: 2017/9/8
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('a').addClass("btn btn-default btn-xs");

        });
    </script>
    <script>
        $(function () {
            $("input.addCartButton").removeAttr("disable");
            $("input.addCartButton").click(function () {
                $(this).attr("disabled", "disabled");
                var button = $(this);
                var pid = $(this).attr("pid");
                var number = $("input.number[pid=" + pid + "]").val();
                var page = "/addOrderItem";
                $.get(
                    page,
                    {"num": number, "pid": pid},
                    function (result) {
                        $("#addCartSuccessMessage").fadeIn(1200);
                        $("#addCartSuccessMessage").fadeOut(1200,function () {
                            button.removeAttr("disable")
                        });


                    }
                );
            });
        });
    </script>
</head>
<body>
<c:if test="${!empty user}">
    <div align="center">
        当前用户：${user.name}
    </div>
</c:if>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>加入购物车</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>
                <form action="addOrderItem" method="post">

                    数量<input pid="${product.id}" class="number" type="text" value="1" name="num">
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="button" class="addCartButton" pid="${product.id}" value="加入购物车">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
