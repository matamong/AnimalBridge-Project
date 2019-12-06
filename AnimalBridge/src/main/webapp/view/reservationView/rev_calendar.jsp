<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Calendar" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnimalBridge</title>
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Dancing+Script|Pacifico|Satisfy&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic+Coding&display=swap" rel="stylesheet">

<style>
	* {
		padding: 0;
		margin: 0;
	}
	#background {
		position: fixed;
		width: 100%;
		height: 100%;
		background-image: url(/AnimalBridge/view/mainView/white.jpg);
		background-repeat: no-repeat;
		background-size: cover;
		opacity: 0.5;
		top:0;
		left:0;
		z-index:-10;
	}
	#wrap_sideBar {
		width: 18%;
		height: 100%;
		position: fixed;
		top: 0;
		left: 0;
		z-index:2;
	}	
	#sideBar {
		background-color: rgba(0, 0, 0, 0.6);
		width: 250px;
		height: 100%;
		position: absolute;
		font-family: 'Jua', sans-serif;
		font-size: 30px;
		top: 0;
		left: 0px;
	}
	#sideBar ul {
		list-style: none;
		color: white;
		z-index: 3;
	}
	#sideBar ul li {
		margin: 10px;
		padding: 10px;
	}
	#sideBar ul li:hover {
		color: wheat;
		background-color: rgba(0, 0, 0, 0.5);
		cursor: pointer;
	}
	#side_menu p {
		text-align: center;
		font-size: 50px;
	}	
	
		
		
	#wrap_calendar{
        margin: 5% 0 0 28%; 
    } 	
    a{
    	text-decoration: none;
    	color: black;
    }
    tr{
    	background-color: rgba(255, 255, 255, 0.5);
    }
	td{
        width:120px;
        height: 90px;
        text-align: top;
        vertical-align: top;
        padding:2px 0 0 2px;
	}
	td p{
		font-size:11px;
		color:dimgray;
		font-weight:bold;
		line-height:13px;
	}
	td p span{
		color:#EDD200;
	}
    .Cal_day{
        height: 30px;
        text-align: center;
        font-family: 'Jua', sans-serif;
        line-height:30px;
    }
    td:nth-child(1) a{
        color: red;
    }
    td:nth-child(7) a{
        color: blue;
    }
    
    
    
    
    #wrap_calendar_btn{
    	display: flex;
    	margin-left:80px;
    
    }
    .ChangeM{
	    width:100px;
	    height:40px;;
	    margin: 0 0 10px 0;
	    cursor: pointer;
	    background-color: #71573e;
	    color: #242424;
	    font-size:20px;
	    font-family: 'Jua', sans-serif;
		box-shadow:inset 0px 1px 0px 0px #a6827e;
		background:linear-gradient(to bottom, #7d5d3b 5%, #634b30 100%);
		border:1px solid #54381e;
    }
    .ChangeM:hover{
	    background:linear-gradient(to bottom, #634b30 5%, #7d5d3b 100%);
		background-color:#634b30;
    }
    
    .M1{
	    border-radius: 30px 0px 0px 30px; 
    }
    .M2{
	    border-radius: 0px 30px 30px 0px; 
    }	
 	#top_calendar{
 		font-size:40px;
 		font-family: 'Jua', sans-serif;
 		color: #363636;
 		margin: 0 150px;
 		margin-top:-10px;
 		text-shadow: 1.5px 1.5px 0.1px dimgray;
 		
 	}   
    
     .seletTime{
	       width: 300px;
	       height: 300px;
	       background-color: #FFFFE4;
	       position: absolute;
	       top: 25%;
	       left: 45%;
	       display: none; 
	       z-index: 2;
	       font-family: 'Jua', sans-serif;
	       text-align: center;
      }
      
      .seletTime p{
      		margin: 20px;
      		font-size:20px;
      }
      
      #time_checkbox{
      		margin: 20px 0 50px 0px;
      }
      #btn1{
      		width:150px;
      		height:30px;
      		cursor: pointer;
	    	background-color: #71573e;
	    	font-family: 'Jua', sans-serif;
			box-shadow:inset 0px 1px 0px 0px #a6827e;
			background:linear-gradient(to bottom, #7d5d3b 5%, #634b30 100%);
			border:1px solid #54381e;
			margin-bottom:10px
      }
      #btn2{
      		width:150px;
      		height:30px;
      		cursor: pointer;
	    	font-family: 'Jua', sans-serif;
			box-shadow:inset 0px 1px 0px 0px #EAEAEA;
			background:linear-gradient(to bottom, #FFFFFF 5%, #EAEAEA 100%);
			border:1px solid #EAEAEA;
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
<div id="background"></div>
<div id="wrap_sideBar">
		<div id="sideBar">
       	 <ul>
        	<c:choose>
        		<c:when test="${empty memberLogInNickName}">
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogInForm.do'">로그인</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberJoinForm.do'">회원가입</li>
        		</c:when>
        		
        		<c:otherwise>
        			<h3>Hello, ${memberLogInNickName}</h3>
        			<c:if test="${memberLogInGrade eq 'protectCenter'}">
        				<li onclick="location.href='#'">직원관리</li>
        			</c:if>
        			
        			<c:if test="${memberLogInGrade eq 'protector'}">
        				<li onclick="location.href='#'">동물관리</li>
        			</c:if>
        			<li onclick="location.href='/AnimalBridge/view/index.jsp'">홈으로</li>
        			<li onclick="location.href='/AnimalBridge/view/happyBoardView/happyBoard.do'">저 행복해요</li>
        			<li onclick="location.href='/AnimalBridge/view/animalsView/animalsList.do'">입양예약</li>
        			<li onclick="">자원봉사</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberJoin.do'">마이페이지</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogOut.do'">로그아웃</li>
        		</c:otherwise>
        	</c:choose>
        	
            
       	     <li>사이트 소개</li>
      	  </ul>
    	</div>
    	</div>

<div id="wrap_calendar">

	<div id="wrap_calendar_btn">
	 	<input type="button" value="이전 달" class="ChangeM M1" 
	 	onclick="location.href='rev_calendar.do?year=${year}&month=${month-1}'"> 
	
		<div id="top_calendar">${year}년  ${month+1}월</div>
		
	 	<input type="button" value="다음 달" class="ChangeM M2" 
	 	onclick="location.href='rev_calendar.do?year=${year}&month=${month+1}'"> 
	</div>


<table align ="center" border="1" cellpadding="5" cellspacing="0">
	
	<tr>
		<td class = "Cal_day" style="color:red;">일</td>
		<td class = "Cal_day">월</td>
		<td class = "Cal_day">화</td>
		<td class = "Cal_day">수</td>
		<td class = "Cal_day">목</td>
		<td class = "Cal_day">금</td>
		<td class = "Cal_day" style="color:blue;">토</td>
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
				<p>시간을 선택해 주세요</p>
				
				<div id="time_checkbox">
					<input type="checkbox" name="revTime" value="10:00~12:00" >10:00~12:00<br>
					<input type="checkbox" name="revTime" value="13:00~15:00" >13:00~15:00<br>
					<input type="checkbox" name="revTime" value="14:00~18:00" >14:00~18:00<br>
					
					<input type="hidden" name="centerIdx" value="${centerIdx}" >
					<input type="hidden" name="animalIdx" value="${animalIdx}" >
					<input type="hidden" name="year" value="${year}" >
					<input type="hidden" name="month" value="${month}" >
					<input type="hidden" name="day" id="day" value="" >
				</div>
				 <button type="submit" id="btn1">예약</button> 
				 </form>
				 <button class="popUp_close" id="btn2">취소</button>
			</div>
			
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
        
        $("input[type='checkbox']").on("click", function(){
        	var count = $("input:checked[type='checkbox']").length;
        	
        	if(count>1){
        		$(this).attr("checked", false);
        		alert("예약은 하루에 한번만 가능합니다.");
        	}
        });   
    });  
 </script>
</body>
</html>