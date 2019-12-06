<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			body {
				height: 50vh;
			
				display: flex;
				flex-flow: row wrap;
				justify-content: center;
				align-items: center;
			}
			
			.wrap {
				width: 300px;
				
				border: 2px solid black;
				border-radius: 20px;
				
				padding: 30px;
			}
		</style>
	</head>

	<body>
		<div class="wrap">
			<h3>로그인</h3>
			
			<form action="memberLogIn.do" method="POST">
				<div>
					Nick Name : 
					<input type="text" name="nickName"/>
				</div>
				
				<div>
					Password : 
					<input type="password" name="password"/>
				</div>
				<input type="submit" value="로그인"/>
			</form>
		</div>
	</body>
</html>