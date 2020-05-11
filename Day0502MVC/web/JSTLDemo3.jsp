<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ForEach标签</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    request.setAttribute("list", list);
%>
<c:forEach begin="0" end="10" items="${list}" var="str" step="1" varStatus="s">

    ${s.index} ${s.count} ${str}<br>
</c:forEach>

</body>
</html>
