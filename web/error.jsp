<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maria Bagnarelli's Cafe</title>
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/error.css">
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp">
                <jsp:param name="current" value="home"/>
            </jsp:include>
            <!------- HEADER SECTION ------->
            <div class="body">
                <div class="alignment">
                    <div class="body-inner">
                        <c:choose>
                            <c:when test="${error eq null}">
                                <div class="error-container">
                                    <h1 class="error-heading text-large">Oops!Nothing to see here.</h1>
                                    <div class="error-content text-medium">Server is in maintenance. Please try again late!</div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="error-container">
                                    <h1 class="error-heading">${error}</h1>
                                    <div class="error-content">Sorry for this convenience. Please try again late!</div>
                                </div>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
            <!-------- BODY SECTION -------->
            <%@include file="footer.jsp" %>
            <!------- FOOTER SECTION ------->
        </div>
    </body>
</html>

