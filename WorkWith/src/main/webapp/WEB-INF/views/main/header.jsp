<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../../resources/js/header.js"></script>
</head>
<body>
   <header>
   <div class="logo">
      <h1><a href="../main/main">WorkWith</a></h1>
      </div>
      <div id="category"> 
            <ul id="canav">
               <li><a href="../list/list">전체</a></li>
               <li><a href="../list/list?category=관광">관광</a></li>
               <li><a href="../list/list?category=숙소">숙소</a></li>
               <li><a href="../list/list?category=음식">음식</a></li>
               <li><a href="../list/list?category=교통">교통</a></li>
               <li><a href="../list/list?category=투어">투어</a></li>
            </ul>
         </div>
      <nav>
      <% 
      String id = (String) session.getAttribute("id");
      String position = (String) session.getAttribute("position");
      if(id==null){%>
         <a href="../main/signup"><input type="button" value="회원가입" class="headerbtn_sign"></a>
         <a href="../main/login"><input type="button" value="로그인" class="headerbtn"></a>
      <% }else{%>
         <a href="../board/write"><input type="button" value="글쓰기" class="headerbtn_write"></a> 
         <%if(position.equals("사장") | position.equals("부사장")){ %>  <!-- 아이디가 manager(관리자)일 경우 마이페이지 대신 관리자 버튼 -->
            <a href="../manage/manager"><input type="button" value="관리자" class="headerbtn_mypage"></a>
            <a href="../header/logout"><input type="button" value="로그아웃" class="headerbtn"></a> 
            <a href="/message/msgBox"><input type="button" value="✉" class="headerbtn_message"></a>
         <%}else{%>
            <a href="../mypage/myInpo"><input type="button" value="마이페이지" class="headerbtn_mypage"></a>
            <a href="../header/logout"><input type="button" value="로그아웃" class="headerbtn"></a>
            <a href="/message/msgBox"><input type="button" value="✉" class="headerbtn_message"></a>
         <%}

      }%>
      </nav>
   </header>
</body>
<script>

</script>
</html>