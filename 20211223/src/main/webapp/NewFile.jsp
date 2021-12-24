<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	for(var i = 0; i<=9; i++){
		document.write(i);
	}
</script>
</head>
<body>
<% /// 스프리트릿을 여러번 사용이 가능하므로 한줄씩 사용할 수 있다. 
   /// 이 안에 있는 코드는 html 코드가 아니다. 
	for(int i = 0; i<=9; i++){
		out.print(i + "<br />");
		// System.out.print("");
	}
	out.print("안녕하세요");
%>

<%	for(int i = 0; i<=9; i++){ %>
<%= i + "<br />" %> <!--  표현식  -->
<!-- out.print() -->
<%-- jsp 주석 --%>
<%-- <% out.print(i + "<br />"); %> --%>
<% } %>


<% out.print("안녕하세요"); %>
</body>
</html>