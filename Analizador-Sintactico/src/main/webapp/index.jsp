<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/includes/resources.jsp"/>
</head>
<body>
<div class="pt-lg-5 align-middle" >
    <div class="pt-8 container-fluid justify-content-center">
        <hr>
                <div class="pt-5 container">
                    <h1 class="text-center" style="color: #000000">Ingresa el texto a Analizar.</h1>
                    <div class="container justify-content-center">
                        <form action="${pageContext.request.contextPath}servlet/parser-servlet" method="get">
                            <label for="editor" class="col-form-label">Mensaje</label>
                            <textarea class="form-control centro" name="editor" id="editor" ></textarea>
                            <span>
                            <button type="submit" class="btn btn-primary">Aceptar</button>
                             </span>
                        </form>
                    </div>
                </div>
    </div>
</div>
</body>
<script>
    var editor = CodeMirror.fromTextArea(document.getElementById('editor'), {
        lineNumbers: true,
        mode: 'text/x-perl',
        matchBrackets: true,
    });
</script>
</html>