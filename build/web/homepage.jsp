<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maria Bagnarelli's Cafe</title>
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
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
                        <div class="left-side col-9">
                            <div class="introduction">
                                <div class="intro__image col-3">
                                    <img class="default-image" src="${intro.photoPath}">
                                </div>
                                <div class="intro__content col-9">
                                    <div class="intro__heading text-large">
                                        <a class="intro__link" href="detailController?id=${intro.id}">${intro.name}</a>
                                    </div>
                                    <p class="intro__description">${intro.shortDescription}</p>
                                </div>
                            </div>
                            <div class="list-cake">
                                <c:forEach items="${listCake}" var="lc">
                                    <div class="cake col-5-5">
                                        <div class="cake__image">
                                            <img class="default-image" src="${lc.photoPath}">
                                        </div>
                                        <div class="cake__title text-medium">
                                            <a class="cake__link" href="detailController?id=${lc.id}">${lc.name}</a>
                                        </div>
                                        <p class="cake__description">
                                            ${lc.shortDescription}
                                        </p>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="visit-cafe">
                                <p class="visit-cafe__heading text-medium">Visit my cafe</p>
                                <p class="visit-cafe__info">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</p>
                                <p class="visit-cafe__info">${info.address}</p>
                                <p class="visit-cafe__info">Phone: ${info.tel}</p>
                            </div>
                        </div>
                        <%@include file="sharing.jsp" %>
                        <!--Sharing on social-->
                    </div>
                </div>
            </div>
            <!-------- BODY SECTION -------->
            <%@include file="footer.jsp" %>
            <!------- FOOTER SECTION ------->
        </div>
    </body>
</html>
