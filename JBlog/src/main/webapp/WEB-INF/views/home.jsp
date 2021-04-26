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
			
			<div >
			<input type="search"placeholder="검색어를 입력 하세요." />
			<button type="button">검색</button>
		    </div>
		    
		    <div >
			<input type="radio">블로그 제목
			<input type="radio">블로그
			</div>
		</div>
</body>
</html>