<%-- 
    Document   : codes
    Created on : 01-mar-2018, 22:19:57
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container codes">
            <div class="alert"><h2>Tus códigos:</h2></div>
            <table class="table table-striped"> 
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Canjear</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                </thead>
                <c:forEach var="listValue" items="${codes}">
                    <tbody>
                        <tr>
                            <c:choose>
                                <c:when test="${listValue.redeem == 'S'}">
                                    <td class="info info_msg"><c:out value="${listValue.code}" /></td>
                                </c:when>    
                                <c:otherwise>
                                    <td><c:out value="${listValue.code}" /></td>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${listValue.redeem == 'S'}">
                                    <td><input class="btn btn-basic redeemCode disabled" type="submit" value="Canjear" id="${listValue.id}"/></td>
                                    </c:when>    
                                    <c:otherwise>
                                    <td><input class="btn btn-success redeemCode" type="submit" value="Canjear" id="${listValue.id}"/></td>
                                    </c:otherwise>
                                </c:choose>
                            <td><input class="btn btn-danger deleteCode" type="submit" value="Eliminar" id="${listValue.id}"/></td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
