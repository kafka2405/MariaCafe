<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maria Bagnarelli's Cafe</title>
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/listcake.css">
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp">
                <jsp:param name="current" value="about"/>
            </jsp:include>
            <!------- HEADER SECTION ------->
            <div class="body">
                <div class="alignment">
                    <div class="body-inner">
                        <div class="left-side col-9">
                            <div class="list-heading text-large">List of all Cake</div>
                            <c:forEach items="${listCake}" var="lc">
                                <div class="list-cake">
                                    <div class="list-cake__heading text-medium"><a class="list-cake__link" href="detailController?id=${lc.id}">${lc.name}</a></div>
                                    <div class="list-cake__content">
                                        <p class="list-cake__description col-8">${lc.shortDescription}</p>
                                        <div class="list-cake__image col-4">
                                            <img class="default-image" alt="cake" src="${lc.photoPath}">
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="pagination">
                                ${pagination}
                            </div>
                        </div>
                        <%@include file="sharing.jsp" %>
                        <!--Sharing on social-->
                    </div>
                </div>
            </div>
            <!-------- BODY SECTION -------->
            <%@include file="footer.jsp"%>
            <!------- FOOTER SECTION ------->
        </div>
    </body>
</html>
