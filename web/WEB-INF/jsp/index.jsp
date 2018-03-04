<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<% Object error = request.getAttribute("error");
    Object errorExist = request.getAttribute("errorExist");
    Object created = request.getAttribute("created");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/js.js" />"></script>
        <title>Login</title>
    </head>

    <body>
        <div class="container">
            <c:if test="${created == true}">
                <div class="alert alert-success col-md-6 col-md-offset-3 ocultar">
                    El usuario se ha creado correctamente, inicia sesión!
                </div>
            </c:if>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#"  class="login-form-link active">Iniciar Sesión</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" class="register-form-link">Registrarse</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="/provaTecnica/login" method="post" role="form" style="display: block;">
                                        <div class="form-group">
                                            <input type="text" name="username" tabindex="1" class="form-control" placeholder="Username" value="" required="true">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" tabindex="2" class="form-control" placeholder="Password" required="true">
                                        </div>
                                        <c:if test="${not empty error}">
                                            <div class="alert alert-danger">
                                                <%=error%> 
                                                <%error = null;%>
                                            </div>
                                        </c:if>
                                        <c:if test="${not empty errorExist}">
                                            <div class="alert alert-danger">
                                                <%=errorExist%> 
                                                <%errorExist = null;%>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Iniciar Sesión">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <form id="register-form" action="/provaTecnica/register" method="post" role="form" style="display: none;">
                                        <div class="form-group">
                                            <input type="text" name="username" tabindex="1" class="form-control" placeholder="Username" required="true">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" tabindex="2" class="form-control" placeholder="Password" required="true">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="fullname" tabindex="1" class="form-control" placeholder="Full Name" required="true">
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Registrarse">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>           

    </body>
</html>
