
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>It's a great idea</title>
    </head>
    <body>
        <h1>Click OK to see Spring MVC web app with mybatis, mysql and (jquery + bootstrap)!</h1>

        <spring:nestedPath path="name">
            <form action="" method="post">
                <input type="submit" value="OK">
            </form>
        </spring:nestedPath>

    </body>
</html>