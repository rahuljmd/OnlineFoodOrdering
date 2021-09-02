<%-- 
    Document   : AdminHome
    Created on : 8 May, 2021, 12:21:31 AM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <%@include file="AdminHead.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table th ,td{
                text-align: center;
            }
        </style>
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
//            var rid;
            function pendingRestaurants(){
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                          var res = this.responseText;
                        var mainobj= JSON.parse(res.trim());
                        var arr=mainobj["ans"];
                        console.log(arr);
               var ans="<table class=\"table table-bordered\">";
               ans=ans+"<tr>";
               ans=ans+"<th>id</th>";
               ans=ans+"<th>name</th>";
               ans=ans+"<th>city</th>";
               ans=ans+"<th>mobile</th>";
               ans=ans+"<th>address</th>";
               ans=ans+"<th>description</th>";
               ans=ans+"<th>photo</th>";
               ans=ans+"<th>open time</th>";
               ans=ans+"<th>close time</th>";
               ans=ans+"<th>Minimum delivery</th>";
               ans=ans+"<th>Delivery charges</th>";
               ans=ans+"<th>Action</th>";
               ans=ans+"</tr>";
               for(var i=0;i<arr.length;i++){
                      ans = ans + "<tr>";
                            ans = ans + "<td id='td1'>" + arr[i]["restaurant_id"] + "</td>";
                            ans = ans + "<td>" + arr[i]["restaurant_name"] + "</td>";
                            ans = ans + "<td>" + arr[i]["city"] + "</td>";
                            ans = ans + "<td>" + arr[i]["mobile"] + "</td>";
                            ans = ans + "<td>" + arr[i]["address"] + "</td>";
                            ans = ans + "<td>" + arr[i]["description"] + "</td>";
                            ans = ans + "<td><img src=\"" + arr[i]["photo_square"] + "\" style='width:150px;height:150px;'/></td>";
                            ans = ans + "<td>" + arr[i]["delivery_start"] + "</td>";
                            ans = ans + "<td>" + arr[i]["delivery_end"] + "</td>";
                            ans = ans + "<td>" + arr[i]["min_delivery"] + "</td>";
                            ans = ans + "<td>" + arr[i]["delivery_charges"] + "</td>";
                            ans = ans + "<td><button class='btn btn-primary' onclick=\'go("+arr[i]["restaurant_id"]+")\'>Approve</button></td>";
                            ans = ans + "</tr>";
//                            rid= arr[i]["restaurant_id"];
                            
               }
               ans=ans+"</table>";
                        
                 document.getElementById("d1").innerHTML =ans;
                    }
                };
                xhttp.open("GET", "./ViewPendingRestaurants", true);
                xhttp.send();
            }
            
            function approvedRestaurants(){
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                          var res = this.responseText;
                        var mainobj= JSON.parse(res.trim());
                        var arr=mainobj["ans"];
                        console.log(arr);
               var ans="<table class=\"table table-bordered\">";
               ans=ans+"<tr>";
               ans=ans+"<th>id</th>";
               ans=ans+"<th>name</th>";
               ans=ans+"<th>city</th>";
               ans=ans+"<th>mobile</th>";
               ans=ans+"<th>address</th>";
               ans=ans+"<th>description</th>";
               ans=ans+"<th>photo</th>";
               ans=ans+"<th>open time</th>";
               ans=ans+"<th>close time</th>";
               ans=ans+"<th>Minimum delivery</th>";
               ans=ans+"<th>Delivery charges</th>";
               ans=ans+"<th>Action</th>";
               ans=ans+"</tr>";
               for(var i=0;i<arr.length;i++){
                      ans = ans + "<tr>";
                            ans = ans + "<td>" + arr[i]["restaurant_id"] + "</td>";
                            ans = ans + "<td>" + arr[i]["restaurant_name"] + "</td>";
                            ans = ans + "<td>" + arr[i]["city"] + "</td>";
                            ans = ans + "<td>" + arr[i]["mobile"] + "</td>";
                            ans = ans + "<td>" + arr[i]["address"] + "</td>";
                            ans = ans + "<td>" + arr[i]["description"] + "</td>";
                            ans = ans + "<td><img src=\"" + arr[i]["photo_square"] + "\" style='width:150px;height:150px;'/></td>";
                            ans = ans + "<td>" + arr[i]["delivery_start"] + "</td>";
                            ans = ans + "<td>" + arr[i]["delivery_end"] + "</td>";
                            ans = ans + "<td>" + arr[i]["min_delivery"] + "</td>";
                            ans = ans + "<td>" + arr[i]["delivery_charges"] + "</td>";
                            ans = ans + "<td><button class=\'btn btn-primary\' onclick=\'go("+arr[i]["restaurant_id"]+")\'>Pending</button></td>";
                            ans = ans + "</tr>";
               }
               ans=ans+"</table>";
                        
                 document.getElementById("d2").innerHTML =ans;
                    }
                };
                xhttp.open("GET", "./ViewApprovedRestaurants", true);
                xhttp.send();
            }
            
            function go(rid) {
                
                console.log(rid);
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                     var res=this.responseText;
                     console.log(res);
                     pendingRestaurants();
                     approvedRestaurants();
                    }
                };
                xhttp.open("GET", "./ChangeStatus?rid=" + rid, true);
                xhttp.send();
            }
           
            
        </script>
    </head>
    <body onload="pendingRestaurants(),approvedRestaurants()">
        <%@include file="AdminHeader.jsp" %>
        <h3 class="text-center mt-3">Pending Restaurants</h3>
        <div id="d1">
            Answer will be shown here....
        </div>
         <h3 class="text-center mt-3">Approved Restaurants</h3>
 
        <div id="d2">
            
        </div>
    </body>
</html>
