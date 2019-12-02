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
     body{
            width: 100%;
            height: 100%;
            background-image: url(/AnimalBridge/view/mainView/white_50.jpg);
            background-repeat: no-repeat;
            background-size: cover;
    }
    a{
    	text-decoration: none;
    	color: black;
    	
    }
	td{
        width:100px;
        height: 80px;
        text-align: top;
        vertical-align: top;
	}
    .day{
        height: 30px;
        text-align: center;
    }
    td:nth-child(1) a{
        color: red;
    }
    td:nth-child(7) a{
        color: blue;
    }
    
/*     .seletTime{
    width:500px;
    height: 300px;
    border: 1px solid black;
    } */
</style>
</head>
<body>
<table align ="center" border ="1" cellpadding="5" cellspacing="0">
	<tr>
<!-- 이전달 버튼 -->
 		<th>
	 	<input type="button" value="이전 달" 
	 	onclick="location.href='rev_calendar.do?year=${year}&month=${month-1}'"> 
		</th> 
		
<!-- 제목 만들기 -->
		<th id = "title" colspan = "5">
		${year}년  ${month+1}월
		</th>
		
<!-- 다음달 버튼 -->
 		<th>
	 	<input type="button" value="다음 달" 
	 	onclick="location.href='rev_calendar.do?year=${year}&month=${month+1}'"> 
		</th> 
	</tr>
	<tr>
		<td class = "day">일</td>
		<td class = "day">월</td>
		<td class = "day">화</td>
		<td class = "day">수</td>
		<td class = "day">목</td>
		<td class = "day">금</td>
		<td class = "day">토</td>
	</tr>
	<tr>
	<c:if test="${week >= 2}">
		<c:forEach var="i" begin="1" end="${week-1}" step="1">
		​	<td>X</td>
		</c:forEach> 
	</c:if>	
	<c:forEach var="i" begin="1" end="${lastday}" step="1">
		<td><a href="rev_insert.do?centerIdx=${centerIdx}&animalIdx=${animalIdx}&year=${year}&month=${month}&day=${i}">
		${i}</a>
		
		
	<%--<c:forEach var="list" items = "${listAll}"> 
 			<c:if test="${i == list.}">
	 			<c:set var = "i" value = "0+${i}"/>
	 		</c:if> 
	 	</c:forEach>--%>
	 	
		</td>
 		<c:if test="${((i-(1-week)) % 7) == 0}">
 			<tr></tr>
 		</c:if>
	</c:forEach>
	<c:if test="${((lastday-(1-week)) % 7) gt 0}">
		<c:forEach var="i" begin="${((lastday-(1-week)) % 7)}" end="6" step="1">
			<td></td>
	  	</c:forEach> 
  	</c:if>
	</tr>
</table> 

<!-- <div class="seletTime">
	<input type="checkbox" name="time1" value="10:00~12:00" >
	<input type="checkbox" name="time2" value="13:00~15:00" >
	<input type="checkbox" name="time3" value="14:00~18:00" >
</form>
</div> -->

<script>


</script>
</body>
</html>