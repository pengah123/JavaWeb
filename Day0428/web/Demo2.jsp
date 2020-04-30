<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setContentType("text/html;charset=utf-8");
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies != null && cookies.length != 0) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lt")) {
                String value = cookie.getValue();
                String decodevalue = URLDecoder.decode(value, "utf-8");
                out.write("欢迎访问，上一次访问时间是：" + decodevalue);
                flag = true;
                break;
            }
        }
    }

    if (!flag) {
        out.write("欢迎访问,这是第一次访问");
    }
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    Date data = new Date();
    String date = df.format(data);
    String encodedate = URLEncoder.encode(date, "utf-8");
    Cookie lt = new Cookie("lt", encodedate);
    lt.setMaxAge(60 * 60 * 24 * 30);
    response.addCookie(lt);
%>
</body>
</html>
