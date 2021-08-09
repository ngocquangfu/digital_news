<%-- 
    Document   : Search
    Created on : May 18, 2021, 6:04:25 PM
    Author     : mynameis
--%>

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
                    <%
                        int total = (Integer) request.getAttribute("total");

                        if (total == 0) {

                    %>
                    <h1 style="text-align: center">Not found</h1>
                    <% } else {

                    %>
                    <c:forEach items="${list}"var="o">
                        <div class="head-title">
                            <h4>
                                <a href="detail?id=${o.id}">${o.title}</a>   
                            </h4>
                        </div>

                        <div class="image">

                            <h4>
                                <img src="./image/${o.image}" alt="image" id="image">
                                ${o.description}

                            </h4>
                        </div>

                        <div class="description">


                        </div>

                    </c:forEach>
                    <div class="paging">


                        <c:forEach begin="0" end="${paging}" var="t">
                            <a href="search?num=${t}&&search=${searchname}" style="border:2px solid black;border-radius:5px;margin-left: 10px">${t}</a>
                        </c:forEach>



                    </div>
                    <%                        }

                    %>

                </div>


                <!-- ben trai-->
                <!-- ben phải-->

                <div class="title-right">
                    <div class="description-right">
                        <h4>Digital News</h4>
                        <h5>
                            ${requestScope.digital.shortDescription}
                        </h5>
                    </div>
                    <div class="search">
                        <h4>Search</h4>
                        <div class="search-title">
                            <form action="search" method="get">
                                <input type="text" name="search" id="search" style="border: 2px dashed;color:#003366;width: 100px" >
                                <input type="submit" value="Go" id="submit">
                            </form>
                        </div>
                    </div>
                    <div class="lastArticle">
                        <c:forEach items="${top5}" var="o">
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
