<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Dancing+Script|Pacifico|Satisfy&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic+Coding&display=swap" rel="stylesheet">
	    
     
    <!-- <link rel="stylesheet" type="text/css" href="/AnimalBridge/css/map/map.css"> -->
    <title>Animal Bridge Map</title>
    
    <style>
    body{
    
    }
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	user-select: none;
}

#background {
	position: fixed;
	width: 100%;
	height: 100%;
	background-image: url(/AnimalBridge/view/mainView/white.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	opacity: 0.5;
}

.box{
            width: 100%;
            height: 100vh;
            font-size: 28px;
            position: relative;
            overflow: hidden;
        }

#wrap1 {
	width: 18%;
	height: 100%;
	position: fixed;
	top: 0;
	left: 0;
	z-index:2;
}

#wrap3 {
	width: 80%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 20%;
}

#wrap2 {
	width: 70%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 20%;
}

hr{
	width: 80%;
	border: 0;
	height: 2px;
	margin: 0 auto;
	margin-top: -40px;
	background-color: #71573e;
}

.wrapBackground{
	width: 100%;
	background-color: rgba(255, 255, 255, .5);
	padding-top: 30px;
	margin-top: 20px;
}

#sideBar {
	background-color: rgba(0, 0, 0, 0.6);
	width: 250px;
	height: 100%;
	position: absolute;
	font-family: 'Jua', sans-serif;
	font-size: 30px;
	top: 0;
	left: 0px;
}

#sideBar ul {
	list-style: none;
	color: white;
	z-index: 3;
}

#sideBar ul li {
	margin: 10px;
	padding: 10px;
}

#sideBar ul li:hover {
	color: wheat;
	background-color: rgba(0, 0, 0, 0.5);
	cursor: pointer;
}

#side_menu p {
	text-align: center;
	font-size: 50px;
}

#map_wrap {
	margin: 2%;
}

.subject{
	text-align: center;
    font-size: 3em;
    margin: 1%;
    margin-top: 10px;
    color: #2e2925;
    font-family: 'Do Hyeon', sans-serif;
    
    /* color: #434343; */
	/* letter-spacing : -7px; */
	/*     text-shadow: 2px 2px 0.1px dimgray; 
 */     }
 
 #subject_wrap{
 	margin-bottom: 50px;
 }
    
.title {
	font-weight: bold;
	display: block;
}

.hAddr {
	position: absolute;
	left: 10px;
	top: 10px;
	border-radius: 2px;
	background: #fff;
	background: rgba(255, 255, 255, 0.8);
	z-index: 1;
	padding: 5px;
}

#centerAddr {
	display: block;
	margin-top: 2px;
	font-weight: normal;
}

.bAddr {
	padding: 5px;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.mapBoard_container {
	text-align: right;
	margin-right: 2%;
}

#register_wrap {
	margin: 2%;
	background-color: #71573e;
	font-family: 'Jua', sans-serif;
	color: white;
	border-radius: 5px;
}

#showAddr {
	width: 100%;
	height: 10%;
}

.form_wrap {
	width: 100%;
	margin: 0;
	text-align: right;
}

.table {
	text-align: center;
	border: 1px solid #dddddd;
	display: block;
	width: 98%;
	border-collapse: collapse;
	border-radius: 7px;
	border-spacing: 5px 10px;
}
.thead{
	width: 100%;
	border-radius: 5px;
}
#ajaxTable {
	background-color: #fbfaf6;
	color: grey;
	width:100%;
}

.table th {
	background-color: #71573e;
	text-align: center;
	color: white;
	padding: 1%;
}

.table td {
	border-top: 0;
	padding: 10px;
}

.table tbody {
	display: block;
	height: 500px;
	overflow: auto;
}

.table th:nth-of-type(1), .table td:nth-of-type(1) {
	width: 500px;
	border: 0.5px solid #e8e4db;
}

