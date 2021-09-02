<%-- 
    Document   : index
    Created on : 7 May, 2021, 10:59:08 AM
    Author     : RAHUL
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="vmm.Dbloader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from preview.colorlib.com/theme/foody/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:42 GMT -->
    <head>
        <%@include file="header.jsp" %>
        <script>
            function addToCart(food_id,rid){
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res=this.responseText.trim();
                        console.log(res);
                        alert(res);
                        if(res=="notlogin"){
                            window.location.href="CustomerLogin.jsp";
                        }
                        
                    }
                };
                xhttp.open("GET", "./UpdateCart1?food_id=" +food_id+"&rid="+rid, true);
                xhttp.send();
            }
        </script>
    </head>
    <body>
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

        <section class="section">
            <div class="container mb-5">
               <%
                    int rid = Integer.parseInt(request.getParameter("rid"));
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    try{
                        ResultSet rs=Dbloader.executeSql("select * from food_ordering.rest_food_category "
                                + "where restaurant_id='"+rid+"' and cuisine_id='"+cid+"'");
                        while(rs.next()){
                            int rcatid=rs.getInt("rest_cat_id");
                            String catname=rs.getString("category_name");
                            String photo_wide=rs.getString("photo_wide");
                            %>
                            <h1 class="text-center"><%=catname%></h1>
                            <div class="text-center">
                            <img src="<%=photo_wide%>" alt="image" style="height:130px; width:500px  ;"/>
                            </div>
                            <hr>
                          
                            
                            <%
                                ResultSet rs1=Dbloader.executeSql("select * from food_ordering.food_items where rest_cat_id='"+rcatid+"'");
                                while(rs1.next()){
                                    String item_name=rs1.getString("item_name");
                                    int price=rs1.getInt("price");
                                    int offer_price=rs1.getInt("offer_price");
                                    int food_id=rs1.getInt("food_id");
                                    %>
                                    <div class="row">
                                        <div class="col-sm-8">
                                        <label style="color:blue"><%=item_name%></label><br>
                                        <label style="color:black;"><s><%=price%></s></label>&nbsp;
                                        <label style="color:green;"><%=offer_price%></label>
                                        </div>
                                        <div class="col-sm-4 text-center">
                 <img src="https://www.searchpng.com/wp-content/uploads/2019/02/Shopping-Cart-PNG-Icon-1024x1024.png" Style="width:70px;height: 70px"  alt="img" onclick="addToCart(<%=food_id%>,<%=rid%>)"/>
                                        </div>
                                    </div>
                                    <hr>
                                    <%
                                }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                %>
                         </div>
        </section>
                <%@include file="footer.jsp" %>
                </body>

                <!-- Mirrored from preview.colorlib.com/theme/foody/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:44 GMT -->
                </html>
