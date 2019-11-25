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
		<h1>이전 페이지의 requestAnimalType : ${requestAnimalType}</h1>
	
		<h1>animalsView.jsp 결과</h1>
		<p>ANIMAL_IDX : ${resultAnimalsViewVO.animalIdx}</p>
		<p>CENTER_IDX : ${resultAnimalsViewVO.centerIdx}</p>
		<p>ANIMAL_TYPE : ${resultAnimalsViewVO.animalType}</p>
		<p>ANIMAL_SORT : ${resultAnimalsViewVO.animalSort}</p>
		<p>ANIMAL_GENDER : ${resultAnimalsViewVO.animalGender}</p>
		<p>ANIMAL_NEUTER : ${resultAnimalsViewVO.animalNeuter}</p>
		<p>ANIMAL_INOCULATION : ${resultAnimalsViewVO.animalInoculation}</p>
		<p>ANIMAL_FEATURE : ${resultAnimalsViewVO.animalFeature}</p>
		<p>ADOPTION_DATE : ${resultAnimalsViewVO.adoptionDate}</p>
		<p>MEMBER_NICK_NAME : ${resultAnimalsViewVO.memberNickName}</p>
		<p>IMG_1 : <img src="${resultAnimalsViewVO.img_1}"></p>
		<p>IMG_2 : <img src="${resultAnimalsViewVO.img_2}"></p>
		<p>IMG_3 : <img src="${resultAnimalsViewVO.img_3}"></p>
		<p>IMG_4 : <img src="${resultAnimalsViewVO.img_4}"></p>
		<p>IMG_5 : <img src="${resultAnimalsViewVO.img_5}"></p>
		<p>IMG_6 : <img src="${resultAnimalsViewVO.img_6}"></p>
	</body>
</html>