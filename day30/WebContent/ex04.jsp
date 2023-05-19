<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
	// 자바코드
	out.println("<title>스크립트릿</title>");
	//int su1=4321;
	//out.println(su1);
	%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>스크립트릿</h1>
	<%
	// 자바코드
	int su1=1234;
	// 내장객체의 지원은 스크립트릿에서만 지원
	//out.println("선언부");
	
	%>
	<p>스크립트릿 su1=<%out.print(su1); %></p>
	<p>표현식 su1=<%=su2 %></p>
	<p>선언부</p>
	<%!
		class Inner{}
		int su2=4321;
		public void func(){
			//선언부작성
			System.out.println("선언부");
		}
	%>
</body>
</html>
<%
	// 자바코드
	//func();
%>