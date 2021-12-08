<%@ page import="com.eliza.wfx.model.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    UserModel asr = (UserModel) request.getAttribute("As");
    UserModel ass = (UserModel) session.getAttribute("As");
    if (asr != null) {
        System.out.println("request" + asr.getId());

    } else if (ass!=null){
        System.out.println("session" + ass.getId());
    }else{
        System.out.println("均为null");
    }

%>
</body>
</html>
