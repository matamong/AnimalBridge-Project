<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Dancing+Script|Pacifico|Satisfy&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic+Coding&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>My Page</title>
<style>
	* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	user-select: none;
}

#background {
	position: fixed;
	width: 100%;
	height: 100%;
	background-image: url(/AnimalBridge/view/mainView/white.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	opacity: 0.5;
	z-index: -10;
}
#sideBar {
            background-color: rgba(0, 0, 0, 0.6);
            width:250px;
            height: 100%;
            position: absolute;
            font-family: 'Jua', sans-serif;
            font-size: 30px;
            top: 0;
            left: 0;
            z-index: 10;
        }
        #sideBar ul {
            list-style: none;
            color: white;
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
        #white_background{
        	width: 80%;
        	height: 80%;
			background-color: rgba(255, 255, 255, .5);
        }
        .wrapBackground {
    		width: 100%;
  		 	background-color: rgba(255, 255, 255, .5);
    		margin-top: 0;
    		margin-left: 251px;
		}
</style>
</head>
<body>
	<div id=background></div>
    <div id="sideBar">
        <ul>
        			<h3>${memberLogInNickName}의 MyPage</h3>
    	  	  		<li onclick="#">입양예약보기</li>
    	  	  		<li onclick="#">유기동물신고내역</li>	
    	  	  		<li onclick="location.href='/AnimalBridge/view/memberView/memberLeave.do'">탈퇴</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogOut.do'">로그아웃</li>
        </ul>
    <div class="wrapBackground"></div>
    </div>
    <div id="white_background"></div>
</body>
</html>