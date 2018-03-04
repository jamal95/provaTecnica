<%-- 
    Document   : errorPage
    Created on : 03-mar-2018, 2:19:18
    Author     : jamal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/js.js" />"></script>
        <title>Error Page </title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="alert alert-warning center-block col-centered">${errorMsg}</div>
            </div>
            
        </div>
    </body>
</html>
