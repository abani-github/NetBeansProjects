<%-- 
    Document   : display
    Created on : Oct 7, 2011, 4:57:12 PM
    Author     : beheraab
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listing all</title>
    </head>
    <body>
      <c:forEach var="entry" items="${requestScope.prodMap}">
        Name:  ${entry.key}
        Value: ${entry.value}<br>
      </c:forEach>
         <a href="main.jsp">Buy More</a>
         <a href="mvc/checkout">Check Out</a>
    </body>
</html>
