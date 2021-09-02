<%-- 
    Document   : ForgotPassword
    Created on : 29 May, 2021, 3:58:41 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script>
            function go() {
                var xhttp = new XMLHttpRequest();
                var email = document.getElementById("email").value;
                     if(email!=""){
                xhttp.onreadystatechange = function () {
                    
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);

                    }
                };
                var url = "./ForgotPassRest?email="+email;
                xhttp.open("GET", url, true);
                xhttp.send();
            }
            else{
                alert("Enter email first!!!");
            }
        }

        </script>
    </head>
    <body>
       <div class="container">
            <h1 class="jumbotron text-center" style="background-color: green ; color:white;">Forgot Password</h1>
            <form>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Enter Email</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="email" placeholder=" enter email" id="email" required class="form-control"/> 
                    </div>
                </div>
               
                <div style="text-align: center;" class="mt-5">
                    <input type="button" value="Submit" class="btn btn-success btn-sm" onclick="go()" />
                </div>
            </form>
            
        </div>
    </body>
</html>
