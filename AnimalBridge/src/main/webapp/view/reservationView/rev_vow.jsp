<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link href="css/style1.css" rel= "stylesheet"> --%>
</head>
<body>
<p>입양예약 전 필수 동의사항 입니다.</p>
<p>필수교육을 받은 사람만 다음으로 진행이 가능합니다.</p>
<form action="" method="post" name="formm">
<input type="hidden" name="centerIdx" value="${centerIdx}"/>
<input type="hidden" name="animalIdx" value="${animalIdx}"/>
<button onclick="check_edu()">입양진행하기</button>
</form>


<script>
function check_edu(){
	document.formm.action="/AnimalBridge/view/reservationView/rev_check_edu.do";
	document.formm.submit();
}  



</script>
</body>
</html>