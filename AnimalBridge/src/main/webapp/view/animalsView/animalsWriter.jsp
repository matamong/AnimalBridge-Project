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
		<h1>ANIMALS 등록 페이지</h1>
		
		<form action="animalsWriter.do" method="POST" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<th>보호소ID</th>
					<td><input type="text" name="centerIdx">
				</tr>
				
				<tr>
					<th>동물타입</th>
					<td><input type="text" name="animalType">
				</tr>
				
				<tr>
					<th>품종</th>
					<td><input type="text" name="animalSort">
				</tr>
				
				<tr>
					<th>성별</th>
					<td>
						<select name="animalGender">
							<option value="male">남</option>
							<option value="female">여</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>중성화 여부</th>
					<td>
						<select name="animalNeuter">
							<option value="ok">중성화 완료</option>
							<option value="none"> - </option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>예방접종</th>
					<td>
						<select name="animalInoculation">
							<option value="none">예방접종 전</option>
							<option value="1st">1차 예방접종 완료</option>
							<option value="2nd">2차 예방접종 완료</option>
							<option value="3rd">3차 예방접종 완료</option>
							<option value="4th">4차 예방접종 완료</option>
							<option value="5th">5차 예방접종 완료</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>특징</th>
					<td>
						<textarea name="animalFeature" rows="5" cols="50" style="resize: none;"></textarea>
					</td>
				</tr>
				
				<tr>
					<th>사진1</th>
					<td>
						<input type="file" name="img_1">
					</td>
				</tr>
				
				<tr>
					<th>사진2</th>
					<td>
						<input type="file" name="img_2">
					</td>
				</tr>
				
				<tr>
					<th>사진3</th>
					<td>
						<input type="file" name="img_3">
					</td>
				</tr>
				
				<tr>
					<th>사진4</th>
					<td>
						<input type="file" name="img_4">
					</td>
				</tr>
				
				<tr>
					<th>사진5</th>
					<td>
						<input type="file" name="img_5">
					</td>
				</tr>
				
				<tr>
					<th>사진6</th>
					<td>
						<input type="file" name="img_6">
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="지우기">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>