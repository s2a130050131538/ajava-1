<%@ page language="java" contentType="text/html"%>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
 Welcome:
<%String name=request.getParameter("username"); %>
<%
out.println(""+name);
%>
<br>Enrollment no:130050131538

</body>
</html>