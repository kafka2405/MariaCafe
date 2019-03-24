<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maria Bagnarelli's Cafe</title>
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/details.css">
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp">
                <jsp:param name="current" value="detail"/>
            </jsp:include>
            <!------- HEADER SECTION ------->
            <div class="body">
                <div class="alignment">
                    <div class="body-inner">
                        <div class="left-side col-9">
                            <div class="page-title text-large">
                                ${cake.name}
                            </div>
                            <div class="page-content">
                                <p>
                                    <img class="page-content__image" src="${cake.photoPath}">
                                    ${cake.fullDescription}
                                </p>
                            </div>
                            <div class="price text-medium">Price: $${cake.price}</div>
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
