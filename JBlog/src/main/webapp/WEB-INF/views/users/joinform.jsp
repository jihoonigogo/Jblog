<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog main page</title>
<!-- jQuery -->
<!-- 상대위치 -->
<script src="<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<!-- 스크립트 삽입 -->
<script src="<c:url value="/assets/javascript/users.js"/>"></script>
<style>

</style>
</head>
<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<h1> 회원가입 영역</h1>
	<fieldset>
		<form
			id="join-form"
			name="registerForm"
			action="<c:url value="/users/join" />"
			action="<c:url value="/blog/join"/>"
			method="POST"	
			>
			
			
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		
		
		<label for="userName">이름</label>
		<input name="userName" type="text" placeholder="이름을 입력하십시오"><br>
		
		<label for="id">아이디</label>
		<input type="text" name="id" placeholder="id를 입력하십시오.">
		
		<!-- 아이디 중복 체크 버튼 -->
		<input type="button" 
			value="중복체크" 
			onclick="idcheck(this.form.id, '<c:url value="/users/idcheck" />')" /><br>
	
		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
	
		<!--  약관 -->
		<label for="box">약관동의</label>
		<input type="checkbox" name="box">서비스 사용약관에 동의해주세요 <br>
		
		<input type="submit" value="회원가입">
		
						
		</form>
		</fieldset>
		</div>
</body>
</html>