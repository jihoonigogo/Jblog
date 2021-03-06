<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>    
	
<style>
div#header { margin: 20px auto;
font-size:1.0em;
text-align: center;
width:400px;

}

</style>

<div id="header">

<!--  로그인 x 일떄 회원가입,로그인
로그아웃 + 내 블로그-->
<div>
<a href="<c:url value="/main"/>">
<img src="<c:url value="/assets/image/spring.png"/>"> </a>
</div>
<h1>JBlog</h1>
<ul>
		<c:choose>
		<c:when test="${empty authUser}"><!--  이게 null = 로그인 안함 -->
		<li><a href="<c:url value="/users/join" />">회원가입</a></li>
		<li><a href="<c:url value="/users/login"/>">로그인</a></li>
		</c:when>
		<c:otherwise> <!--  로그인 한 상태 -->
			<li><a href="<c:url value="/users/logout"/>">로그아웃</a></li>
			<li> ${authUser.id }님 반갑습니다 </li>
			<li><a href="<c:url value="/{id}"/>">내 블로그</a>
			</c:otherwise>
			</c:choose>
			
	</ul>

</div>