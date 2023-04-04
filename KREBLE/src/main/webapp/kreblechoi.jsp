<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!doctype html>
<html>
<head> <!-- 문서정보 -->
	<meta charset="utf-8">
	<title>kreble</title>
	<style>

	</style>
	<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
	<link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/kreblechoi.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&family=Nanum+Myeongjo:wght@800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<script src="js/kreblechoi.js"></script>
<script type="text/javascript" src="slick/slick.min.js"></script>
<body >


  <jsp:include page="Header_baseform.jsp"/>
	<section>
		<div class="section_inner">
			<div class="stadium">
				<div class="content_head">
					<!-- <h3>시민구장 정보</h3> -->
				</div>
				<div class="stadium_inner">
					<div class="sub_nav">
						<ul>
							<li><a href="#">홈</a></li>
							<li><a href="#">예약/대여</a></li>
							<li><a href="#" style="color: blue;"><b>시민구장 정보</b></a></li>
						</ul>
					</div>
					<div class="stadium_list">
						<span>자주가는 구장</span>
						<div class="favorite_stadium">
							<ul>
								<li class="default"><a href="#">구장1</a></li>
								<li class="default"><a href="#">구장2</a></li>
								<li class="default"><a href="#">구장3</a></li>
								<li class="default"><a href="#">구장4</a></li>
								<li><span id="plusbu"><a href="#"></a></span></li>
								<li><span id="minusbu"><a href="#"></a></span></li>
							</ul>
