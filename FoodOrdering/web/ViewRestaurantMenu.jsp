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
                %>

                <%
                    try {
                        ResultSet rs = Dbloader.executeSql("select * from food_ordering.restaurant where restaurant_id='" + rid + "'");
                       %>
                       
                       <%
                        int k=1;
                        while (rs.next()) {
                            String photo_wide = rs.getString("photo_wide");
                            String name = rs.getString("restaurant_name");
                %>
                <div class="text-center"  ><img src="<%=photo_wide%>" alt="image" style="width: 400px;height: 150px;"/></div><br>
                <h2 class="text-center"><%=name%></h2>
                <div class="row mb-3"><div class="col-sm-9"> <h4>Cuisines</h4></div><div class="col-sm-3"><a href="ViewAllMenu.jsp?rid=<%=rid%>" class="btn btn-outline-primary">View complete menu</a></div></div>
                   <div class="row">    

                <%
                    }
                    ResultSet rs1 = Dbloader.executeSql("select * from food_ordering.restaurant_cuisines where restaurant_id='" + rid + "'");

                    while (rs1.next()) {
                        int cuisine_id = rs1.getInt("cuisine_id");
                        System.out.println("cid" + cuisine_id);
                        ResultSet rs2 = Dbloader.executeSql("select * from food_ordering.cuisines where cuisine_id='" + cuisine_id + "'");
                        if (rs2.next()) {
                            String cname = rs2.getString("cuisine_name");
                            String cphoto = rs2.getString("photo");
                %>
               
                    <div class="col-sm-4 mb-3">
                        <div> <img src="<%=cphoto%>" alt="image" style="width:150px;height: 150px;"/></div>
                        <label><h5><%=cname%></h5></label><br>
                    <a href="ViewCategories.jsp?cid=<%=cuisine_id%>&rid=<%=rid%>" class="btn btn-outline-success">View</a>
                    </div>
                
               
                <%
                    if(k%3==0){
                        %>
                        </div>
                        <hr>
                         <div class="row">       
                              <% }
                                k++;
                            }
                        }
%>
                         </div>
<%
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                         </div>
        </section>
                <%@include file="footer.jsp" %>
                </body>

                <!-- Mirrored from preview.colorlib.com/theme/foody/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:44 GMT -->
                </html>
