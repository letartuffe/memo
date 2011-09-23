<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<% 
String mode = request.getParameter("result");
if(mode.equals("0")){
%>
<script type="text/javascript">
	alert(<%=mode%>);
	function dd(){
		alert("입력하신 사용자 없음");
		document.location.href= "/memo/index.jsp";
	}
</script>	
<%
}else{
%>
<script type="text/javascript">
	function dd(){
		alert(<%=mode%>);
		alert("아이디또는 비밀번호 없음");
		document.location.href= "/memo/index.jsp";
	}
</script>	
<%	
}



%>


</head>
<body onload="javascript:dd();">

</body>
</html>