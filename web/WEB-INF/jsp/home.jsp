<%-- 
    Document   : home
    Created on : 24-feb-2018, 20:34:52
    Author     : jamal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Object user = request.getAttribute("user");%>
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
        <title>Home Page</title>
    </head>
    <body>
        <div class="container">
            <table class="table table-striped"> 
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Usuario</th>
                        <th scope="col">Nombre Completo</th>
                        <th scope="col">Ver Códigos</th>
                        <th scope="col">Generar Nuevo Código</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.fullname}"/></td>
                        <td><input class="btn btn-alert" type="submit" value="Ver Códigos" onclick="location.href = 'seeCodes'"/></td>
                        <td><input class="btn btn-success generatecodes" type="submit" value="Generar Código"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="container center">
            <input type="submit" value="Cerrar Sesión" class="btn btn-danger col-sm-2 logout" onclick="location.href = 'logout'" />
        </div>
    </body>
</html>
