<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Oct 3, 2011, 2:07:31 PM
    Author     : beheraab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="js/jquery.qtip.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.min.js" ></script>
        <script type="text/javascript" src="js/jquery.qtip.js" ></script>
    </head>
    <form action="login" method="post">
        <fieldset>
            <legend>Login Details</legend>
            <label id="luserid" for="user">Username</label>
            <input type="text" name="username" id="user"/> <br/>
            <label for="pass">Password</label>
            <input type="password" name="pass" id="pass"/> <br/>
            <button type="submit">Login</button>
        </fieldset>
    </form>
    <script type="text/javascript">
        $(document).ready(function() {
            //$('a[title]').qtip();
            $('#user').qtip({
                content: 'Enter User name'
            });
        });
    </script>
</html>
