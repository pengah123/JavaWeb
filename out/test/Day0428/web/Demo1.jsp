<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2020/4/30
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    response.getWriter().write("response...");
%>
<%
    String contextPath = request.getContextPath();
    out.write(contextPath);
%>
</body>
</html>
