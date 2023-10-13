<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/includes/resources.jsp"/>
    <style>
        textarea.centro {
            background: url(http://i.imgur.com/2cOaJ.png);
            background-attachment: local;
            background-repeat: no-repeat;
            padding-left: 35px;
            padding-top: 10px;
            border-color:#ccc;
        }
    </style>
</head>
<body>
<div class="pt-lg-5 align-middle" >
    <div class="pt-8 container-fluid justify-content-center">
        <hr>
                <div class="pt-5">

                    <h1 class="text-center" style="color: #000000">Ingresa una nueva solucitud de activacion.</h1>
                    <div class="container justify-content-center">
                        <form action="${pageContext.request.contextPath}/usuario/suspension-servlet" method="post">
                            <label for="inDescripcion" class="col-form-label">Mensaje</label>
                            <textarea class="form-control centro" name="inDescripcion" id="inDescripcion" cols="75" rows="15"></textarea>
                            <span>
                <button type="submit" class="btn btn-primary">Aceptar</button>
                </span>
                        </form>
                    </div>
                </div>
    </div>
</div>
</body>
</html>