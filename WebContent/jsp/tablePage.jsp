<%--
  Created by IntelliJ IDEA.
  User: Hleb_Aksionau
  Date: 3/16/2018
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
Number of pages:
${pagesQuantity}
${currentPage}
<table>
<tr>
<th>Name</th>
<th>Diameter</th>
<th>Orbital period</th>
<th>Year of discovering</th>
</tr>
</table>
<table>
 <tr>
 <c:if test="currentPage != 1">
 <td><a href="#" >Previous</a>
 </c:if>
<c:forEach begin="1" end="${pagesQuantity}" var="i">
  <td><a href="PageController?currentPage=${i}">${i}</a></td>
</c:forEach>
<c:if test="currentPage != ${pagesQuantity}">
 <td><a href="${{currentPage }+1}" >Next</a>
 </c:if>
</tr>
</table>
<a href="index.jsp">Go to main page</a>
</body>
</html>
