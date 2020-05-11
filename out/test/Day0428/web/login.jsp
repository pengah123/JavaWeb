<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script>
        /*绑定单击事件，修改图片src属性*/
        window.onload=function () {
            var img=document.getElementById("checkCode");
            img.onclick=function () {
                //加时间戳
                var date=new Date().getMilliseconds();
                img.src="/checkCodeServlet?"+date;
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="/loginServlet" method="get">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>

        </tr>
        <tr>
            <td colspan="2"><img id="checkCode" src="/checkCodeServlet" alt=""></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登陆">
            </td>
        </tr>
    </table>
</form>
<div><%=request.getAttribute("error_msg")==null?"":request.getAttribute("error_msg")%></div>
<div><%=request.getAttribute("login_msg")==null?"":request.getAttribute("login_msg")%></div>
</body>
</html>
