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
                var new_pass = document.getElementById("new_pass").value;
                var confirm_pass = document.getElementById("confirm_pass").value;
                
                     if(new_pass!=""&&confirm_pass!=""){
                         
                      if(new_pass!=confirm_pass){
                          alert("Passwords don't match!!");
                      }
                      else{
            xhttp.onreadystatechange = function () {
                    
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);
                        window.location.href="CustomerLogin.jsp";

                    }
                };
                var url = "./RecoverCustPass?email="+email+"&new_pass="+new_pass;
                xhttp.open("GET", url, true);
                xhttp.send();
                
        }
            }
            else{
                alert("All fields are required!!!");
            }
        }

        </script>
    </head>
    <body>
         <%
             String email = request.getParameter("email");
             %>
       <div class="container">
            <h1 class="jumbotron text-center" style="background-color: #007bff ; color:white;">Recover Password</h1>
            <form>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Enter Email</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="email" placeholder=" enter email" id="email" value="<%=email%>" readonly required class="form-control"/> 
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Enter New Password</label>  
                    </div>
                    <div class="col-sm-6">
                        <input type="password" placeholder=" enter password" id="new_pass" class="form-control"/> 
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Confirm Password</label>  
                    </div>
                    <div class="col-sm-6">
                      <input type="password" placeholder=" confirm password" id="confirm_pass" class="form-control"/>  
                    </div>
                </div>
               
                <div style="text-align: center;" class="mt-5">
                    <input type="button" value="Submit" class="btn btn-success btn-sm" onclick="go()" />
                </div>
            </form>
            
        </div>
    </body>
</html>
