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
        <title>Admin Login</title>
        <script>
            function go() {
                var xhttp = new XMLHttpRequest();
                var user = document.getElementById("user").value;
                var pass = document.getElementById("pass").value;
                     if(user!=""&&pass!=""){
                xhttp.onreadystatechange = function () {
                    
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        if(res==="success"){
                           window.location.href="AdminHome.jsp"; 
                        }
                        else{
                        alert(res);
                    }
                    }
                };
                var url = "./adminlogin?username="+user+"&password="+pass;
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
            <h1 class="jumbotron text-center" style="background-color: #007bff ; color:white;">Admin Login</h1>
            <form>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Username</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="text" placeholder="username" id="user" required class="form-control"/> 
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

        </div>
    </body>
</html>
