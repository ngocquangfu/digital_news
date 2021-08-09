<%-- 
    Document   : Search
    Created on : May 18, 2021, 6:04:25 PM
    Author     : mynameis
--%>

<%@page import="model.Digital"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/homepage.css">

        <title>Search Page</title>
    </head>
    <body>
        <div class="container">
            <div class="preheader">

            </div>
            <div class="header">
                <h4>My digital New</h4>
            </div>
            <div class="menu">
                <h4><a href="digital">New</a></h4>

            </div>
            <div class="background">
                <!-- ben trai-->
                
                <div class="title-left">

                    <div class="head-title">
                        <h4>
                          ${requestScope.digital.title}
                        </h4>
                    </div>

                    <div class="image">
                        <img src="./image/${requestScope.digital.image}" alt="image">
                    </div>

                    <div class="description">
                        <h4>
                           ${requestScope.digital.description}

                        </h4>

                    </div>
                    <div class="author">

                        <h4>
                            <img src="./image/timeicon.gif" alt="icon">
                            <img src="./image/comment.gif" alt="icon">
                            By ${requestScope.digital.author} | ${requestScope.digital.timePost}
                        </h4>

                    </div>



                </div>


                <!-- ben trai-->
                <!-- ben phải-->

                <div class="title-right">
                    <div class="description-right">
                        <h4>
                            Digital News
                        </h4>
                        <h5>
                            ${requestScope.digital.shortDescription}
                        </h5>
                    </div>
                    <div class="search">
                        <h4>Search</h4>
                        <div class="search-title">
                            <form action="search" method="get">
                                <input type="text" name="search" id="search" style="border: 2px dashed;color:#003366;width: 100px">
                                <input type="submit" value="Go" id="submit">
                            </form>
                        </div>
                    </div>
                    <div class="lastArticle">
                        <c:forEach items="${list}" var="o">
                            <h5><a href="detail?id=${o.id}">${o.title}</a></h5>
                            </c:forEach>
                    </div>
                </div>
            </div>
            <div class="footer">
            </div>
        </div>
    </body>
</html>
