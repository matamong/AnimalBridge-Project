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
		
		<form action="" method="GET" name="formm">
			종류 : <input type="text" name="requestAnimalType" value="${requestAnimalType}" >
			
			<table border="1">
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
				<a href="/AnimalBridge/view/animalsView/animalsList.do?requestPage=${item}&requestAnimalType=${requestAnimalType}">
					${item + 1} 
				</a>
			</c:forEach>
			
		<input type="hidden" name="centerIdx" id="centerIdx" value=""/>	
		</form>
		
		<button onclick="go_rev()">입양하기</button>
		
		
		
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