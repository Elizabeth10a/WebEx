<%@ page import="com.eliza.wfx.model.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--   src/main/webapp/page/index.jsp--%>

<%
    UserModel userModel = new UserModel();
    userModel.setId(12L);

    request.setAttribute("As", userModel);
    session.setAttribute("As",userModel);
%>
<button>
    点击
    <a href="index2.jsp">index2</a>

</button>
<%

    UserModel as = (UserModel) request.getAttribute("As");
    as.setId(12L);
    System.out.println("request"+as.getId());

%>
</body>

</html>
