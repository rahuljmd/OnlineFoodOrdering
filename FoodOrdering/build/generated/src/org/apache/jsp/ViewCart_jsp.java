package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ViewCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/menubar.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        ");
      out.write(" <title>Foody &mdash; Website By Rahul Bhatia</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/aos.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/ionicons/css/ionicons.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/fontawesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/flaticon/font/flaticon.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Live_Key rzp_live_ILgsfZCZoFIKMb   -->\n");
      out.write("        <!-- TEST_Key rzp_test_96HeaVmgRvbrfT -->\n");
      out.write("        <script src=\"https://checkout.razorpay.com/v1/checkout.js\"></script>\n");
      out.write("\n");
      out.write("        ");

            String email = "";
            if (request.getSession().getAttribute("customer_email") == null) {
                response.sendRedirect("CustomerLogin.jsp");
            } else {
                email = (String) request.getSession().getAttribute("customer_email");
            }

        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var tax;\n");
      out.write("            var discount;\n");
      out.write("            var subtotal = 0;\n");
      out.write("            var subtotal1 = 0;\n");
      out.write("            var del_charges;\n");
      out.write("            var total;\n");
      out.write("            var rest_id;\n");
      out.write("            var del_charges;\n");
      out.write("            var min_del;\n");
      out.write("            var qty;\n");
      out.write("\n");
      out.write("            function go() {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        var mainobj = JSON.parse(res);\n");
      out.write("                        var arr = mainobj[\"ans\"];\n");
      out.write("                        var ans = \"<table class='table table-bordered'>\";\n");
      out.write("                        ans = ans + \"<tr>\";\n");
      out.write("                        ans = ans + \"<th>Item photo</th>\";\n");
      out.write("                        ans = ans + \"<th>Item name</th>\";\n");
      out.write("                        ans = ans + \"<th>Price</th>\";\n");
      out.write("                        ans = ans + \"<th>Qty</th>\";\n");
      out.write("                        ans = ans + \"<th>Amount</th>\";\n");
      out.write("                        ans = ans + \"<th>Remove</th>\";\n");
      out.write("                        ans = ans + \"</tr>\";\n");
      out.write("\n");
      out.write("\n");
      out.write("                        for (var i = 0; i < arr.length; i++) {\n");
      out.write("                            ans = ans + \"<tr>\";\n");
      out.write("                            ans = ans + \"<td><img src='\" + arr[i][\"photo\"] + \"' style=\\\"width:60px;height:60px;\\\"/></td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"item_name\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"price\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td><button onclick=\\'go2(\" + arr[i][\"cart_detail_id\"] + \",\\\"add\\\")\\' class='btn-outline-success btn-sm p-1 pt-0 pb-0'>+</button>&nbsp;&nbsp;&nbsp;&nbsp;\" + arr[i][\"quantity\"] + \"&nbsp;&nbsp;&nbsp;&nbsp;<button onclick=\\'go2(\" + arr[i][\"cart_detail_id\"] + \",\\\"del\\\")\\' class=\\'btn-outline-danger btn-sm p-1 pt-0 pb-0\\'>-</button></td>\";\n");
      out.write("                            rest_id = arr[i][\"restaurant_id\"];\n");
      out.write("                            del_charges = arr[i][\"delivery_charges\"];\n");
      out.write("                            min_del = arr[i][\"min_delivery\"];\n");
      out.write("                            qty = arr[i][\"quantity\"];\n");
      out.write("                            console.log(qty + \"--vaise hi\");\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"amount\"] + \"</td>\";\n");
      out.write("                            subtotal = parseInt(subtotal) + parseInt(arr[i][\"amount\"]);\n");
      out.write("                            ans = ans + \"<td><img src='https://cdn.iconscout.com/icon/premium/png-256-thumb/delete-1432400-1211078.png' onclick=\\'deleteCartItem(\" + arr[i][\"cart_detail_id\"] + \")\\' alt=\\\"img\\\" style=\\\"width:30px;height:30px;\\\"/></td>\";\n");
      out.write("                            ans = ans + \"</tr>\";\n");
      out.write("                        }\n");
      out.write("                        var ans = ans + \"</table>\";\n");
      out.write("                        document.getElementById(\"d1\").innerHTML = ans;\n");
      out.write("                        total1(subtotal);\n");
      out.write("                        subtotal = 0;\n");
      out.write("                        if (arr.length === 0) {\n");
      out.write("                            document.getElementById(\"d2\").innerHTML = \"\";\n");
      out.write("                            document.getElementById(\"d3\").innerHTML = \"\";\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                        if (total < min_del) {\n");
      out.write("                            document.getElementById(\"d3\").style.display = \"none\";\n");
      out.write("                            alert(\"Minimum delivery is \" + min_del);\n");
      out.write("                        } else {\n");
      out.write("                            document.getElementById(\"d3\").style.display = \"block\";\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./ViewCart\", true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function deleteCartItem(cart_detail_id) {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        alert(res);\n");
      out.write("                        go();\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./DeleteCartItem?id=\" + cart_detail_id, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function go2(cart_detail_id, res) {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        alert(res);\n");
      out.write("                        go();\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./UpdateCartItem?id=\" + cart_detail_id + \"&res=\" + res, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function total1(subtotal) {\n");
      out.write("                console.log(subtotal + \"--subtotal\");\n");
      out.write("                tax = 18;\n");
      out.write("                discount = 0;\n");
      out.write("                console.log(qty + \"---qty\");\n");
      out.write("                if (qty == 0 || qty === undefined) {\n");
      out.write("                    del_charges = 0;\n");
      out.write("                    console.log(del_charges + \"---delivery charges\");\n");
      out.write("                }\n");
      out.write("                total = ((tax / 100) * subtotal) + subtotal;\n");
      out.write("                subtotal1 = subtotal;\n");
      out.write("                total = parseInt(total) + parseInt(del_charges);\n");
      out.write("                console.log(total + \"---total\");\n");
      out.write("                var ans = \"<br><table class='table table-hover'>\";\n");
      out.write("                ans += \"<tr>\";\n");
      out.write("                ans = ans + \"<th>Subtotal</th>\";\n");
      out.write("                ans = ans + \"<th>Tax</th>\";\n");
      out.write("                ans = ans + \"<th>Discount</th>\";\n");
      out.write("                ans = ans + \"<th>Delivery Charges</th>\";\n");
      out.write("                ans = ans + \"<th>Total</th>\";\n");
      out.write("                ans += \"</tr>\";\n");
      out.write("                ans = ans + \"<tr>\";\n");
      out.write("                ans = ans + \"<td>&#8377;\" + subtotal + \"</td>\";\n");
      out.write("                ans = ans + \"<td>\" + tax + \"%</td>\";\n");
      out.write("                ans = ans + \"<td>&#8377;\" + discount + \"</td>\";\n");
      out.write("                ans = ans + \"<td>&#8377;\" + del_charges + \"</td>\";\n");
      out.write("                ans = ans + \"<td>&#8377;\" + total + \"</td>\";\n");
      out.write("                ans = ans + \"</tr>\";\n");
      out.write("                ans = ans + \"</table><br>\";\n");
      out.write("                console.log(ans);\n");
      out.write("                document.getElementById(\"d2\").innerHTML = ans;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function paynow() {\n");
      out.write("                var ans;\n");
      out.write("                var arr = document.getElementsByName(\"pay\");\n");
      out.write("                for (var i = 0; i < arr.length; i++) {\n");
      out.write("                    if (arr[i].checked) {\n");
      out.write("                        ans = arr[i].value;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                console.log(ans);\n");
      out.write("                pay(ans);\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function pay(res) {\n");
      out.write("                if (res === \"cod\") {\n");
      out.write("                    console.log(\"ghar pe aayeaga\");\n");
      out.write("                    save_to_db(res);\n");
      out.write("\n");
      out.write("                } else if (res === \"card\") {\n");
      out.write("                    console.log(\"online payment\");\n");
      out.write("                    save_rec();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function save_rec() {\n");
      out.write("                payment_done();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function payment_done() {\n");
      out.write("                var options = {\n");
      out.write("                    \"key\": \"rzp_test_96HeaVmgRvbrfT\", // Enter the Key ID generated from the Dashboard\n");
      out.write("                    \"amount\": total * 100, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise or INR 500.\n");
      out.write("                    \"currency\": \"INR\",\n");
      out.write("                    \"name\": \"Food Ordering\",\n");
      out.write("                    \"description\": \"Food Ordering\",\n");
      out.write("                    \"image\": \"https://images2.minutemediacdn.com/image/upload/c_crop,h_1126,w_2000,x_0,y_181/f_auto,q_auto,w_1100/v1554932288/shape/mentalfloss/12531-istock-637790866.jpg\",\n");
      out.write("                    \"handler\": function (response) {\n");
      out.write("                        alert(response.razorpay_payment_id);\n");
      out.write("                        save_to_db(\"Online\");\n");
      out.write("                    },\n");
      out.write("                    \"prefill\": {\n");
      out.write("                        \"name\": \"test\", \"email\": \"test24pro@gmail.com\",\n");
      out.write("                        \"contact\": \"7589652325\"\n");
      out.write("                    },\n");
      out.write("                    \"notes\": {\n");
      out.write("                        \"address\": \"\"\n");
      out.write("                    },\n");
      out.write("                    \"theme\": {\n");
      out.write("                        \"color\": \"#F37254\"\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var rzp1 = new Razorpay(options);\n");
      out.write("                document.getElementById('cashbtn').onclick = function (e) {\n");
      out.write("                    rzp1.open();\n");
      out.write("                    e.preventDefault();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function save_to_db(res) {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        alert(res);\n");
      out.write("                        if (res === \"success\") {\n");
      out.write("                            document.getElementById(\"d2\").innerHTML = \"\";\n");
      out.write("                            document.getElementById(\"d3\").innerHTML = \"<strong style=\\\"color:black;\\\">Payment Successful!!<strong>\";\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./SaveBill?option=\" + res + \"&subtotal=\" + subtotal1 + \"&total=\" + total + \"&tax=\" + tax + \"&discount=\" + discount + \"&rest_id=\" + rest_id + \"&del_charges=\" + del_charges, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Your Cart</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"go()\">\n");
      out.write("        ");
      out.write("<header role=\"banner\">\n");
      out.write("            <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\">Foody</a>\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExample05\" aria-controls=\"navbarsExample05\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbarsExample05\">\n");
      out.write("                        <ul class=\"navbar-nav ml-auto pl-lg-5 pl-0\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link active\" href=\"index.jsp\">Home</a>\n");
      out.write("                            </li>\n");
      out.write("                          \n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link \" href=\"ViewAllRestaurants.jsp\">Place Order</a>\n");
      out.write("                            </li>\n");
      out.write("                            \n");
      out.write("                             <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"ViewCart.jsp\">View Cart</a>\n");
      out.write("                            </li>\n");
      out.write("                             <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"ViewCurrentOrder.jsp\">View Orders</a>\n");
      out.write("                            </li>\n");
      out.write("                            \n");
      out.write("                            <li class=\"nav-item dropdown\">\n");
      out.write("                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown04\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Services</a>\n");
      out.write("                                <div class=\"dropdown-menu\" aria-labelledby=\"dropdown04\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Recipes</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">News</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">About</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"CustomerChangePassword.jsp\">Change Password</a>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                           \n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"CustomerLogout.jsp\">Logout</a>\n");
      out.write("                            </li>\n");
      out.write("                            \n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                            <li class=\"nav-item cta-btn\">\n");
      out.write("                                <a class=\"nav-link\" href=\"#\">Contact Us</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>");
      out.write("\n");
      out.write("        <div class=\"slider-wrap\">\n");
      out.write("            <section class=\"home-slider owl-carousel\">\n");
      out.write("                <div class=\"slider-item\" style=\"background-image: url('img/hero_1.jpg');\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row slider-text align-items-center justify-content-center\">\n");
      out.write("                            <div class=\"col-md-8 text-center col-sm-12 \">\n");
      out.write("                                <h1 data-aos=\"fade-up\">Enjoy Your Food at Foody</h1>\n");
      out.write("                                <p class=\"mb-5\" data-aos=\"fade-up\" data-aos-delay=\"100\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente et sed quasi.</p>\n");
      out.write("                                <p data-aos=\"fade-up\" data-aos-delay=\"200\"><a href=\"ViewAllRestaurants.jsp\" class=\"btn btn-white btn-outline-white\">Get Started</a></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"slider-item\" style=\"background-image: url('img/hero_2.jpg');\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row slider-text align-items-center justify-content-center\">\n");
      out.write("                            <div class=\"col-md-8 text-center col-sm-12 \">\n");
      out.write("                                <h1 data-aos=\"fade-up\">Delecious Food</h1>\n");
      out.write("                                <p class=\"mb-5\" data-aos=\"fade-up\" data-aos-delay=\"100\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente et sed quasi.</p>\n");
      out.write("                                <p data-aos=\"fade-up\" data-aos-delay=\"200\"><a href=\"ViewAllRestaurants.jsp\" class=\"btn btn-white btn-outline-white\">Get Started</a></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <section class=\"section\">\n");
      out.write("                <div id=\"d1\" class=\"container\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"d2\" class=\"text-black container\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"d3\" class=\"container mt-2\">\n");
      out.write("                    <h3 class=\"text-center\">Payment</h3>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"form-check col-sm-6\">\n");
      out.write("                            <input type=\"radio\" checked class=\"\" id=\"r1\" name=\"pay\" value=\"cod\">   \n");
      out.write("                            <label class=\"form-check-label\">COD</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div><div class=\"row\">\n");
      out.write("                        <div class=\"form-check col-sm-6\">\n");
      out.write("                            <input type=\"radio\" class=\"\" id=\"r2\" name=\"pay\" value=\"card\">   \n");
      out.write("                            <label class=\"form-check-label\">CARD/ONLINE PAYMENT</label>\n");
      out.write("                        </div>\n");
      out.write("                    </div><br>\n");
      out.write("                    <input type=\"button\" value=\"Pay Now\" id=\"cashbtn\" class=\"btn-primary btn btn-outline-primary\" onclick=\"paynow()\"/>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      out.write("  <footer class=\"site-footer\" role=\"contentinfo\">\n");
      out.write("            <div class=\"container mb-5\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-lg-6 text-center\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12 mb-3\">\n");
      out.write("                                <h3>Subsribe Newsletter</h3>\n");
      out.write("                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore ex temporibus magni ipsam inventore dolorum sunt, amet vel.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <form action=\"#\" class=\"col-12 mb-5\">\n");
      out.write("                                <div class=\"row align-items-center\">\n");
      out.write("                                    <div class=\"col-md-8 mb-3 mb-md-0\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Enter Email Address\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-4\">\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Subscribe\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row mb-5\">\n");
      out.write("                    <div class=\"col-md-4 mb-5\">\n");
      out.write("                        <h3>About Us</h3>\n");
      out.write("                        <p class=\"mb-5\">Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus et dolor blanditiis consequuntur ex voluptates perspiciatis omnis unde minima expedita.</p>\n");
      out.write("                        <ul class=\"list-unstyled footer-link d-flex footer-social\">\n");
      out.write("                            <li><a href=\"#\" class=\"p-2\"><span class=\"fa fa-twitter\"></span></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"p-2\"><span class=\"fa fa-facebook\"></span></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"p-2\"><span class=\"fa fa-linkedin\"></span></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"p-2\"><span class=\"fa fa-instagram\"></span></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-5 mb-5\">\n");
      out.write("                        <div class=\"mb-5\">\n");
      out.write("                            <h3>Opening Hours</h3>\n");
      out.write("                            <p><strong class=\"d-block font-weight-normal text-black\">Sunday-Thursday</strong> 5AM - 10PM</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <h3>Contact Info</h3>\n");
      out.write("                            <ul class=\"list-unstyled footer-link\">\n");
      out.write("                                <li class=\"d-block\">\n");
      out.write("                                    <span class=\"d-block text-black\">Address:</span>\n");
      out.write("                                    <span>34 Street Name, City Name Here, United States</span></li>\n");
      out.write("                                <li class=\"d-block\"><span class=\"d-block text-black\">Phone:</span><span>+1 242 4942 290</span></li>\n");
      out.write("                                <li class=\"d-block\"><span class=\"d-block text-black\">Email:</span><span><a href=\"https://preview.colorlib.com/cdn-cgi/l/email-protection\" class=\"__cf_email__\" data-cfemail=\"98f1f6fef7d8e1f7edeafcf7f5f9f1f6b6fbf7f5\">[email&#160;protected]</a></span></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-3 mb-5\">\n");
      out.write("                        <h3>Quick Links</h3>\n");
      out.write("                        <ul class=\"list-unstyled footer-link\">\n");
      out.write("                            <li><a href=\"#\">About</a></li>\n");
      out.write("                            <li><a href=\"#\">Terms of Use</a></li>\n");
      out.write("                            <li><a href=\"#\">Disclaimers</a></li>\n");
      out.write("                            <li><a href=\"#\">Contact</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-12 text-md-center text-left\">\n");
      out.write("                        <p>\n");
      out.write("\n");
      out.write("                            Copyright &copy;<script data-cfasync=\"false\" src=\"../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js\"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This website is made with <i class=\"fa fa-heart text-danger\" aria-hidden=\"true\"></i> by <a href=\"#\" >Rahul (2017ECA1064)</a>\n");
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"loader\" class=\"show fullscreen\"><svg class=\"circular\" width=\"48px\" height=\"48px\"><circle class=\"path-bg\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\" stroke-width=\"4\" stroke=\"#eeeeee\" /><circle class=\"path\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\" stroke-width=\"4\" stroke-miterlimit=\"10\" stroke=\"#cf1d16\" /></svg></div>\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.waypoints.min.js\"></script>\n");
      out.write("        <script src=\"js/aos.js\"></script>\n");
      out.write("        <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("        <script src=\"js/magnific-popup-options.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-23581568-13\"></script>\n");
      out.write("        <script>\n");
      out.write("                                window.dataLayer = window.dataLayer || [];\n");
      out.write("                                function gtag() {\n");
      out.write("                                    dataLayer.push(arguments);\n");
      out.write("                                }\n");
      out.write("                                gtag('js', new Date());\n");
      out.write("\n");
      out.write("                                gtag('config', 'UA-23581568-13');\n");
      out.write("        </script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
