<%-- 
    Document   : RestaurantHome
    Created on : 18 May, 2021, 12:18:21 AM
    Author     : RAHUL
--%>

<%@page import="vmm.Dbloader"%>
<%@page import="java.sql.ResultSet"%>
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
            <%
            ResultSet rs=Dbloader.executeSql("select * from restaurant where email_id='"+email+"'");
            while(rs.next()){
               String name=rs.getString("restaurant_name");
               String photo_wide=rs.getString("photo_wide");
               String photo_square=rs.getString("photo_square");
               String mobile=rs.getString("mobile");
               String del_start=rs.getString("delivery_start");
               String del_end=rs.getString("delivery_end");
               int min_del= rs.getInt("min_delivery");
               int del_charges= rs.getInt("delivery_charges");
            
            %>
           
            <div class="conatiner text-center">
                <img src="<%=photo_wide%>" alt="image" style="width: 450px;height:150px;"/>     <br>
                <h2>Welcome <%=name%></h2>
            </div>
                <br><br>
                <div class="text-center container">
               <div class="row">
                   <div class="col-sm-4">
                       <img src="<%=photo_square%>" style="width: 200px;height: 200px;" alt="image"/>
                   </div>
                   <div class="col-sm-4 text-left" style="margin-top: 20px;">
                       <label>Mobile: <%= mobile%></label><br>
                       <label>Email: <%= email%></label><br>
                       <label>Delivery Charges: <%= del_charges%></label><br>
                       <label>Minimum Delivery: <%= min_del%></label><br>
                       <label>Start Time: <%= del_start%></label><br>
                       <label>Close Time: <%= del_end%></label><br>
                   </div>
               </div>
                </div>
               <%
               }
               %>
               
        </div>
               <br><br><br><br>
    </body>
</html>
