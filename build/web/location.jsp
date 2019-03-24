<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/location.css">
        <title>Maria Bagnarelli's Cafe</title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp">
                <jsp:param name="current" value="find"/>
            </jsp:include>
            <!------- HEADER SECTION ------->
            <div class="body">
                <div class="alignment">
                    <div class="body-inner">
                        <div class="left-side col-9">
                            <div class="find-us-heading">
                                <div class="text-large">Find Maria's Cafe</div>
                            </div>
                            <div class="find-us-content">
                                <div class="content-container">
                                    <div class="address-and-contact col-6">
                                        <div class="title-heading">
                                            <div class="address-title text-medium">Address and contact</div>
                                        </div>
                                        <div class="address-container">
                                            <div class="address__details">
                                                <p>${info.address}</p>
                                            </div>
                                            <div class="tel-email">
                                                <div class="tel-email__heading col-4">
                                                    Tel:
                                                </div>
                                                <div class="tel-email__data col-8">
                                                    <a href="tel:12345">
                                                        ${info.tel}
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="tel-email">
                                                <div class="tel-email__heading col-4">
                                                    Email:
                                                </div>
                                                <div class="tel-email__data col-8">
                                                    <a href="mailto:your-email@your-email.com">
                                                        ${info.email}
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="opening-hours col-6">
                                        <div class="title-heading">
                                            <div class="opening-hours-title text-medium">Opening hours</div>
                                        </div>
                                        <div class="opening-hours-content">
                                            <p>${info.schedule}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="google-maps">
                                    <img class="default-image" alt="maps" src="${info.photoPath}">
                                </div>
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
