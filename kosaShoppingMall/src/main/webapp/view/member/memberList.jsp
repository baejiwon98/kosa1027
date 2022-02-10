<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원리스트 페이지<br />
<table border="1" width=50%>
	<tr valign="middle">
		<td colspan=4>회원리스트</td>
		<td align=center>회원 수 : ${list.size()}</td>
	</tr>
	<tr>
		<th>회원아이디</th>
		<th>회원이름</th>
		<th>회원연락처</th>
		<th>이메일</th>
		<th>등록일</th>
	</tr>
	<c:forEach items="${list}" var="dto">
	<tr align="center" valign="middle">
		<td align="center">
			<a href = "/mem/memberInfo/${dto.memNum}">
				${dto.memId }
			</a>
		</td>
		<td align="center">${dto.memName }</td>
		<td align="center">${dto.memPhone }</td>
		<td align="center">${dto.memEmail }</td>
		<td align="center">
			<fmt:formatDate value="${dto.memRegiDate }" pattern="yyyy-MM-dd" />
		</td>
	</tr>
	</c:forEach>
	<tr>
		<th colspan="5" >
			<c:if test="${page <= 1 }">
			[이전]
			</c:if>
			<c:if test="${page > 1 }">
			<a href="memList?page=${page - 1 }">[이전]</a>
			</c:if>
			
			<c:forEach begin="${startPage }" end="${endPage }" var="i" step="1">
			[ <a href="memList?page=${i }">${i }</a> ] 
 			</c:forEach>
 			
 			<c:if test="${page < maxPage }">
 			<a href="memList?page=${page + 1 }">[이후]</a>
 			</c:if>
 			<c:if test="${page >= maxPage }">
 			[이후]
 			</c:if>
		</th>
	</tr>
</table>
<a href="memberRegist">등록</a>
</body>
</html>