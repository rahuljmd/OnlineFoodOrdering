<%-- 
    Document   : paymentdemo
    Created on : May 15, 2021, 1:00:56 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
<!-- Live_Key rzp_live_ILgsfZCZoFIKMb   -->
<!-- TEST_Key rzp_test_96HeaVmgRvbrfT -->
        <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
        <script>
            function save_rec(){
                payment_done();
            }
            
            
             function payment_done() {
                var options = {
                    "key": "rzp_test_96HeaVmgRvbrfT", // Enter the Key ID generated from the Dashboard
                    "amount":10000, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise or INR 500.
                    "currency": "INR",
                    "name": "Food Ordering",
                    "description": "Food Ordering",
                    "image": "img.png",
                    "handler": function (response) {
                   alert(response.razorpay_payment_id);
                       
                    },
                    "prefill": {
                        "name": "test", "email": "test24pro@gmail.com",
                        "contact": "4524587896"
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
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
                                            <a class="btn-hover" href="#" id="cashbtn" onclick="save_rec()">Place Order</a>

    </body>
</html>