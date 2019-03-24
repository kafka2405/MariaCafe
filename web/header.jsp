<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <div class="header">
            <div class="alignment">
                <div class="page-heading">
                    <div class="page-heading__title">Maria Bagnarelli's Cafe</div>
                    <div class="page-heading__subtitle">Welcome to my website</div>
                </div>
                <div class="navigation">
                    <ul class="navigation__list">
                        <c:choose>
                            <c:when test="${param.current == 'home'}">
                                <li class="navigation__item"><a class="navigation__link navigation__link--active" href="homeController">Home</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="aboutController">About my Cake</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="findController">Find Maria's Cafe</a></li>
                            </c:when>
                                <c:when test="${param.current == 'about'}">
                                <li class="navigation__item"><a class="navigation__link" href="homeController">Home</a></li>
                                <li class="navigation__item"><a class="navigation__link  navigation__link--active" href="aboutController">About my Cake</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="findController">Find Maria's Cafe</a></li>
                            </c:when>
                                <c:when test="${param.current == 'find'}">
                                <li class="navigation__item"><a class="navigation__link" href="homeController">Home</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="aboutController">About my Cake</a></li>
                                <li class="navigation__item"><a class="navigation__link  navigation__link--active" href="findController">Find Maria's Cafe</a></li>
                            </c:when>
                                <c:when test="${param.current == 'error'}">
                                <li class="navigation__item"><a class="navigation__link" href="homeController">Home</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="aboutController">About my Cake</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="findController">Find Maria's Cafe</a></li>
                                <li class="navigation__item"><a class="navigation__link navigation__link--active">Error Page</a></li>
                            </c:when>
                                <c:when test="${param.current == 'detail'}">
                                <li class="navigation__item"><a class="navigation__link" href="homeController">Home</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="aboutController">About my Cake</a></li>
                                <li class="navigation__item"><a class="navigation__link" href="findController">Find Maria's Cafe</a></li>
                                <li class="navigation__item"><a class="navigation__link navigation__link--active">Cake Details</a></li>
                            </c:when>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
