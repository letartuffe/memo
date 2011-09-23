<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator" %>
<%@page import="com.memo.memo.*" %>


<% String id = (String) session.getAttribute("userid"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>메모 페이지</title>
<script type="text/javascript">


	function modifyConfirm(no){
		viewDivIdNo = "contentView_"+no;
		EditviewDivIdNo = "contentEditView_"+no;  
		document.getElementById(viewDivIdNo).style.visibility = 'hidden';
		document.getElementById(EditviewDivIdNo).style.visibility = 'visible';
	}
	function deleteSubmit(no){
		document.memoForm.mode.value="delete";
		document.memoForm.no.value=no;
		document.memoForm.submit();	
	}
	function editSubmit(no){

		editedContentNo = "editedContent_"+no;
		document.memoForm.mode.value="update";
		document.memoForm.no.value=no;
		document.memoForm.Content.value = document.getElementById(editedContentNo).value;
		
		
		document.memoForm.submit();		
	}
	function writeSubmit(){
		
		document.memoFormWrite.mode.value="write";
		document.memoFormWrite.submit();	
	} 
	function hitEnterKey(e){
	  if(e.keyCode == 13){
		writeSubmit()
	  }else{
	   	e.keyCode == 0;
	  	return;
	  }
	} 
</script>

<style type="text/css">
.contentEditView{visibility: hidden;}
</style>
</head>
<body>

<%@ include file="/login/sessionChk.jsp" %>


<span>한 줄 메모 게시판</span>
<br>


<c:set var="getSize" value="${fn:length(memo)}"/>  

<c:choose>
	<c:when test="${getSize == 0}">
	
	<div id="noMemo">
	<form method="post" action="/memo/Memo" name="memoFormFirst">
	<input type="hidden" name="mode" value="write">
	등록된 메모가 없습니다. &nbsp;<br>
	<input type="text" name="Content">
	<input type="submit" value="메모하기">
	</form>
	</div>


	</c:when>
	
	<c:otherwise>

		<div id="yesMemo">
		
		<form method="post" action="/memo/Memo" name="memoForm">
		<input type="hidden" name="mode">
		<input type="hidden" name="no">
		<input type="hidden" name="Content">
		
		
		<table style="text-align: left; width: 100%;" border="1"
		 cellpadding="2" cellspacing="2">
		  <tbody>
		    <tr>
		      <th style="width: 50px;">no</th>
		      <th style="width: 100px;">ID</th>
		      <th>내용</th>
		      <th style="width: 150px;">등록일</th>
		      <th style="width: 70px;">수정</th>
		      <th style="width: 70px;">삭제</th>
		    </tr>
		<%-- <% Vector<MemoVO> vs = (Vector<MemoVO>)request.getAttribute("memo");  --%>
			
			
			
		<!-- 	Iterator<MemoVO> it = vs.iterator(); -->
		<!-- 	MemoVO temp ;  -->
			
		<!-- 	while(it.hasNext()){ -->
		<!-- 		temp = it.next(); -->
		<!-- 		out.println("<tr>"+ -->
		<!-- 				"<td>"+temp.getNo()+"</td>"+ -->
		<!-- 				"<td>"+temp.getId()+"</td>"+ -->
		<!-- 				"<td>"+temp.getContent()+"</td>"+ -->
		<!-- 				"<td>"+temp.getRegDate()+"</td>"+ -->
		<!-- 				"<td>수정</td>"+ -->
		<!-- 				"<td>삭제</td></tr>"); -->
		
				
		<!-- 	} -->
		
		<!-- %> -->
		<c:forEach items="${memo}" var="vec">
		   <tr>
		      <td>${vec.no}</td>
		      <td>${vec.id}</td>
		      <td><div class="contentView" id="contentView_${vec.no}" name="contentView_${vec.no}">${vec.content}</div>
		      	  <div class="contentEditView" id="contentEditView_${vec.no}" name="contentEditView_${vec.no}"><input type="text" name="editedContent_${vec.no}" id="editedContent_${vec.no}"><input type="button" value="등록"  onclick="editSubmit(${vec.no})"></div></td>
		      <td>${vec.regDate}</td>
		      <td><input value="수정" type="button" onclick="modifyConfirm(${vec.no})" ></td>
		      <td><input value="삭제" type="button" onclick="deleteSubmit(${vec.no})" ></td>
		    </tr>
		</c:forEach>
		
		  </tbody>
		</table>
		
		</form>
		<form method="post" action="/memo/Memo" name="memoFormWrite">
		<input type="hidden" name="mode">
		메모 : 
		<input type="text" name="Content" onKeypress="hitEnterKey(event);">
		<input value="등록" type="button" onclick="writeSubmit();">
		
		</div>
		</form>
	</c:otherwise>
	</c:choose>
</body>
</html>