<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% if(session.getAttribute("userid") == null) {
	%>
<script type="text/javascript">
		alert('���� ���� �α��� �Ͻÿ�.');
		document.location.href= "/memo/index.jsp";
</script>


<% } %>
