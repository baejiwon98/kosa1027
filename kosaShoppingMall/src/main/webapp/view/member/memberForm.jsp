<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="memberRegist" method="post" name="frm" id="frm" modelAttribute="memberCommand">
회원번호 : <form:input path ="memNum" readonly="readonly" /> (자동 부여)
		<form:errors path="memNum" /><br />
회원아이디 : <form:input path="memId" />
		<form:errors path="memId" /><br />
비밀번호 : <form:password path="memPw" />
		<form:errors path="memPw" /><br />
비밀번호 확인 : <form:password path="memPwCon" />
		<form:errors path="memPwCon" /><br />
회원이름 : <form:input path="memName" />
		<form:errors path="memName" /><br />
회원주소 : <form:input path="memAddr"/>
		<form:errors path="memAddr" /><br />
등록일 : <input type="date" name="memRegiDate" value="<fmt:formatDate value='${memberCommand.memRegiDate }' pattern='yyyy-MM-dd'/>"/>
		<form:errors path="memRegiDate" /><br />
성별 : <form:radiobutton path="memGender" value = "F"/>여자
<form:radiobutton path="memGender" value = "M" />남자
		<form:errors path="memGender" /><br />
연락처 : <input type="text" name="memPhone" value="${memberCommand.memPhone }"/>
		<form:errors path="memPhone" /><br />
생년월일 : <input type="date" name="memBirth" value="<fmt:formatDate value='${memberCommand.memBirth }' pattern='yyyy-MM-dd'/>"/>
		<form:errors path="memBirth" /><br />
회원이메일 : <input type="email" name="memEmail" value="${memberCommand.memEmail }"/>
		<form:errors path="memEmail" /><br />
<input type="submit" value="회원 등록" />
</form:form>
</body>
</html>