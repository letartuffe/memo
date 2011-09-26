<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function go(){
		window.opener.location.href="index.jsp";
		
		document.ii.submit();

		window.close();
		
	}
	function hitEnterKey(e){
		  if(e.keyCode == 13){
			go();
		  }else{
		   	e.keyCode == 0;
		  	return;
		  }
	} 
</script>
</head>
<body>
<form action="NewFile.html" method="post" name="ii">
<input type="text" onKeypress="hitEnterKey(event);">
<input type="button" onclick="go();">
</form>
</body>
</html>