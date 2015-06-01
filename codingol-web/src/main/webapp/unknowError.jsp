<%--
  Created by IntelliJ IDEA.
  User: deng
  Date: 15-3-31
  Time: 下午3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        Exception e = (Exception)request.getAttribute("ex");
    %>
    <%= e.getMessage()%>
</body>
</html>
