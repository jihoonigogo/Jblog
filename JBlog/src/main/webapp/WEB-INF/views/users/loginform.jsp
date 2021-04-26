<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog main page</title>
</head>
<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<h1> 로그인 화면</h1>

	<form
		id="login-form"
		name="loginform"
		method="POST"
		action="<c:url value="/users/login"/>">
		
		<label class="block-label" for="id"> 아이디</label>
		<input type="text" name="id" value="" id="id">
		
		<label class="block-label" for="password"> 비밀번호 </label>
		<input type="password" name="password" value="">
		
		<input type="submit" value="로그인하기">
		
		</form>

</body>
</html>