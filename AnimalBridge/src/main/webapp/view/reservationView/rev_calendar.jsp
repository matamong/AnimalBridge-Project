<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
	background-color: white;
	width:100px;
	}
</style>
</head>
<body>


<table width ="700" align ="center" border ="1" cellpadding="5" cellspacing="0">
	<tr>
<!-- 이전달 버튼 -->
 		<th>
	 	<input type="button" value="이전 달" onclick="?year=${year}&month=${month-1}'"> 
		</th> 
		
<!-- 제목 만들기 -->
		<th id = "title" colspan = "5">
		${year}년  ${month}월
		</th>
		
<!-- 다음달 버튼 -->
 		<th>
	 	<input type="button" value="다음 달" onclick="?year=${year}&month=${month+1}'"> 
		</th> 
	</tr>
	<tr>
		<td class = "sunday">일</td>
		<td class = "etcday">월</td>
		<td class = "etcday">화</td>
		<td class = "etcday">수</td>
		<td class = "etcday">목</td>
		<td class = "etcday">금</td>
		<td class = "saturday">토</td>
	</tr>
	<tr>
	<c:if test="${week gt 2}">
		<c:forEach var="i" begin="0" end="${week-2}" step="1">
		​	<td>X</td>
		</c:forEach> 
	</c:if>	
	<c:forEach var="i" begin="1" end="${lastday}" step="1">
		<c:choose>
			<c:when test="${i lt 10}">
		 		<td>0${i}</td>
		 		<c:if test="${((i-(1-week)) % 7) == 0}">
		 			<tr></tr>
		 		</c:if>
		 	</c:when>
		 	<c:when test="${i ge 10}">
		 		<td>${i}</td>
		 		<c:if test="${((i-(1-week)) % 7) == 0}">
		 			<tr></tr>
		 		</c:if>
		 	</c:when>
		</c:choose>
	</c:forEach>  
	</tr>
</table> 
<script>


</script>
</body>
</html>