<%-- 
    Document   : index
    Created on : 7 May, 2021, 10:59:08 AM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from preview.colorlib.com/theme/foody/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:42 GMT -->
    <head>
         <%
            String email="";
            if(session.getAttribute("customer_email")==null){
                response.sendRedirect("CustomerLogin.jsp");
            }
            else{
                 email=session.getAttribute("customer_email").toString();
            }
            %>
        <%@include file="header.jsp" %>
        <script>
          function go() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText;
                        var mainobj= JSON.parse(res.trim());
                        var arr=mainobj["ans"];
                        console.log(arr);
                        var ans = "";
                        var k=1;
                        for (var i = 0; i<arr.length; i++) {
                            ans=ans+"<div class=row><div class=\"col-sm-4\">";
                       ans=ans+"<img src=\""+arr[i]["photo_square"]+"\" style='width:200px;height:200px;'/></div><div class=\"col-sm-8\"/><h2>"+arr[i]["restaurant_name"]
                               +"</h2>Address:"+arr[i]["address"]+"<br>Minimum Delivery:"+arr[i]["min_delivery"]+"<br>Description:"+
                               arr[i]["description"]+"<br><br>"+"<a href=\"ViewRestaurantMenu.jsp?rid="+arr[i]["restaurant_id"]+"\" class=\"btn btn-outline-primary\">Order Now</a>"+"</div>"; 
                
                       ans=ans+"</div><br><br>"      
               
            }
                        document.getElementById("d1").innerHTML = ans;

                    }
                };
                var url = "./FetchRestaurants";
                xhttp.open("GET", url, true);
                xhttp.send();
            }
            
            function fetchCityRestaurants(){
                 var xhttp = new XMLHttpRequest();
                 var selection=document.getElementById("s1").value;
                 console.log(selection);
                 if(selection=="All cities"){
                     go();
                 }
                 else{
                     
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText;
                        var mainobj= JSON.parse(res.trim());
                        var arr=mainobj["ans"];
                        console.log(arr);
                        var ans = "";
                        var k=1;
                        for (var i = 0; i<arr.length; i++) {
                            ans=ans+"<div class=row><div class=\"col-sm-4\">";
                       ans=ans+"<img src=\""+arr[i]["photo_square"]+"\"/></div><div class=\"col-sm-8\"/><h2>"+arr[i]["restaurant_name"]
                               +"</h2>Address:"+arr[i]["address"]+"<br>Minimum Delivery:"+arr[i]["min_delivery"]+"<br>Description:"+
                               arr[i]["description"]+"<br><br>"+"<a href=\"ViewRestaurantMenu.jsp?rid="+arr[i]["restaurant_id"]+"\" class=\"btn btn-outline-primary\">Order Now</a>"+"</div>"; 
                
                       ans=ans+"</div><br><br>"      
               
            }
                        document.getElementById("d1").innerHTML = ans;

                    }
                };
                var url = "./FetchCityRestaurants?selection="+selection;
                xhttp.open("GET", url, true);
                xhttp.send();
            }
        }
        </script>
    </head>
    <body onload="go()">
        <%@include file="menubar.jsp" %>

        <div class="slider-wrap">
            <section class="home-slider owl-carousel">
                <div class="slider-item" style="background-image: url('img/hero_1.jpg');">
                    <div class="container">
                        <div class="row slider-text align-items-center justify-content-center">
                            <div class="col-md-8 text-center col-sm-12 ">
                                <h1 data-aos="fade-up">Enjoy Your Food at Foody</h1>
                                <!--<p class="mb-5" data-aos="fade-up" data-aos-delay="100">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente et sed quasi.</p>-->
                                <p data-aos="fade-up" data-aos-delay="200"><a href="#" class="btn btn-white btn-outline-white">Get Started</a></p>
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
                                <p data-aos="fade-up" data-aos-delay="200"><a href="#" class="btn btn-white btn-outline-white">Get Started</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <section class="section">
            <div class="container">
                
                <select class="custom-select" id="s1"
                        style="width:150px;" onchange="fetchCityRestaurants()">
                    <option>All cities</option>
                    <option>Amritsar</option>
                    <option>Jalandhar</option>
                    <option>Ludhiana</option>
                    <option>Banglore</option>
                </select><br><br>
            </div>
            <div class="container" id="d1">
                <div class="row" id="r1">
                    <div class="col-sm-4" id="c1">
                        <img src="" alt="img"/>
                    </div>
                    <div class="col-sm-8" id="c2">
                        <label>Name</label><br>       
                        <label>Address</label> <br>      
                        <label>Description</label> <br>      
                        <label>Min_Order</label><br>
                    </div>
                </div><br><br>
              
            </div>

        </section>
        <%@include file="footer.jsp" %>
    </body>

    <!-- Mirrored from preview.colorlib.com/theme/foody/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:44 GMT -->
</html>
