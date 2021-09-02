<%-- 
    Document   : StandardRestaurantPage
    Created on : 18 May, 2021, 12:18:21 AM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            String email="";
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                email=session.getAttribute("restaurant_email").toString();
            }
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="RestaurantHeader1.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="RestaurantHeader.jsp" %>
        <div class="conatiner">
            
            
        </div>

    </body>
</html>
