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
            <div class="container">
                <div class="row">
                    <div class="col-6">
                        <h1>Hello1</h1>
                    </div>
                    <div class="col-6">
                        <h1>Hello2</h1>
                    </div>
                </div>
            </div>

        </section>
        <%@include file="footer.jsp" %>
    </body>

    <!-- Mirrored from preview.colorlib.com/theme/foody/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:44 GMT -->
</html>
