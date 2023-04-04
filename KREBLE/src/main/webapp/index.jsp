<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!doctype html>
<html>
 <head>
   <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
    <link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link href="https://fonts.googleapis.com/css?family=Kirang+Haerang:400" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Labrada:wght@100&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Orbitron&family=Righteous&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
   <title>
    축구팀프
   </title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript" src="slick/slick.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<script src="js/index.js" ></script>
<script>
    
</script>
 <body>
  <jsp:include page="Header_baseform.jsp"/>
  <!--section-->
  <section>
    <div id="content1">
    	<div class="content_inner">
    		<div class="title_box">
    			<h3>정보소개</h3>
    			<a href="#" class="link_button">정보소개 바로가기</a>
    		</div>
    		<div class="info_wrap">
    			<a href="#" class="commu_link">
    				<b>커뮤니티</b>
    				<p>여러 사람들과 축구에 대해 이야기하고 싶다면?</p>
    			</a>
    			<a href="#" class="rent_link">
    				<b>예약/대여</b>
    				<p>축구시설을 대여하고 싶다면?</p>
    			</a>
    			<a href="#" class="shop_link">
    				<b>쇼핑</b>
    				<p>다양한 축구물품을 구하고 싶다면?</p>
    			</a>
    		</div>
    	</div>
    </div>
    <div id="content2">
    	<div class="content_inner">
    		<div class="title_box">
    			<h3>유저커뮤니티</h3>
    			<a href="#" class="link_button">커뮤니티 바로가기</a>
    		</div>
    		<div class="commu_wrap wrap1">
    			<h4>베스트 스쿼드</h4>
    			<div class="squad_wrap">
    				<p class="squad_name">스쿼드 이름 : 국가대표</p>
					<ul>
						<li class="director"><span class="player_img"><img src="image/player_img/Paulo Bento.jpg"></span><p class="name">파울루 벤투</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/SON Heungmin.jpg"></span><p class="name">손흥민</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/HWANG Inbeom.jpg"></span><p class="name">황인범</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/HWANG Heechan.jpg"></span><p class="name">황희찬</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/KIM Jinsu.jpg"></span><p class="name">김진수</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/JUNG Wooyoung.jpg"></span><p class="name">정우영</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/LEE Jaesung.jpg"></span><p class="name">이재성</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/KIM Younggwon.jpg"></span><p class="name">김영권</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/KWON Kyungwon.jpg"></span><p class="name">권경원</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/KIM Moonhwan.jpg"></span><p class="name">김문환</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/KIM Minjae.jpg"></span><p class="name">김민재</p></li>
						<li class="player"><span class="player_img"><img src="image/player_img/JO Hyeonwoo.jpg"></span><p class="name">조현우</p></li>
					</ul>
				</div>
    		</div>
    		<div class="commu_wrap wrap2">
    			<h4>화제의 게시글</h4>
    			<div class="hot_commu free_hot">
    				<span>자유게시판 화제글</span>
    				<div class="board">
    					<div class="board_top">
    						<p class="title">이거 대충 제목 아무거나 해야지</p>
    						<span class="writer">작성자1</span>
    					</div>
<textarea readonly>
이거 내용은 뭘로 써야하나
아 인덱스 수정하기 귀찮다
css는 언제 걸고 데이터베이스도 연결해야하는데 언제 다하냐
이거 나중에 이미지도 있으면 textarea크기 줄이고
이미지 넣는것도 추가하는게 좋을텐데
아 머리아프다
</textarea>
    				</div>
    			</div>
    			<div class="hot_commu debate_hot">
    				<span>토론게시판 화제글</span>
    				<div class="board">
    					<div class="board_top">
    						<p class="title">이강인 이적하면 어디가 좋을거같음?</p>
    						<span class="writer">해축신봉자</span>
    					</div>
<textarea readonly>
난 솔직히 뉴캐슬로 가는게 좋아보이는데
주전경쟁 괜찮고 UCL나갈 가능성 높아서 나쁘진 않아보이는데
님들 생각은 어떰
반박시 날강두
</textarea>
    				</div>
    			</div>
    			<div class="hot_commu info_hot">
    				<span>정보게시판 화제글</span>
    				<div class="board">
    					<div class="board_top">
    						<p class="title">이강인 이적설 떡밥 정리</p>
    						<span class="writer">스피드 왜건</span>
    					</div>
<textarea readonly>
최근에 로마노 트위터에서
이강인이 올 여름에 마요르카 떠날거 같다,
PL구단들이 이강인 모니터링중이다
말 많던데 떡밥 시원하게 정리할수 있지만
여백이 없어 이 이상 적지 않겠다.
</textarea>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
        <div id="content3">
    	<div class="content_inner">
    		<div class="title_box">
    			<h3>예약/대여</h3>
    			<a href="#" class="link_button">구장대여 바로가기</a>
    		</div>
    		<div class="rent_wrap wrap1">
    			<span class="rent_wrap1_content">사용자님들의 잊고 싶지 않았던 구장!</span><br>
    			<span>진땀승부의 추억을 공유했던 그 때 그 장소</span>
    			<i></i>
    			<p class="rent_wrap1_content2">다양한 KREBLE에서 제공되는 서비스를 사용하실 수 있는 기회를 놓치지마세요.</p>
    			<a href="kreblechoi.jsp" class="rent_wrap1_content3">바로가기</a>
    			<div class="back-bg"></div>
    		</div>
    		<div class="rent_wrap wrap2">
    			<div class="rent_wrap2_content">
    				<p style="margin-top: 137px; font-size: 30px;">후기 토크</p><br>
    				<p style="font-size: 14px; line-height: 10px;">진솔한 대여/예약 후기를 모았습니다.</p>
    			</div>
    			<div class="rent_wrap2_content2">
    				
    			</div>
    		
    		</div>
    	</div>
    </div>
    <div id="content4">
    	<div class="content_inner">
    		<div class="title_box">
    			<h3>쇼핑</h3>
    			<a href="#" class="link_button">쇼핑 바로가기</a>
    		</div>
    		<div class="shop_wrap wrap1">
    		
    		</div>
    		<div class="shop_wrap wrap2">
    		
    		</div>
    		<div class="shop_wrap wrap3">
    		
    		</div>
    		<div class="shop_wrap wrap4">
    		
    		</div>
    	</div>
    </div>
  </section>
  <jsp:include page="Footer_baseform.jsp"/>

 </body>
</html>



