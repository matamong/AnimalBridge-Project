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
		<title>Insert title here</title>
		
		<style>
			img {
				width: 50px;
			}
		</style>
	</head>

	<body>
		<h1>입양하기 (반려동물 리스트)</h1>
		<p>totalAnimalsPageCnt : ${totalAnimalsPageCnt}</p>
		<p>animalsListCurrentPage : ${animalsListCurrentPage}</p>
		<p>animalsListBeginPage : ${animalsListBeginPage}</p>
		<p>animalsListEndPage : ${animalsListEndPage}</p>
		<p>requestAnimalType : ${requestAnimalType}</p>
		
		<hr/>
		
		<h3>현재 페이지 : ${animalsListCurrentPage + 1}</h3>
		
		<form action="/AnimalBridge/view/animalsView/animalsList.do" method="GET">
			종류 : <input type="text" name="requestAnimalType">
			
			<table border="1">
				<c:forEach items="${animalsList}" var="item">
					<tr>
						<td>${item.animalIdx}</td>
						<td>${item.centerIdx}</td>
						<td>${item.animalType}</td>
						<td>${item.animalSort}</td>
						<td>${item.animalGender}</td>
						<td>${item.animalNeuter}</td>
						<td>${item.animalInoculation}</td>
						<td>${item.animalFeature}</td>
						<td>${item.adoptionDate}</td>
						<td>${item.memberNickName}</td>
						<td><img src="${item.img_1}"></td>
						<td><img src="${item.img_2}"></td>
						<td><img src="${item.img_3}"></td>
						<td><img src="${item.img_4}"></td>
						<td><img src="${item.img_5}"></td>
						<td><img src="${item.img_6}"></td>
					</tr>
				</c:forEach>
			</table>
			
			<c:forEach var="item" begin="${animalsListBeginPage}" end="${animalsListEndPage}">
				<a href="/AnimalBridge/view/animalsView/animalsList.do?requestPage=${item}">${item + 1} </a>
			</c:forEach>
		</form>
	</body>
</html>