<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%-- 
    Document   : index
    Created on : Oct 3, 2011, 2:07:31 PM
    Author     : beheraab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form method="post" action="mvc/buy">
            <select name="product">
                <option value="apple">apple</option>     
                <option value="orange">orange</option>
                <option value="banana">banana</option>
            </select>
             <select name="quantity">
                 <option value="1">1</option>     
                 <option value="2">2</option>
                 <option value="3">3</option>
            </select> <br />
            <button type="submit">Buy</button><br />
            <a href="mvc/listall">See All products</a>
            <a href="mvc/checkout">Check Out</a> <br/>
            
            <hr />
            
            
        </form>
    </body>
</html>
