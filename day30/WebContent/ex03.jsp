<%@ page language="java" %>
<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ page  pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>디렉티브 <%out.print(new Date()); %></h1>
	<ul>
		<li>page</li>
		<li>taglib</li>
		<li>include</li>
	</ul>
</body>
</html>