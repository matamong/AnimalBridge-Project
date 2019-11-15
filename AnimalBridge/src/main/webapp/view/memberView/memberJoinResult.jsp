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
	</head>

	<body>
		<h3>회원가입 결과</h3>
		
		<p>${error}</p>
		
		<p>Nick Name : ${result.nickName}</p>
		<p>Email : ${result.email}</p>
		<p>Password : ${result.password}</p>
		<p>Addr : ${result.addr}</p>
		<p>Phone : ${result.phone}</p>
		
		<a href="../index.jsp">홈으로</a>
	</body>
</html>