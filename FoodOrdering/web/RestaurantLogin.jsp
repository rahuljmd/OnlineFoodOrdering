<%-- 
    Document   : signup11
    Created on : 27 Apr, 2021, 6:30:46 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant Login</title>
        <script>
            function go() {
                var xhttp = new XMLHttpRequest();
                var email = document.getElementById("email").value;
                var pass = document.getElementById("pass").value;
                     if(email!=""&&pass!=""){
                xhttp.onreadystatechange = function () {
                    
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        if(res==="success"){
                           window.location.href="RestaurantHome.jsp"; 
                        }
                        else{
                        alert(res);
                    }
                    }
                };
                var url = "./RestaurantLogin?email="+email+"&password="+pass;
                xhttp.open("GET", url, true);
                xhttp.send();
            }
            else{
                alert("Fill the form properly!!!");
            }
        }

        </script>
    </head>
    <body>

        <div class="container">
            <h1 class="jumbotron text-center" style="background-color: green ; color:white;">Restaurant Login</h1>
            <form>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Email</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="email" placeholder="email" id="email" required class="form-control"/> 
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Password</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="password" placeholder="password" id="pass" required="required" class="form-control"/>   
                    </div>
                </div>

                <div style="text-align: left">
                    <input type="button" value="Submit" class="btn btn-success" onclick="go()" />
                </div>
            </form>
            
            <br>
            <a href="RestaurantSignUp.jsp" style="color: blue;">Signup Now</a>&nbsp;&nbsp;
            <a href="ForgotPasswordRest.jsp" style="color: red;">Forgot Password</a>

        </div>
    </body>
</html>
