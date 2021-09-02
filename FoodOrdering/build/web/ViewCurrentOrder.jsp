<%-- 
    Document   : ViewCurrentOrder
    Created on : 16 May, 2021, 5:54:03 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="header.jsp" %>
        <%
             String email="";
        
        if(request.getSession().getAttribute("customer_email")==null){
              response.sendRedirect("CustomerLogin.jsp");
          }
        else{
         email=(String)request.getSession().getAttribute("customer_email");
        }
            %>
        <script>
            function fetchOrder(){
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
//                      ans=ans+"<th>Customer email</th>";
                      ans=ans+"<th>Date Time</th>";
                      ans=ans+"<th>Subtotal</th>";
                      ans=ans+"<th>Delivery Charges</th>";
                      ans=ans+"<th>tax(%)</th>";
                      ans=ans+"<th>Discount</th>";
                      ans=ans+"<th>Total</th>";
                      ans=ans+"<th>Payment Method</th>";
                      ans=ans+"<th>Status</th>";
                      ans=ans+"<th>View Details</th>";
                      ans=ans+"</tr>";
                      for(var i=0;i<arr.length;i++){
                          ans=ans+"<tr>";
                          ans=ans+"<td>"+arr[i]["bill_id"]+"</td>";
                          ans=ans+"<td>"+arr[i]["restaurant_name"]+"</td>";
//                          ans=ans+"<td>"+arr[i].customer_email+"</td>";
                          ans=ans+"<td>"+arr[i].date_time_of_bill+"</td>";
                          ans=ans+"<td>"+arr[i].subtotal+"</td>";
                          ans=ans+"<td>"+arr[i].delivery_charges+"</td>";
                          ans=ans+"<td>"+arr[i]["tax(%)"]+"</td>";
                          ans=ans+"<td>"+arr[i].discount+"</td>";
                          ans=ans+"<td>"+arr[i].total+"</td>";
                          ans=ans+"<td>"+arr[i].payment_method+"</td>";
                          ans=ans+"<td>"+arr[i].status+"</td>";
                          ans=ans+"<td><button class=\'btn btn-success\' data-toggle=\"modal\" data-target=\"#exampleModal\" onclick='fetchOrderDetails("+arr[i]["bill_id"]+")'>View</button></td>";
                          ans=ans+"</tr>";
                      }
            ans=ans+"</table>";
            document.getElementById("d1").innerHTML=ans;
   
                    }
                };
                xhttp.open("GET", "./FetchUserCurrentOrders", true);
                xhttp.send();
            }
            
            function fetchOrderDetails(bill_id){
                console.log(bill_id);
                      var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                      var res = this.responseText.trim();
                             console.log(res);
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
                xhttp.open("GET", "./FetchBillDetails?bill_id="+bill_id, true);
                xhttp.send();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="fetchOrder()">
        
        <%@include file="menubar.jsp" %>
        <div class="slider-wrap mb-5">
            <section class="home-slider owl-carousel">
                <div class="slider-item" style="background-image: url('img/hero_1.jpg');">
                    <div class="container">
                        <div class="row slider-text align-items-center justify-content-center">
                            <div class="col-md-8 text-center col-sm-12 ">
                                <h1 data-aos="fade-up">Enjoy Your Food at Foody</h1>
                                <!--<p class="mb-5" data-aos="fade-up" data-aos-delay="100">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente et sed quasi.</p>-->
                                <p data-aos="fade-up" data-aos-delay="200"><a href="ViewAllRestaurants.jsp" class="btn btn-white btn-outline-white">Get Started</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="slider-item" style="background-image: url('img/hero_2.jpg');">
                    <div class="container">
                        <div class="row slider-text align-items-center justify-content-center">
                            <div class="col-md-8 text-center col-sm-12 ">
                                <h1 data-aos="fade-up">Delecious Food</h1>
                                <!--<p class="mb-5" data-aos="fade-up" data-aos-delay="100">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente et sed quasi.</p>-->
                                <p data-aos="fade-up" data-aos-delay="200"><a href="ViewAllRestaurants.jsp" class="btn btn-white btn-outline-white">Get Started</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <br><br><br><br><br><br><br>
        
            
                <div id="d1" class="container-fluid text-center text-black table-responsive">
                    
                </div>
         
        <br>
        <div id="d2">
            <!-- Modal -->
            <div class="modal fade modal-dialog modal-dialog-scrollable" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Bill Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body text-black" id="d3">
       jai mata di
       jai mata di
       jai mata di
      </div>
        
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
        </div>
        <br><br><br><br><br><br>
         <%@include file="footer.jsp" %>
    </body>
</html>