<!-- 		수정전 기존 위치였음	<span id="plusbu"><a href="#"></a></span>
							<span id="minusbu"><a href="#"></a></span> -->
						</div>
						<ul class="local_stadium">
							<li class="local on">
								<a href="#">서울</a>
								<ul>
									<li class="on"><a href="#">잠실종합운동장</a></li>
									<li><a href="#">노량진 축구장</a></li>
									<li><a href="#">월곡인조잔디<br>축구장</a></li>
									<li><a href="#">은평구립 축구장</a></li>
									<li><a href="#">천마공원 축구장</a></li>
									<li style="border-right: none;"><a>창골 축구장</a></li>
								</ul>
							</li>
							<li class="local">
								<a href="#">인천</a>
								<ul>
									<li><a href="#">인천대공원 축구장</a></li>
									<li><a href="#">인천축구전용 경기장</a></li>
									<li><a href="#">강서개화 축구장</a></li>
									<li><a href="#">드림파크문화재단 <br>축구장</a></li>
									<li><a href="#">주안더월드스테이트</a></li>
								</ul>
							</li>
							<li class="local">
								<a href="#">경기</a>
								<ul>
									<li><a href="#">부천체육관 축구장</a></li>
									<li><a href="#">솔터 축구장</a></li>
									<li><a href="#">의왕 축구장</a></li>
									<li><a href="#">수원종합 운동장</a></li>
									<li><a href="#">광명시 축구장</a></li>
									<li style="border-right: none;"><a href="#">구리시체육회 축구장</a></li>
								</ul>
							</li>
							<li class="local">
								<a href="#">대구</a>
								<ul>
									<li><a href="#">대구경북과학기술원<br>축구장</a></li>
									<li><a href="#">논공축구장</a></li>
									<li><a href="#">DGB대구은행파크</a></li>
								</ul>
							</li>
							<li class="local">
								<a href="#">대전</a>
								<ul>
									<li><a href="#">유등천 축구장</a></li>
									<li><a href="#">중구체육복지센터<br>축구장</a></li>
									<li><a href="#">사정동 잔디축구장</a></li>
									<li><a href="#">관저체육공원</a></li>
								</ul>
							</li>
							<li class="local">
								<a href="#">부산</a>
								<ul>
									<li><a href="#">영도마린 축구장</a></li>
									<li><a href="#">남부환경체육공원</a></li>
									<li><a href="#">삼락강변체육공원</a></li>
									<li><a href="#">다대풋살센터</a></li>
									<li><a href="#">기장군월드컵빌리지</a></li>
								</ul>
							</li>
							<li class="local">
								<a href="#">제주</a>
								<ul>
									<li><a href="#">중문단지 축구장</a></li>
									<li><a href="#">사라봉 축구장</a></li>
									<li><a href="#">외도 축구장</a></li>
								</ul>
							</li>
						</ul>
					</div>
			</div>
			<form>
			<div class="stadium_name">
				<span>[서울]잠실종합운동장</span>
			</div>
			<div class="stadium_info">
				<div class="stadium_img">
				<img style="width: 100%; height:100%; border-radius: 7px;" src="image/rent_stardium/rent5.jpg">
				</div>	
				<div class="detail_info">
					<table style="height: 507px">
						<tr>
							<th>위치</th>
							<td>서울특별시 송파구 올림픽로 25 서울종합운동장
								<a href="http://kko.to/b9jxDcNxg4" target="black"><img class="mapbtn" src="image/rent_stardium/kakaobu.jpg"></a>
							</td>
						</tr>
						<tr>
							<th>명칭</th>
							<td>잠실종합운동장</td>
						</tr>
						<tr>
							<th>대지면적</th>
							<td>75,469 ㎡</td>
						</tr>
						<tr>
							<th>이용시간</th>
							<td>하절기(4~9월) : 조기 05:00~08:00, 주간 08:00~19:00, 야간 19:00~05:00 <br>동절기(10~3월) : 조기 06:00~09:00, 주간 09:00~18:00, 야간 18:00~06:00</td>
						</tr>
						<tr>
							<th>주요시설</th>
							<td>샤워장,관리 사무실,조명 탑,테니스 장,주차장</td>
						</tr>
						<tr>
						<th>전화</th>
							<td>02-2240-8712</td>
						</tr>
					</table>
					<input type="button" value="예약하기" class="rent_btn">
				</div>
			</div>
			</form>
			<div class="topbutton"><a href="#"><img src="image/arrow_bu.png"></a></div>
			<div class="botmessage">입장 지연의 불편을 최소화 하기 위해 10분 전 퇴실 준비를 부탁드립니다.<br>자세한 문의사항은 기재되어 있는 연락망을 통해 문의바랍니다.<br>더욱 안정적이고 편리한 서비스를 제공하는 <img src="image/logo_ver3.png"> 이 되겠습니다.
			<br>감사합니다.
			</div>
		</div>
	</div>
	</section>

	
	<jsp:include page="Footer_baseform.jsp"/>
</body>
</html>
<!-- 			<aside>
				<div class="aside_wrap">
					<a href="#">정보소개</a>
					<ul>
              <li><a href="#">선수소개</a></li>
              <li><a href="#">감독소개</a></li>
              <li><a href="#">팀소개</a></li>
              <li><a href="#">기록조회</a></li>
              <li><a href="#">축구강의</a></li>
              <li><a href="#">경기일정</a></li>
              <li><a href="#">국내리그</a></li>
              <li><a href="#">국내시설</a></li>
          </ul>
		    </div>
		    <div class="aside_wrap">
					<a href="#">예약/대여</a>
		            <ul>
		            	<li><a href="kreblechoi.jsp">#시민구장 정보</a></li>
		            	<li><a href="#">구장 예약</a></li>
		            	<li><a href="rent_review.jsp">#후기 게시판</a></li>		        
		            </ul>
		        </div>
		        <div class="aside_wrap">
					<a href="#">해외정보</a>
		            <ul>
		            	<li><a href="#">해외리그소개</a></li>
		            	<li><a href="#">해외시설개요</a></li>
		            </ul>
		        </div>
		        <div class="aside_wrap">
					<a href="#">경기 티켓</a>
		            <ul>
		            	<li><a href="#">티켓팅</a></li>
		            </ul>
		        </div>
			</aside> -->