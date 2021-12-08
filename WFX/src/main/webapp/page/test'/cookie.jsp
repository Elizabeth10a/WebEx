<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    boolean flag = false;//没有cookie为lastTime

    if (request.getCookies() != null && request.getCookies().length == 0) {//有cookie 不是第一次
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("As")) {
                flag = true;
                cookie.setMaxAge(10);//有cookie
                cookie.setValue("/有cookie");
                out.print(new Date());
                response.addCookie(cookie);
                System.out.println("cookie存在");

                break;

            }
        }

    } else {
        System.out.println("no cookies ！！！");

    }
%>
<%
    if (request.getCookies() == null || request.getCookies().length == 0 || flag == false) {
        Cookie as = new Cookie("As", "AS");
        as.setMaxAge(10);
        response.addCookie(as);

        System.out.println("  response.addCookie ");
    } else {
        System.out.println("  response.addCookie  all ready");

    }
%>

</body>
</html>
