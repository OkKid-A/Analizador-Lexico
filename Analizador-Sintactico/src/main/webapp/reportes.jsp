<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/includes/resources.jsp"/>
</head>
<body>
<div>
    <a class="btn-dark" href="index.jsp">Regresar</a>
    <section class="header-main border-bottom bg-white">
        <div class="container-fluid">
            <div class="row p-2 pt-3 pb-3 d-flex justify-content-center">
                <div class="col-auto">
                    <div class="d-flex form-inputs justify-content-center">
                        <form id="form-reporte" action="${pageContext.request.contextPath}/servlet/reportes" method="post">
                            <label for="filtro">Selecciona el tipo de reporte:</label>
                            <select class="form-control " id="filtro" name="filtro" required>
                                <option value="0" selected>Tabla de Simbolos (global)</option>
                            </select>
                            <button class="btn btn-dark px-3" type="submit" form="form-reporte">
                                <i class="fa fa-search pt-1"></i>Procesar
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<c:if test="${!empty(tabla)}">
    <div id="incidencias">
        <div class="container" >
            <h3>Prestamos realizados en los ultimos 30 dias:</h3>
            <table id="listaPrest" class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Simbolo</th>
                    <th>Tipo</th>
                    <th>Valor</th>
                    <th>Linea</th>
                    <th>Columna</th>
                    <th>Bloque</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="simbolo" items="${tabla}" varStatus="status" >
                    <tr>
                        <td>${simbolo.lexema}</td>
                        <td>${simbolo.tipo}</td>
                        <td>${simbolo.valor}</td>
                        <td>${simbolo.linea}</td>
                        <td>${simbolo.columna}</td>
                        <td>${simbolo.bloque}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</c:if>
</body>
</html>