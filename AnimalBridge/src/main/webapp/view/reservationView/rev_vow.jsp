<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Dancing+Script|Pacifico|Satisfy&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic+Coding&display=swap" rel="stylesheet">

<title>AnimalBridge</title>
<style>
	* {
		padding: 0;
		margin: 0;
		box-sizing: border-box;
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
	

	#wrap_pledge{
        width:70%;
        background-color: rgba(255, 255, 255, 0.5);
        margin: 2% 0 0 23%;
        padding: 4% 0%;
        text-align: center;
    } 
  	
    #subject_wrap{
	 	margin-bottom:50px; 
	 	
	 }
	.subject{
		text-align: center;
	    font-size: 3em;
	    color: #71573e;
	    font-family: 'Do Hyeon', sans-serif; 
    }
	hr{
		width: 80%;
		border: 0;
		height: 2px;
		margin: 0 auto;
		margin-top: -15px;
		background-color: #71573e;
	}
    
    #wrap_text{
    	width:80%;
    	margin:0 auto;
    	text-align: left;
    	line-height: 30px;
    }
    #wrap_button{
        margin-top: 4%;
    }
    
    button{
	    background-color: #71573e;
	    border:0;
	    width:150px;
	    height: 50px;
	    font-family: 'Do Hyeon', sans-serif; 
	    font-size:20px;
	    margin-right: 10px;
    }   
    
    #button1{
	    border-radius: 30px 0px 0px 30px; 
    }
    #button2{
	    border-radius: 0px 30px 30px 0px; 
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
        			<li onclick="location.href='/AnimalBridge/view/reservationView/rev_vow.jsp'">입양예약</li>
        			<li onclick="">자원봉사</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberJoin.jsp'">마이페이지</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogOut.do'">로그아웃</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLeave.jsp'">탈퇴</li>
        		</c:otherwise>
        	</c:choose>
        	
      		  	<li onclick="location.href='/AnimalBridge/view/animalsView/animalsWriter.jsp'">반려동물 등록</li>
            
       	     <li>사이트 소개</li>
      	  </ul>
    	</div>
    	</div>



	<div id="wrap_pledge"> 
	
	   <div id="subject_wrap">
    		<div class="subject">입양서약서</div>
    		<hr>
    	</div>
    	
    	<div id="wrap_text">
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	개인적인 사정으로 인하여 입양한 동물의 사육 및 관리가 더 이상 불가능한 경우 즉시 연락을 하고 동물을 반환
	    	<br>&nbsp;&nbsp;&nbsp;&nbsp;하여야합니다.</p>
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	입양 후, 빠른 시간 안에 입양한 동물에게 이름표를 착용합니다.</p>
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	허가없이 제 3자에게 양도하지 못합니다.</p>
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	외출 시는 이름표와 목줄을 반드시 착용하는 등 보호자로서, 동물보호법을 지켜야합니다.</p>	    
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	과실로 동물을 잃어버린 경우 분양자는 입양자에게 그 책임을 물을 수 있습니다.</p>	
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	입양한 동물로 인하여 발생되는 모든 사고에 대해 민․형사상의 책임을 져야합니다.</p>	
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	입양한 이후 발생되는 내, 외과적 질환에 대해 본 센터에서 책임을 지지 않으며 입양자가 최선을 다해 입양한 
	    	<br>&nbsp;&nbsp;&nbsp;&nbsp;동물의 치료에 책임을 다 해야합니다.</p>	
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	입양한 동물은 임의매도, 식용전용, 타인에게 재입양 및 파양하지 않아야합니다.</p>	
	    <p><i class="fas fa-paw" style="font-size: 17px; color: black;"></i>
	    	적합한 사료의 급여와 급수 ․ 운동 ․ 휴식 ․ 수면이 보장되도록 해야합니다</p>	
	   </div>
	    
	   
	    <div id="wrap_button">      
		    <form action="" method="post" name="formm">
		        <input type="hidden" name="centerIdx" value="${centerIdx}"/>
		        <input type="hidden" name="animalIdx" value="${animalIdx}"/>
		
		        <button onclick="go_back()" id="button1">뒤로가기</button>    
		        <button onclick="check_edu()" id="button2">입양진행</button>
		    </form>
		</div>
</div>  

  
<script>   
	function go_back(){
		document.formm.action="/AnimalBridge/view/animalsView/animalsList.do";
	}  
	function check_edu(){
		document.formm.action="/AnimalBridge/view/reservationView/rev_checkEdu.do";
		document.formm.submit();
	}  
</script>

</body>
</html>