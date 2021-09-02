<%-- 
    Document   : AdminChangePassword
    Created on : 19 May, 2021, 10:40:00 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>-->
        
 <%@include file="AdminHead.jsp" %>
 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            String username="";
            if(session.getAttribute("admin_username")==null){
                response.sendRedirect("adminlogin.jsp");
            }
            else{
                 username=session.getAttribute("admin_username").toString();
            }
            %>
        <script>
            function go() {
                var xhttp = new XMLHttpRequest();
                var user= document.getElementById("user").value;
                var old_pass = document.getElementById("old_pass").value;
                var new_pass = document.getElementById("new_pass").value;
                var confirm_pass = document.getElementById("confirm_pass").value;
                if (user!= "" && old_pass != "" && new_pass != ""&&confirm_pass!="") {
                    if (confirm_pass != new_pass) {
                        alert("New passwords don't match!!");
                    } else {

                        xhttp.onreadystatechange = function () {

                            if (this.readyState == 4 && this.status == 200) {
                                var res = this.responseText.trim();
                                console.log(res);
                                alert(res);
                            }
                        };
                        var url = "./AdminChangePassword?user=" +user+"&old_pass="+old_pass+"&new_pass="+new_pass;
                        xhttp.open("GET", url, true);
                        xhttp.send();
                    }

                } else {
                    alert("All fields are required!!!");
                }

            }

        </script>
    </head>
    <body>
        
 <%@include file="AdminHeader.jsp" %>
 
 
        <div class="container">
            <!--style="background-color: #007bff ; color:white;"-->
            <h1 class="jumbotron text-center" style="background-color: #007bff;color: white;" >Admin Change Password</h1>
            <form>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Enter Username</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="text" placeholder="username" id="user" value="<%=username%>" readonly="readonly" class="form-control"/> 
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Enter Old Password</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="password" placeholder=" old password" id="old_pass" required="required" class="form-control"/>   
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Enter New Password</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="password" placeholder="new password" id="new_pass" required="required" class="form-control"/>   
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Confirm New Password</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="password" placeholder=" confirm password" id="confirm_pass" required="required" class="form-control"/>   
                    </div>
                </div>

                <div style="text-align: left">
                    <input type="button" value="Submit" class="btn btn-primary" onclick="go()" />
                </div>
            </form>

        </div>
        <br><br><br>
    </body>
</html>
