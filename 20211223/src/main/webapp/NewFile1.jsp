<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 100까지의 합구하기</title>
<script>

	var sum = 0;
	for(var i = 1; i <= 100; i++){
		sum += i;
	}
	document.write("1 ~ 100까지의 합은 " + sum + "<br />");
</script>
</head>
<body>
<%
	int sum = 0;
	for(int i = 1; i <= 100; i++){
		sum += i;
	}
%>
<%= "1 ~ 100까지의 합은 " + sum + "<br />" %>

<%	int sum1 = 0; %>
<%	for(int i = 1; i <= 100; i++){ %>
<%		sum1 += i; %>
<%	}%>
<%= "1 ~ 100까지의 합은 " + sum1 + "<br />" %>

<%!
	public void test(){
		System.out.print("테스트");	
	}
%>
</body>
</html>