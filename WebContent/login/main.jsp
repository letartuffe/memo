<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String id = (String) session.getAttribute("userid"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main</title>

</head>

<body>

<h1>Session Login success!!</h1>

<%=id%>님이 로그인 하셨습니다.

<a href="/memo/Memo">한줄 메모하기</a>

<form method="post" action="/memo/login/logOut.jsp" name="logOut">
	<input type="submit" value="로그아웃"> 
</form>

<a href="/memo">go index</a>
</body>
</html>