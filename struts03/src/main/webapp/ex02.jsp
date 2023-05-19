<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>param</h1>
<a href="ex03.action?id=abcd&pw=1234">link</a>
<form action="ex03.action" method="post">
	<div>
		<label>id</label>
		<input name="id"/>
	</div>
	<div>
		<label>pw</label>
		<input name="pw"/>
	</div>
	<div>
		<button>입력</button>
	</div>
</form>
</body>
</html>