<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>服务器信息异常</h1>
<%
<%--    打印错误信息--%>
    String message=exception.getMessage();
    out.write(message);
%>
</body>
</html>
