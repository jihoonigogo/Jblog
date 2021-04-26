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
</head>
<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<h1> 회원가입 영역</h1>


		<form
			id="join-form"
			name="registerForm"
			action="${pageContext.servletContext.contextPath }/users/join"
			action="${pageContext.servletContext.contextPath }/blog/join"
			method="POST"	
			>
			
			
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		
		<label for="userName">이름</label>
		<!-- input name="name" type="text" placeholder="이름을 입력하십시오"-->
		<!-- form:input path="name" placeholder="이름을 입력하십시오" /-->
		
		<br>
		<!-- 이름 필드의 에러메시지 확인 후 출력 -->
		<spring:hasBindErrors name="userVo">
			<!-- name 필드에 검증 오류가 있다면 -->
			<c:if test="${ errors.hasFieldErrors('userName') }">
				<strong style="color:red">
				<spring:message code="${errors.getFieldError('userName').codes[0] }"
					text="${errors.getFieldError('userName').defaultMessage }" />
				</strong><br/>
			</c:if>
		</spring:hasBindErrors>
		
		
		<label for="id">아이디</label>
		<form:input path="id" placeholder="아이디를 입력하세요" />
		<br>
		<form:errors path="id" />
		<spring:message 
		code="${errors.getFieldErrors('id').codes[0] }"
		text="${errors.getFieldErrors('id').defaultMessage }"/>
		
		<!-- 아이디 중복 체크 버튼 -->
		<input type="button" 
			value="회원가입" 
			onclick="idcheck(this.form.id, '<c:url value="/users/idcheck" />')" /><br>
	
		
		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
		<!--  modelattribue의 password필드 오류를 출력해준다 -->
		<form:errors path="password"/>
		<spring:message 
		code="${errors.getFieldErrors('password').codes[0] }"
		text="${errors.getFieldErrors('password').defaultMessage }"/>
		
		
		<!--  약관 -->
		<label for="box">약관동의</label>
		<input type="checkbox" name="box"/> <br>
		
		
			
		
		<input type="submit" value="전송">
			
			
			
		</form>





		</div>
</body>
</html>