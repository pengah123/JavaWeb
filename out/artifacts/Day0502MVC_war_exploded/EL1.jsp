<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Demo.User" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>算术运算符</h3>
${3+4} <br>
${3*4} <br>
${3 div 4} <br>
${3/4} <br>
${3%4} <br>
${3 mod 4} <br>
<h3>比较运算符</h3>

${3>4}
<br>

<h3>空运算符</h3>

<h3>获取值</h3>

<h4>list</h4>
<%
    List list=new ArrayList<>();
    list.add(3);
    list.add("abc");
    User user = new User();
    user.setName("zhagnsan");
    user.setPassword("123456");
    list.add(user);
    request.setAttribute("list",list);
    request.setAttribute("user",user);
%>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[2].name}<br>
${list[2].password}<br>
${user.name}<br>

<h4>map</h4>
<%
    Map map=new HashMap();
    map.put("sname","张三");
    map.put("gender","女");
    request.setAttribute("map",map);
%>
${map["sname"]}<br>
${map.gender}<br>
</body>
</html>
