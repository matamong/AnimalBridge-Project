<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
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

	
	#wrap_animalList{
	    width:70%;
        background-color: rgba(255, 255, 255, 0.5);
        margin: 2% 0 0 23%;
        padding-top:4%;
        text-align: center;
	}
    #subject_wrap{
	 	margin-bottom:20px; 
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
		margin-top: -17px;
		background-color: #71573e;
	}
	#list{
		margin: 1% 0 0 10%;
	}
	#list img {
		width: 50px;
	}
	#pageIdx{
		margin: 10px 0 20px -120px;
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
		margin-bottom:50px
	}
	#btn1:hover{
		background:linear-gradient(to bottom, #634b30 5%, #7d5d3b 100%);
		background-color:#634b30;
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


<div id="wrap_animalList">	
	<div id="subject_wrap">
	<div class="subject">입양하기</div>
	<hr/>
	</div>	
		<%-- <p>totalAnimalsPageCnt : ${totalAnimalsPageCnt}</p>
		<p>animalsListCurrentPage : ${animalsListCurrentPage}</p>
		<p>animalsListBeginPage : ${animalsListBeginPage}</p>
		<p>animalsListEndPage : ${animalsListEndPage}</p>
		<p>requestAnimalType : ${requestAnimalType}</p> 
		<h3>현재 페이지 : ${animalsListCurrentPage + 1}</h3>--%>
		
		<form action="" method="GET" name="formm">
			종류 : <input type="text" name="requestAnimalType" value="${requestAnimalType}" >
			
			
		<div id="list">
			<table border="1">
				<tr>
					<td>번호</td>
					<td>동물번호</td>
					<td>센터번호</td>
					<td>종류</td>
					<td>품종</td>
					<td>성별</td>
					<td>중성화여부</td>
					<td>예방접종</td>
					<td>특징</td>
					<td>사진1</td>
					<td>사진2</td>
					<td>사진3</td>
					<td>사진4</td>
					<td>사진5</td>
					<td>사진6</td>
					
				</tr>
				
				<c:forEach items="${animalsList}" var="item">
					<tr>
						<td>
						<input type="checkbox" name="animalIdx" value="${item.animalIdx}" onclick="CountChecked(this)"/>
						</td>
						<td>${item.animalIdx}</td>
						<td>${item.centerIdx}
							<input type="hidden" name="cIdx" value="${item.centerIdx}"/>
						</td>
						<td>${item.animalType}</td>
						<td>${item.animalSort}</td>
						<td>${item.animalGender}</td>
						<td>${item.animalNeuter}</td>
						<td>${item.animalInoculation}</td>
						<td>${item.animalFeature}</td>
						<td><img src="${item.img_1}"></td>
						<td><img src="${item.img_2}"></td>
						<td><img src="${item.img_3}"></td>
						<td><img src="${item.img_4}"></td>
						<td><img src="${item.img_5}"></td>
						<td><img src="${item.img_6}"></td>
					</tr>
				</c:forEach>
			</table>
			
			<div id="pageIdx">
			<c:forEach var="item" begin="${animalsListBeginPage}" end="${animalsListEndPage}">
				<a href="/AnimalBridge/view/animalsView/animalsList.do?requestPage=${item}&requestAnimalType=${requestAnimalType}">
					${item + 1} 
				</a>
			</c:forEach>
			</div>
			
			<input type="hidden" name="centerIdx" id="centerIdx" value=""/>	
		
		</div>
		</form>
		
		<button onclick="go_rev()" id="btn1">입양하기</button>
		
</div>		
		
	<script>
	
		var maxChecked = 1;   
		var totalChecked = 0; 
		
	function CountChecked(field) {
		
	    if (field.checked) 
	        totalChecked += 1;
	    else
	        totalChecked -= 1; 
	    
	    if (totalChecked > maxChecked) { 
	        alert ("최대 1마리 까지만 가능합니다."); 
	    field.checked = false;
	    totalChecked -= 1;
	    }
	    
	    
	    var args = arguments;
		var animalIdx = document.getElementsByName("animalIdx");
		var cIdx = document.getElementsByName("cIdx");
		var idx = null;
		var centerIdx = null;
		
	    for ( var i = 0; i < animalIdx.length; i++ ){
   	      if (animalIdx[i] == args[0]){  
   	    	idx = i;
   	    	centerIdx = cIdx[idx].value;
   	      }
   	    }
	    

	    if (idx != null){
	      if (args[0].checked)
	    	document.getElementById("centerIdx").value = centerIdx;
		}
	}
	
	
 	function go_rev(){
		document.formm.action="/AnimalBridge/view/reservationView/rev_vow.do";
		document.formm.submit();
	}  
	
	</script>
	</body>
</html>