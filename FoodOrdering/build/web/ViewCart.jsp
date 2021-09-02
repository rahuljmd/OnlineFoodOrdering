<%-- 
    Document   : ViewCart
    Created on : 11 May, 2021, 10:52:03 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@include file="header.jsp" %>

        <!-- Live_Key rzp_live_ILgsfZCZoFIKMb   -->
        <!-- TEST_Key rzp_test_96HeaVmgRvbrfT -->
        <script src="https://checkout.razorpay.com/v1/checkout.js"></script>

        <%
            String email = "";
            if (request.getSession().getAttribute("customer_email") == null) {
                response.sendRedirect("CustomerLogin.jsp");
            } else {
                email = (String) request.getSession().getAttribute("customer_email");
            }

        %>
        <script>
            var tax;
            var discount;
            var subtotal = 0;
            var subtotal1 = 0;
            var del_charges;
            var total;
            var rest_id;
            var del_charges;
            var min_del;
            var qty;

            function go() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        var mainobj = JSON.parse(res);
                        var arr = mainobj["ans"];
                        var ans = "<table class='table table-bordered'>";
                        ans = ans + "<tr>";
                        ans = ans + "<th>Item photo</th>";
                        ans = ans + "<th>Item name</th>";
                        ans = ans + "<th>Price</th>";
                        ans = ans + "<th>Qty</th>";
                        ans = ans + "<th>Amount</th>";
                        ans = ans + "<th>Remove</th>";
                        ans = ans + "</tr>";


                        for (var i = 0; i < arr.length; i++) {
                            ans = ans + "<tr>";
                            ans = ans + "<td><img src='" + arr[i]["photo"] + "' style=\"width:60px;height:60px;\"/></td>";
                            ans = ans + "<td>" + arr[i]["item_name"] + "</td>";
                            ans = ans + "<td>" + arr[i]["price"] + "</td>";
                            ans = ans + "<td><button onclick=\'go2(" + arr[i]["cart_detail_id"] + ",\"add\")\' class='btn-outline-success btn-sm p-1 pt-0 pb-0'>+</button>&nbsp;&nbsp;&nbsp;&nbsp;" + arr[i]["quantity"] + "&nbsp;&nbsp;&nbsp;&nbsp;<button onclick=\'go2(" + arr[i]["cart_detail_id"] + ",\"del\")\' class=\'btn-outline-danger btn-sm p-1 pt-0 pb-0\'>-</button></td>";
                            rest_id = arr[i]["restaurant_id"];
                            del_charges = arr[i]["delivery_charges"];
                            min_del = arr[i]["min_delivery"];
                            qty = arr[i]["quantity"];
                            console.log(qty + "--vaise hi");
                            ans = ans + "<td>" + arr[i]["amount"] + "</td>";
                            subtotal = parseInt(subtotal) + parseInt(arr[i]["amount"]);
                            ans = ans + "<td><img src='https://cdn.iconscout.com/icon/premium/png-256-thumb/delete-1432400-1211078.png' onclick=\'deleteCartItem(" + arr[i]["cart_detail_id"] + ")\' alt=\"img\" style=\"width:30px;height:30px;\"/></td>";
                            ans = ans + "</tr>";
                        }
                        var ans = ans + "</table>";
                        document.getElementById("d1").innerHTML = ans;
                        total1(subtotal);
                        subtotal = 0;
                        if (arr.length === 0) {
                            document.getElementById("d2").innerHTML = "";
                            document.getElementById("d3").innerHTML = "";
                        }

                        if (total < min_del) {
                            document.getElementById("d3").style.display = "none";
                            alert("Minimum delivery is " + min_del);
                        } else {
                            document.getElementById("d3").style.display = "block";
                        }
                    }
                };
                xhttp.open("GET", "./ViewCart", true);
                xhttp.send();
            }

            function deleteCartItem(cart_detail_id) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);
                        go();
                    }
                };
                xhttp.open("GET", "./DeleteCartItem?id=" + cart_detail_id, true);
                xhttp.send();
            }

            function go2(cart_detail_id, res) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);
                        go();
                    }
                };
                xhttp.open("GET", "./UpdateCartItem?id=" + cart_detail_id + "&res=" + res, true);
                xhttp.send();
            }

            function total1(subtotal) {
                console.log(subtotal + "--subtotal");
                tax = 18;
                discount = 0;
                console.log(qty + "---qty");
                if (qty == 0 || qty === undefined) {
                    del_charges = 0;
                    console.log(del_charges + "---delivery charges");
                }
                total = ((tax / 100) * subtotal) + subtotal;
                subtotal1 = subtotal;
                total = parseInt(total) + parseInt(del_charges);
                console.log(total + "---total");
                var ans = "<br><table class='table table-hover'>";
                ans += "<tr>";
                ans = ans + "<th>Subtotal</th>";
                ans = ans + "<th>Tax</th>";
                ans = ans + "<th>Discount</th>";
                ans = ans + "<th>Delivery Charges</th>";
                ans = ans + "<th>Total</th>";
                ans += "</tr>";
                ans = ans + "<tr>";
                ans = ans + "<td>&#8377;" + subtotal + "</td>";
                ans = ans + "<td>" + tax + "%</td>";
                ans = ans + "<td>&#8377;" + discount + "</td>";
                ans = ans + "<td>&#8377;" + del_charges + "</td>";
                ans = ans + "<td>&#8377;" + total + "</td>";
                ans = ans + "</tr>";
                ans = ans + "</table><br>";
                console.log(ans);
                document.getElementById("d2").innerHTML = ans;

            }


            function paynow() {
                var ans;
                var arr = document.getElementsByName("pay");
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].checked) {
                        ans = arr[i].value;
                    }
                }
                console.log(ans);
                pay(ans);


            }


            function pay(res) {
                if (res === "cod") {
                    console.log("ghar pe aayeaga");
                    save_to_db(res);

                } else if (res === "card") {
                    console.log("online payment");
                    save_rec();
                }
            }

            function save_rec() {
                payment_done();
            }


            function payment_done() {
                var options = {
                    "key": "rzp_test_96HeaVmgRvbrfT", // Enter the Key ID generated from the Dashboard
                    "amount": total * 100, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise or INR 500.
                    "currency": "INR",
                    "name": "Food Ordering",
                    "description": "Food Ordering",
                    "image": "https://images2.minutemediacdn.com/image/upload/c_crop,h_1126,w_2000,x_0,y_181/f_auto,q_auto,w_1100/v1554932288/shape/mentalfloss/12531-istock-637790866.jpg",
                    "handler": function (response) {
                        alert(response.razorpay_payment_id);
                        save_to_db("Online");
                    },
                    "prefill": {
                        "name": "test", "email": "test24pro@gmail.com",
                        "contact": "7589652325"
                    },
                    "notes": {
                        "address": ""
                    },
                    "theme": {
                        "color": "#F37254"
                    }
                };
                var rzp1 = new Razorpay(options);
                document.getElementById('cashbtn').onclick = function (e) {
                    rzp1.open();
                    e.preventDefault();
                }
            }


            function save_to_db(res) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);
                        if (res === "success") {
                            document.getElementById("d2").innerHTML = "";
                            document.getElementById("d3").innerHTML = "<strong style=\"color:black;\">Payment Successful!!<strong>";
//                            mailSending();
                           alert("Mail sent successfully!!");
                        }

                    }
                };
                xhttp.open("GET", "./SaveBill?option=" + res + "&subtotal=" + subtotal1 + "&total=" + total + "&tax=" + tax + "&discount=" + discount + "&rest_id=" + rest_id + "&del_charges=" + del_charges, true);
                xhttp.send();
            }
            
//            function mailSending(){
//                  var xhttp = new XMLHttpRequest();
//                xhttp.onreadystatechange = function () {
//                    if (this.readyState == 4 && this.status == 200) {
//                        var res = this.responseText.trim();
//                        console.log(res);
//                        alert(res);
//                        
//
//                    }
//                };
//                xhttp.open("GET", "./EmailTesting1", true);
//                xhttp.send();
//            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
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

        <div class="container">
            <section class="section">
                <div id="d1" class="container">

                </div>

                <div id="d2" class="text-black container">

                </div>

                <div id="d3" class="container mt-2">
                    <h3 class="text-center">Payment</h3>

                    <div class="row">
                        <div class="form-check col-sm-6">
                            <input type="radio" checked class="" id="r1" name="pay" value="cod">   
                            <label class="form-check-label">COD</label>
                        </div>
                    </div><div class="row">
                        <div class="form-check col-sm-6">
                            <input type="radio" class="" id="r2" name="pay" value="card">   
                            <label class="form-check-label">CARD/ONLINE PAYMENT</label>
                        </div>
                    </div><br>
                    <input type="button" value="Pay Now" id="cashbtn" class="btn-primary btn btn-outline-primary" onclick="paynow()"/>

                </div>
            </section>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>
