<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"></script>
<script>
$(function(){
	$("#delete").click(function(){
		$.ajax({
			type : "post",
			url : "../memberDelete",
			data : {"memNum":"${memberCommand.memNum}"},
			dataType: "text",
			success: function(result) {
				alert(result);
				if(result.trim() == '1'){
					alert("회원이 정상적으로 삭제되었습니다.");
					location.href="../memList";
				}else{
					alert("회원이 삭제되지않았습니다.");
					return false;
				}
			},
			error: function(){
				alert('에러가 나왔음');
				return;
			}
		});
	});
});
function del(){
	$.ajax({
		type : "post",
		url : "../memberDelete",
		data : {"memNum":"${memberCommand.memNum}"},
		dataType: "text",
		success: function(result) {
			alert(result);
			if(result.trim() == '1'){
				alert("회원이 정상적으로 삭제되었습니다.");
				location.href="../memList";
			}else{
				alert("회원이 삭제되지않았습니다.");
				return false;
			}
		},
		error: function(){
			alert('에러가 나왔음');
			return;
		}
	});
}
</script>
</head>
<body>
상세페이지<br />
회원번호 : ${memberCommand.memNum}<br />
회원아이디 : ${memberCommand.memId}<br />
회원이름 : ${memberCommand.memName}<br />
회원주소 : ${memberCommand.memAddr}<br />
등록일 : <fmt:formatDate value='${memberCommand.memRegiDate }' pattern='yyyy-MM-dd'/><br />
성별 : <c:if test="${memberCommand.memGender=='M'}">남자</c:if>
<c:if test="${memberCommand.memGender=='F'}">여자</c:if> <br />
연락처 : ${memberCommand.memPhone}<br />
생년월일 : <fmt:formatDate value='${memberCommand.memBirth }' pattern='yyyy-MM-dd'/><br />
회원이메일 : ${memberCommand.memEmail} <br />
<form action = "../memberModify" method="get" id= "frm">
<input type="hidden" name = "memNum" value="${memberCommand.memNum}" />
<input type="submit" value="수정"/>
<input type="button" value="jquery삭제"  id="delete" />
<input type="button" value="function삭제" onclick="del();">
</form>
</body>
</html>