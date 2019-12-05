<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<meta charset="UTF-8">
<title>Login</title>
<style>
	body{
		margin: 0;
		padding: 0;
		font-family: sans-serif;
		
	}
	#background_img{
		background: url(/AnimalBridge/view/mainView/white.jpg) no-repeat;
		background-size: cover;
		position: fixed;
		width: 100%;
		height: 100%;
		opacity: 0.8;
		z-index: -1;
	}
	.login-box{
		width: 280px;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		color: white;
	}
	.login-box h1{
		float: left;
		font-size: 40px;
		border-bottom: 6px solid #ca7e1d;
		margin-bottom: 50px;
		padding: 13px 0;
	}
	.textbox{
		width: 100%;
		overflow: hidden;
		font-size: 20px;
		padding: 8px 0;
		margin: 8px 0;
		border-bottom: 1px solid white;
	}
	.textbox i{
		width: 26px;
		float: left;
		text-align: center;
	}
	.textbox input{
		border: none;
		outline: none;
		background: none;
		color: white;
		font-size: 18px;
		width: 80%;
		float: left;
		margin: 0 10px;
	}
	.btn{
		width: 100%;
		background-color: #ca7e1d;
		border: 2px solid #ca7e1d;
		color: white;
		padding: 5px;
		font-size: 18px;
		cursor: pointer;
		margin: 12px 0;		
	}
</style>
</head>
<body>
	<div id="background_img"></div>
	<div class="login-box">
		<h1>Login</h1>
		<form action="memberLogIn.do" method="post">
				<div class="textbox">
				<i class="fas fa-user"></i>
				<input type="text" placeholder="NickName" name="nickName" style="color:white;"> 
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i>
				<input type="password" placeholder="Password" name="password">
			</div>
			<input class="btn" type="submit" value="로그인">
		</form>
	</div>
</body>
</html>