.table th:nth-of-type(2), .table td:nth-of-type(2) {
	width: 200px;
	border: 0.5px solid #e8e4db;
}

.table th:nth-of-type(3), .table td:nth-of-type(3) {
	width: 600px;
	border: 0.5px solid #e8e4db;
}

.table th:last-child {
	width: 200px;
	border: 0.5px solid #e8e4db;
}

.table td:last-child {
	/* width: calc(100px - 19px); */
	width: 200px;
	border: 0.5px solid #e8e4db;
}

#form_btn, button {
	margin:2%;
	color: #fff !important;
	text-transform: uppercase;
	text-decoration: none;
	background: #e2574c;
	padding: 20px;
	border-radius: 5px;
	display: inline-block;
	border: none;
	transition: all 0.4s ease 0s;
}

#form_btn, button:hover {
	background: #af9d91;
	letter-spacing: 1px;
	-webkit-box-shadow: 0px 5px 40px -10px rgba(0, 0, 0, 0.57);
	-moz-box-shadow: 0px 5px 40px -10px rgba(0, 0, 0, 0.57);
	box-shadow: 5px 40px -10px rgba(0, 0, 0, 0.57);
	transition: all 0.4s ease 0s;
}
form{
	text-align: center;
}

</style>
</head>

<body>
	<div id="background"></div>
	<div id="wrap1">
		<div id="sideBar">
       	 <ul>
        	<c:choose>
        		<c:when test="${empty memberLogInNickName}">
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogIn.do'">로그인</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberJoin.do'">회원가입</li>
        		</c:when>
        		
        		<c:otherwise>
        			<h3>Hello, ${memberLogInNickName}</h3>
        			<c:if test="${memberLogInGrade eq 'protectCenter'}">
        				<li onclick="location.href='#'">직원관리</li>
        			</c:if>
        			
        			<c:if test="${memberLogInGrade eq 'protector'}">
        				<li onclick="location.href='#'">동물관리</li>
        			</c:if>
        			<li onclick="location.href='/AnimalBridge/view/index.jsp'">홈으로</li>
        			<li onclick="location.href='/AnimalBridge/view/happyBoardView/happyBoard.do'">저 행복해요</li>
        			<li onclick="location.href='/AnimalBridge/view/reservationView/rev_vow.jsp'">입양예약</li>
        			<li onclick="">자원봉사</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberJoin.do'">마이페이지</li>
        			<li onclick="location.href='/AnimalBridge/view/memberView/memberLogOut.do'">로그아웃</li>
        		</c:otherwise>
        	</c:choose>
            
       	     <li>사이트 소개</li>
      	  </ul>
    	</div>
    	</div>
    <div class="box">
    <div id="wrap2">
    	<div id="subject_wrap">
    		<div class="subject">유기동물 신고하기</div>
    	</div>
    	<div id="map_wrap">
   			 <div id="map" style="width:100%; height:450px; margin:0; border-radius: 5px;"></div>
  	  	</div>	
  	  	<div id="register_wrap">
  	  		<div id="showAddr">
  	  			<p style="width:100%; text-align: center;">신고할 곳을 지도 상에서 클릭해주세요</p>
   	 			<p id="result" style="text-align: center; font-size: xx-large; color:#e2574c;"></p>
  	  		</div>
    		<div class="form_wrap" style="width: 70%; margin: 0 auto;">
    			<form action="SaveMap.do" method="post">
    				<input type="hidden" name="x" id="x">
    				<input type="hidden" name="y" id="y" >
     				<input type="hidden" name="address" id="address"><br>
     				<span>동물종류 &nbsp;&nbsp;</span><input type="text" name="title" id="title" placeholder="  동물의 종류를 입력해주세요. e.g)고양이(치즈)" style="width:400px; height:50px;border-radius: 5px; font-size:0.6em"><br>
     				<span>특징 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="text" name="special" id="special" placeholder="  동물의 특징을 입력해주세요. e.g) '나비'라는 이름표를 하고있음" style="width:400px; height:50px; font-size:0.6em;border-radius: 5px;"> <br>
      				<input id="form_btn" type="submit" value="신고하기" style="margin:2%; width:200px; font-family:'Jua', sans-serif; font-size:1em;">
    			</form>
    		</div>
    	</div>
    	</div>
    	</div>
    	<div class="box">
    	<div id="wrap3">
    	<div class="subject">신고 된 친구들</div>
    	<div id="mapBoard_wrap">
    		<div class="mapBoard_container">
    			<input class="form-control" id="mapAddress" onkeyup="searchAddrFunction()" type="text" style="width:400px; height:35px; font-size:0.5em; border-radius: 5px;">
    			<button class="btn" type="button" onclick="searchAddrFunction();" style=" font-family:'Jua', sans-serif; font-size:0.8em;">검색</button>
    		</div>
    		<table class="table">
    			<thead>
    				<tr style="width: 100%; display:flex; justify-content: space-around;">
    					<th>주소</th>
    					<th>종류</th>
    					<th>특징</th>
    					<th>닉네임</th>
    				</tr>
    			</thead>
    			<tbody id="ajaxTable">
    			</tbody>
   	 		</table>
    	</div>
    	</div>
    	</div>
   	 
   	 
    
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=34d8d65e2aab71c5883a60b3c3d28c77&libraries=services,clusterer,drawing"></script>
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=34d8d65e2aab71c5883a60b3c3d28c77"></script>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>     

    <script>
    //ajax
    var request = new XMLHttpRequest();
    function searchAddrFunction(){
    	request.open("Post", "./SearchAddress.do?mapAddress=" 
    					+ encodeURIComponent(document.getElementById("mapAddress").value), true);
    	request.onreadystatechange = searchProcess;  //연결이 되면 searchProcess 함수를 사용
    	request.send(null);
    }
    function searchProcess(){
    	var table = document.getElementById("ajaxTable");
    	table.innerHTML = "";
    	if(request.readyState == 4 && request.status == 200){ //성공적으로 통신이 성공한 경우
    		var object = eval('(' + request.responseText + ')'); //받은 json을 object라는 변수에 넣기
    		var result = object.result;
    		
    			for(var i=0; i<result.length; i++){
    				var row = table.insertRow(0);				//row를 i로 돌고
    				for(var j=0; j<result[i].length; j++){
    					var cell = row.insertCell(j);			//row 안에서 cell형태로 한번 더 j를 돈다.
    					cell.innerHTML = result[i][j].value;
    				}	
    			}
    	}
    	
    }
   	 window.onload = function(){  //아무것도 입력 안해도 결과가 나오게
		searchAddrFunction();
    }
    
    
    //kakaoMap
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
            mapOption = {
                center: new kakao.maps.LatLng(36.38668897986168, 127.9569037822732), // 지도의 중심좌표
                level: 14 // 지도의 확대 레벨
            };

        var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
        
    	 // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new kakao.maps.services.Geocoder();
		
        var json = ${ requestScope.json };
        console.log("받은 json : " + json);
        console.log("받은 title : " + json[0].title);
        console.log("받은 x : " + json[0].x);

        function positionMaker(arr) {
            var res = [];

            for (var i = 0; i < arr.length; i++) {
                var obj = {};
                obj.title = arr[i].title;
                obj.latlng = new kakao.maps.LatLng(Number(arr[i].y), Number(arr[i].x))
                res.push(obj);
            }
            return res;
            console.log(res);
        }


        var positions = positionMaker(json);
        console.log("positions title : " + positions[0].title);
        console.log("position : " + positions[0].latlng);
        

        // 마커 이미지의 이미지 주소입니다
        var imageSrc = '/AnimalBridge/view/mapView/mark1.png';

        for (var i = 0; i < positions.length; i++) {

            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(64, 69),
                markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption), // 마커 이미지를 생성합니다    
                imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
                title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                image: markerImage // 마커 이미지 
            });
        }
		
        // Click Marker
        var imageSrc2 = '/AnimalBridge/view/mapView/mark2.png';
        var imageSize2 = new kakao.maps.Size(64, 69),
            markerImage2 = new kakao.maps.MarkerImage(imageSrc2, imageSize2); // 마커 이미지를 생성합니다    

        var marker2 = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            image: markerImage2 // 마커 이미지 
        }), infowindow = new kakao.maps.InfoWindow({zindex:1});;
        //지도에 클릭 이벤트를 등록합니다
        
        //지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
        kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        	
        	searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
                if (status === kakao.maps.services.Status.OK) {
                    var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
                    detailAddr += '<div id="addressInfo">' + result[0].address.address_name + '</div>';
                    
                    var content = '<div class="bAddr">' +
                                    '<span class="title"> 주소정보</span>' + 
                                    detailAddr + 
                                '</div>';
					           
                     // 클릭한 위도, 경도 정보를 가져옵니다 
                     var latlng = mouseEvent.latLng;
                    // 마커를 클릭한 위치에 표시합니다 
                    marker2.setPosition(mouseEvent.latLng);
                    
                 // 마커 위치를 클릭한 위치로 옮깁니다
                    marker2.setPosition(latlng);
                    
                    // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                    infowindow.setContent(content);
                    infowindow.open(map, marker2);

                    var message = document.getElementById("addressInfo").innerHTML;
                    /* var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
                    message += '경도는 ' + latlng.getLng() + ' 입니다. <br>'
                    			+'주소는 ' + document.getElementById("addressInfo").innerHTML + '입니다.'; */

                    var x = document.getElementById("x");
                    x.value = latlng.getLng();
                    var y = document.getElementById("y");
                    y.value = latlng.getLat();
                    var resultDiv = document.getElementById('result');
                    resultDiv.innerHTML = message;
                    var address = document.getElementById("address");
                    var addressInfo = document.getElementById("addressInfo");
                    address.value = addressInfo.innerHTML;
                }   
            });
        });
        
        
        function searchAddrFromCoords(coords, callback) {
            // 좌표로 행정동 주소 정보를 요청합니다
            geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
        }

        function searchDetailAddrFromCoords(coords, callback) {
            // 좌표로 법정동 상세 주소 정보를 요청합니다
            geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
        }
		
        //scroll
       /*  $(document).ready(function(){
    
   		 var elm=".box";
   		 $(elm).each(function(index){
        
				$(this).on("mousewheel DOMMouseScroll",function(e){
						if(!$(e.target).is("#map")) { 

							e.preventDefault();
    
    							var delta=0;
    							var E=e.originalEvent;
    
    							if(E.detail){
        							delta=E.detail * -40;
    							}else{
       							 delta=E.wheelDelta;
       							 if(window.opera) delta= -delta;
    							}
    
   							 var moveTop=0;
    						var elmSelecter = $(elm).eq(index);
    
    					if(delta<0){
      					  if($(elmSelecter).next() != undefined){
            
 						moveTop=$(elmSelecter).next().offset().top;
      				  }
    			}
    
$("html, body").stop().animate({
    scrollTop:moveTop
},500);
    
}
    
});
        
    })
}); */
		
        
        //유효성 검사
        $("form").submit(function() {
  if( $(this).children("input[name=address]").val().length < 0 || $(this).children("input[name=address]").val() === "") {
    alert("신고할 곳을 선택해주세요");
    return false;
  }
  if( $(this).children("input[name=title]").val().length < 0 || $(this).children("input[name=title]").val() === "") {
	    alert("유기동물의 종을 입력해주세요.");
	    return false;
	  }
  if( $(this).children("input[name=special]").val().length < 0 || $(this).children("input[name=special]").val() === "") {
	    alert("유기동물의 특징을 입력해주세요.");
	    return false;
	  }
  return true;
});
    </script>
</body>
</html>