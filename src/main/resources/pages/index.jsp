<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Hello SpringMVC</title>
</head>
<body>
<h1>Welcome to SpringMVC world!</h1>
<p>
    <img src="<%=path%>/static/img/fileupload.jpg">
</p>
</body>
</html>