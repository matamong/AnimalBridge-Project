<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	session="true"
	buffer="8kb"
	autoFlush="true"
	errorPage="errorView/jspErrorHandler.jsp"
	
	info="저 행복해요 게시판의 게시글 출력 페이지 입니다"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<h1>happyBoardView.jsp 의 결과 !</h1>
		<p>IDX : ${resultHappyBoardViewVO.idx}</p>
		<p>NICK_NAME : ${resultHappyBoardViewVO.nickName}</p>
		<p>TITLE : ${resultHappyBoardViewVO.title}</p>
		<p>CONTENT : ${resultHappyBoardViewVO.content}</p>
		<p>RED_DATE : ${resultHappyBoardViewVO.regDate}</p>
		<p>WATCH : ${resultHappyBoardViewVO.watch}</p>
		<p>HIT : ${resultHappyBoardViewVO.hit}</p>
		<img src="${resultHappyBoardViewVO.img_1}"><br/>
		<img src="${resultHappyBoardViewVO.img_2}"><br/>
		<img src="${resultHappyBoardViewVO.img_3}"><br/>
		
		<br/><br/>
		
		<a href="/AnimalBridge/view/happyBoardView/happyBoard.do">홈으로</a>
	</body>
</html>