<%-- 
    Document   : StandardRestaurantPage
    Created on : 18 May, 2021, 12:18:21 AM
    Author     : RAHUL
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="vmm.Dbloader"%>
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
            
            <style>
                table th{
                    text-align: center;
                }
            </style>
            
            <script>
                function fetchRestaurantOrders(){
                                     var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                      var res = this.responseText.trim();
                      console.log(res);
                      var mainobj=JSON.parse(res);
                      var arr=mainobj["ans"];
                      var ans="<table class='table table-hover table-bordered'>";
                      ans=ans+"<tr>";
                      ans=ans+"<th>Bill id</th>";
                      ans=ans+"<th>Restaurant Name</th>";
                      ans=ans+"<th>Customer email</th>";
                      ans=ans+"<th>Date Time</th>";
                      ans=ans+"<th>Subtotal</th>";
                      ans=ans+"<th>Delivery Charges</th>";
                      ans=ans+"<th>tax(%)</th>";
                      ans=ans+"<th>Discount</th>";
                      ans=ans+"<th>Total</th>";
                      ans=ans+"<th>Payment Method</th>";
                      ans=ans+"<th>View Details</th>";
                      ans=ans+"<th>Action</th>";
                      ans=ans+"</tr>";
                      for(var i=0;i<arr.length;i++){
                          ans=ans+"<tr>";
                          ans=ans+"<td>"+arr[i]["bill_id"]+"</td>";
                          ans=ans+"<td>"+arr[i]["restaurant_name"]+"</td>";
                          ans=ans+"<td>"+arr[i].customer_email+"</td>";
                          ans=ans+"<td>"+arr[i].date_time_of_bill+"</td>";
                          ans=ans+"<td>"+arr[i].subtotal+"</td>";
                          ans=ans+"<td>"+arr[i].delivery_charges+"</td>";
                          ans=ans+"<td>"+arr[i]["tax(%)"]+"</td>";
                          ans=ans+"<td>"+arr[i].discount+"</td>";
                          ans=ans+"<td>"+arr[i].total+"</td>";
                          ans=ans+"<td>"+arr[i].payment_method+"</td>";
                          ans=ans+"<td><button class=\'btn btn-success\' data-toggle=\"modal\" data-target=\"#exampleModal\" onclick='fetchOrderDetails("+arr[i]["bill_id"]+")'>View</button></td>";
                          ans=ans+"<td><button class=\'btn btn-primary\' onclick=\'changeStatus("+arr[i]["bill_id"]+",\"delivered\")\'>Delivered</button><br><br><button class=\'btn btn-danger\' onclick=\'changeStatus("+arr[i]["bill_id"]+",\"cooking\")\'>Cooking</button></td>";
                          ans=ans+"</tr>";
                      }
            ans=ans+"</table>";
            document.getElementById("d1").innerHTML=ans;
   
                    }
                };
                xhttp.open("GET", "./FetchRestaurantOrders", true);
                xhttp.send();
            }
            
            function changeStatus(bill_id,option){
                console.log(option);
                   var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                      var res = this.responseText.trim();
                    alert(res);
                      }
                    
                };
                xhttp.open("GET", "./ChangeBillStatus?bill_id="+bill_id+"&option="+option, true);
                xhttp.send();   
            }
            
             function fetchOrderDetails(bill_id){
                      var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                      var res = this.responseText.trim();
                             console.log(this.responseText);
                      var mainobj=JSON.parse(res);
                      var arr=mainobj["ans"];
                      var ans="<table class='table table-hover table-bordered'>";
                      ans=ans+"<tr>";
                      ans=ans+"<th>Name</th>";
                      ans=ans+"<th>Price</th>";
                      ans=ans+"<th>Quantity</th>";
                      ans=ans+"<th>Amount</th>";
                      ans=ans+"</tr>";
                      for(var i=0;i<arr.length;i++){
                          ans=ans+"<tr>";
                          ans=ans+"<td>"+arr[i]["item_name"]+"</td>";
                          ans=ans+"<td>"+arr[i]["price"]+"</td>";
                          ans=ans+"<td>"+arr[i]["quantity"]+"</td>";
                          ans=ans+"<td>"+arr[i]["amount"]+"</td>";
                          ans=ans+"</tr>";
                      }
            ans=ans+"</table>";
                       document.getElementById("d3").innerHTML=ans; 
                    }
                };
                xhttp.open("GET", "./FetchBillDetailsRestaurant?bill_id="+bill_id, true);
                xhttp.send();
            }
                
            </script>
          
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="RestaurantHeader1.jsp" %>
        <title>JSP Page</title>
    </head>
    <body onload="fetchRestaurantOrders()">
        <%@include file="RestaurantHeader.jsp" %>
        
          <div class="container-fluid mt-5">
              <div id="d1" class="text-center" style="overflow-x: auto; width: 100%">
                    
                </div>
            </div>

        <div id="d2">
            <!-- Modal -->
            <div class="modal fade modal-dialog modal-dialog-scrollable" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
          <h3 class="modal-title" id="exampleModalLabel"><strong>Bill Details</strong></h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="font-size:25pt;">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="d3">
       
      </div>
        
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
        </div>
        
    </body>
</html>
