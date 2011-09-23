<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String id = (String) session.getAttribute("userid");
	session.removeAttribute(id);
	session.invalidate();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그아웃</title>
</head>
<body>
<script type="text/javascript">
	alert("로그아웃 됨");
	location.href="/memo";
</script>
</body>
</html>