<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     body{
        width: 100%;
        height: 100%;
        background-image: url(/AnimalBridge/view/mainView/white_50.png);
        background-repeat: no-repeat;
        background-size: cover;
    }
    a{
    	text-decoration: none;
    	color: black;
    }
	td{
        width:110px;
        height: 90px;
        text-align: top;
        vertical-align: top;
	}
	td p{
		font-size:10px;
		color:dimgray;
		font-weight:bold;
		line-height:7px;
	}
	td p span{
		color:#EDD200;
	}
    .Cal_day{
        height: 30px;
        text-align: center;
    }
    td:nth-child(1) a{
        color: red;
    }
    td:nth-child(7) a{
        color: blue;
    }
    .ChangeM{
	    width:100%;
	    height:100%;
	    background-color: rgba(255, 255, 255, .2);
	   /*  background-color: transparent; */
	    border:none;
    }
     .seletTime{
       width: 300px;
       height: 300px;
       background-color: #FFFFE4;
       position: absolute;
       top: 25%;
       left: 40%;
       display: none; 
       z-index: 2;
      }
      .modal_layer{
       width: 100%;
       height: 100vh;
       top: 0;
       background-color: rgba(0,0,0,.5);
       position: fixed;
       display: none;
      }
</style>
</head>
<body>
<table align ="center" border ="1" cellpadding="5" cellspacing="0">
	<tr>
<!-- 이전달 버튼 -->
 		<th>
	 	<input type="button" value="이전 달" class="ChangeM" 
	 	onclick="location.href='rev_calendar.do?year=${year}&month=${month-1}'"> 
		</th> 
		
<!-- 제목 만들기 -->
		<th id = "title" colspan = "5">
		${year}년  ${month+1}월
		</th>
		
<!-- 다음달 버튼 -->
 		<th>
	 	<input type="button" value="다음 달" class="ChangeM" 
	 	onclick="location.href='rev_calendar.do?year=${year}&month=${month+1}'"> 
		</th> 
	</tr>
	<tr>
		<td class = "Cal_day">일</td>
		<td class = "Cal_day">월</td>
		<td class = "Cal_day">화</td>
		<td class = "Cal_day">수</td>
		<td class = "Cal_day">목</td>
		<td class = "Cal_day">금</td>
		<td class = "Cal_day">토</td>
	</tr>
	<tr>
	<c:if test="${week >= 2}">
		<c:forEach var="i" begin="1" end="${week-1}" step="1">
		​	<td></td>
		</c:forEach> 
	</c:if>	
	<c:forEach var="i" begin="1" end="${lastday}" step="1">
		<td>
		<a href="#${i}" class="popUp">${i}</a><br>
		
		<c:set var = "day" value = "0${i}"/>
		<c:choose>
		<c:when test="${i ge 10}">
			<c:set var = "day" value = "${fn:substring(day,1,3)}"/>
		</c:when>
		</c:choose>
		
		<c:forEach var="list" items = "${listAll}"> 
 			<c:if test="${day.equals(fn:substring(list.rev_date,8,10))}">
	 			<p>${list.rev_time} <span>예약완료</span></p>
	 		</c:if> 
	 	</c:forEach>
	 	
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

			<div class="seletTime">
				<form name="formm" action="rev_insert.do">
				<p>*시간을 선택해 주세요</p>
					<input type="checkbox" name="revTime" value="10:00~12:00" >10:00~12:00<br>
					<input type="checkbox" name="revTime" value="13:00~15:00" >13:00~15:00<br>
					<input type="checkbox" name="revTime" value="14:00~18:00" >14:00~18:00<br>
					
					<input type="hidden" name="centerIdx" value="${centerIdx}" >
					<input type="hidden" name="animalIdx" value="${animalIdx}" >
					<input type="hidden" name="year" value="${year}" >
					<input type="hidden" name="month" value="${month}" >
					<input type="hidden" name="day" id="day" value="" >
				
				 <button type="submit">예약</button> 
				 </form>
				 <button class="popUp_close">취소</button>
			</div>
				
 <div class="modal_layer"></div>   

 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
 <script>
    $(document).ready(function(){
        $(".popUp").click(function(){
            $(".modal_layer").fadeIn(300,function(){
                $(".seletTime").fadeIn(500);
            });
            
            var day1 = $(this).attr("href");
            var day2 = day1.slice(1,day1.length);
           $('#day').val(day2); 
            
        });
        $(".popUp_close").click(function(){
            $(".seletTime").fadeOut(500,function(){
                $(".modal_layer").fadeOut(300);
            });
        });   
        
    });  
 </script>
</body>
</html>