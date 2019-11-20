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
		<title></title>
		
		<style>
			img {
				width: 50px;
			}
		</style>
	</head>

	<body>
		<h1>happyBoard.jsp 페이지 입니다.</h1>
		
		<table border="1">
		<c:forEach items="${happyBoardViewList}" var="item">
			<tr>
				<td>${item.idx}</td>
				<td>${item.nickName}</td>
				<td>${item.title}</td>
				<td>${item.content}</td>
				<td>${item.regDate}</td>
				<td>${item.watch}</td>
				<td>${item.hit}</td>
				<td><img src="${item.img_1}"></td>
				<td><img src="${item.img_2}"></td>
				<td><img src="${item.img_3}"></td>
				<td>${item.img_3}</td>
			</tr>
		</c:forEach>
		</table>
		
		<br/>
		
		<p>
			페이지 : 
			<c:forEach begin="${happyBoardBeginPage}" end="${happyBoardEndPage}" var="i">
				<a href="/AnimalBridge/view/happyBoardView/happyBoard.do?requestPage=${i}">${i + 1}</a> 
			</c:forEach>
		</p>
		
		<br/>
		<input type="button" value="글쓰기" onclick="location.href='/AnimalBridge/view/happyBoardView/happyBoardWriter.jsp'">
	</body>
</html>