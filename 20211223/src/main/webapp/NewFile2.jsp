<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "point.Point" %>
<%
	Point p1 = new Point();
	Point p2 = new Point(10, 20);
	int[] ii = new int[3];
	ii[0] = 10;
	ii[1] = 20;
	ii[2] = 30;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>point</title>
<script>
	// 3단 : while
	/*var gop = 1;
	while(gop <= 9){
		document.write("3 * " + gop + " = " + (3*gop) + "<br />");
		gop++;
	}*/
	
	var startdan = 3;
	var enddan=6;
	var startgop = 4;
	var endgop=7;
	var dan = startdan;
	while(dan <= enddan) {
		var gop = startgop;
		while(gop <= endgop) {
			document.write(dan + " * " + gop + " = " + (dan*gop) + "<br />");
			gop++;
		}
		dan++;
	}
</script>
</head>
<body>


<% int startdan = 3;
int enddan = 6;
int startgop = 4;
int endgop = 7;
int dan = startdan;
while (dan <= enddan) {
	int gop= startgop; 
	while(gop <= endgop) {%>	
	<%= dan%>  * <%= gop%> = <%= (dan * gop) %> <br />
		<% gop++;
	} 
	dan++;
   } %>

<%
// do ~ while
	dan = startdan;
	do{
		int gop= startgop; 
		do{	
%>		<%= dan%>  * <%= gop%> = <%= (dan * gop) %> <br />
			<% gop++;
		} while(gop <= endgop); 
		dan++;
	   } while (dan <= enddan);
%>
<hr />
<!-- 1단 부터 9단 중 짝수단만 출력하세요. 단 증가는 1씩 증가 한다.  -->
<%
 for(dan = 1; dan <= 9; dan++){
	 if (dan % 2 != 0)
		 continue;
	for(int gop = 1; gop<=9; gop++) {
%> 
	<%= dan%>  * <%= gop%> = <%= (dan * gop) %> <br />
		 <%}
	 }
%>
<hr />
<!-- break -->
<!-- 1부터 9까지 구구단을 출력할 떄 임의의 값 j를 만나면 구구단을 중지하시오. -->
<%
int j = 5;
for(dan = 1; dan <= 9; dan++){
	if (dan == j) break;
	for(int gop = 1; gop<=9; gop++) {
%> 
	<%= dan%>  * <%= gop%> = <%= (dan * gop) %> <br />
		 <%}
	 }
%>
<hr />
<hr />
<%
j= 6;
for(dan = 1; dan <=9; dan++) {
	if (dan == j) break;
	for(int gop =1; gop<= 9; gop++) {
		out.print(dan + " * " + gop + " = " + dan*gop + "<br />");
	}	
}
%>



 p1's x = <%= p1.getX()  %> <br />
 p1's y = <%= p1.getY()  %> <br />
 p2's x = <%= p2.getX()  %> <br />
 p2's y = <%= p2.getY()  %> <br />
 ii[0] = <%= ii[0] %><br />
 ii[1] = <%= ii[1] %><br />
 ii[2] = <%= ii[2] %><br />
 ii[0] + ii[1] = <%= ii[0] + ii[1]%>
 <table border = 1 width ="640">
 <colgroup>
 	<col width = 20%>
 	<col width = 50%>
 	<col width = 30%>
 </colgroup>
 <tbody>
 	<tr><th>이름</th><th>주소</th><th>전화번호</th></tr>
 	<% for(int i = 1; i <= 10; i++){ %>
 		<tr><td>이숭무</td><td>성남시 분당구</td><td>010-7146-1970</td></tr>
	 <% 	} %>
 </tbody>
 </table>

</body>
</html>