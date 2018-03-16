<%--
  Created by IntelliJ IDEA.
  User: Hleb_Aksionau
  Date: 3/16/2018
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
Number of pages:
${pagesQuantity}
<c:forEach begin="1" end="${16}" var="i">
    ${i}
</c:forEach>
</body>
</html>
