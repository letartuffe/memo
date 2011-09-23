<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% if(session.getAttribute("userid") == null) {
	%>
<script type="text/javascript">
		alert('세션 없음 로그인 하시오.');
		document.location.href= "/memo/index.jsp";
</script>


<% } %>
