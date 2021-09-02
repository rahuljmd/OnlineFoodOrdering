<%-- 
    Document   : CustomerVerification
    Created on : 27 May, 2021, 3:18:06 PM
    Author     : RAHUL
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="vmm.Dbloader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
       <% try{
             String email = request.getParameter("email");
            String otp = request.getParameter("otp");
              
            ResultSet rs=Dbloader.executeSql("select * from customer where email_id='"+email+"'");
            if(rs.next()){
             String otp2 = rs.getString("otp");
             
             if(otp2.equals(otp)){
                 rs.moveToCurrentRow();
                  rs.updateString("status","approve");
                  rs.updateRow();
//                 out.println("Otp Matched");
                 %>
                 <h1>Account Verified Successfully</h1>
                 <a href="CustomerLogin.jsp" class="text-center">Go To Login Page</a>
                 
                 <!--buton Go to Home  page-->
               <%
             }
             else {
                 out.println("Invalid Otp");
                  
             }
            }
            else{
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
            %>
    </body>
</html>
