<%-- 
    Document   : ViewRestSale
    Created on : 26 May, 2021, 5:25:56 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            String email="";
            int rid=0;
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                email=(String)session.getAttribute("restaurant_email");
               rid=(int)session.getAttribute("rid");

            }
            %>
        <script>
            function go(){
                var start=document.getElementById("start").value;
                var end=document.getElementById("end").value;
                console.log(start);
                console.log(end);
                
                     if(start!=""&&end!=""){
                          var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        var mainobj=JSON.parse(res);
                        var arr = mainobj["ans"];
                        var ans = "<table class='table table-bordered'>";
                        ans = ans + "<tr>";
                        ans = ans + "<th>Date_of_Bill</th>";
                        ans = ans + "<th>Sale</th>";
                        ans = ans + "</tr>";
                        
                        for(var i=0;i<arr.length;i++){
                            ans=ans+"<tr>";
                            ans=ans+"<td>"+arr[i]["date"]+"</td>"
                            ans=ans+"<td>"+arr[i]["amount"]+"</td>"
                            ans=ans+"</tr>";
                        }
          ans=ans+"</table>";
          document.getElementById("d1").innerHTML=ans;              
                    }
                };
                var url = "./ViewSales?start="+start+"&end="+end;
                xhttp.open("GET", url, true);
                xhttp.send();
            }
            else{
                alert("All fields are required!!!");
            }
            }
            
            function viewTotalSale(){
                var start=document.getElementById("start").value;
                var end=document.getElementById("end").value;
                console.log(start);
                console.log(end);
                
                     if(start!=""&&end!=""){
                          var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        var mainobj=JSON.parse(res);
                        var arr = mainobj["ans"];
                        var ans = "<table class='table table-bordered'>";
                        ans = ans + "<tr>";
                        ans = ans + "<th>Date_Time</th>";
                        ans = ans + "<th>Total Sale</th>";
                        ans = ans + "</tr>";
                        
                        for(var i=0;i<arr.length;i++){
                            ans=ans+"<tr>";
                            ans=ans+"<td>"+arr[i]["date_time_of_bill"]+"</td>"
                            ans=ans+"<td>"+arr[i]["amount"]+"</td>"
                            ans=ans+"</tr>";
                        }
          ans=ans+"</table>";
          document.getElementById("d2").innerHTML=ans;              
                    }
                };
                var url = "./ViewTotalSales?start="+start+"&end="+end;
                xhttp.open("GET", url, true);
                xhttp.send();
            }
            else{
                alert("All fields are required!!!");
            }
            }
        </script>
    </head>
    <body>
        <%@include file="RestaurantHeader.jsp" %>
        <h1 class="jumbotron text-center" style="background-color: green; color:white;">View Restaurant Sales</h1>
        <div class="container" style="margin-top: 30px;">
            <form>
                <div class="row">
                    <div class="col-sm-3">
                        <label>From</label>
                    </div>
                    <div class="col-sm-3">
                        <label>To</label>
                    </div>
                   </div>
                <div class="row">
                    <div class="col-sm-3">
                        <input type="date" id="start" placeholder="enter start date" class="form-cntrol"/>
                    </div>
                    <div class="col-sm-3">
                         <input type="date" id="end" placeholder="enter end date" class="form-cntrol"/>
                       
                    </div>
                    <div class="col-sm-3">
                        <input type="button" class="btn btn-success" value="Search" onclick="go()"/>
                    </div>
                    <div class="col-sm-3">
                        <input type="button" class="btn btn-success" value="View Total Sale" onclick="viewTotalSale()"/>
                    </div>
                </div>
            </form>
            <br>
            <div id="d1">
                
            </div>
            <br>
            <div id="d2">
                
            </div>
            
        </div>
    </body>
</html>
