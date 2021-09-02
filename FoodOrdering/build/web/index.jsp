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
             <%@include file="header.jsp"%>

    </head>
    <body>
               <%@include file="menubar.jsp"%>
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
        <section class="section bg-light py-5  bottom-slant-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-left service-block" data-aos="fade-up" data-aos-delay="">
                        <span class="wrap-icon"><span class="flaticon-dinner d-block mb-4"></span></span>
                        <h3 class="mb-2 text-primary">Enjoy Eating</h3>
                        <p>A best place for foodies who want to live every moment enjoy eating..</p>
                        <!--<p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>-->
                    </div>
                    <div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-left service-block" data-aos="fade-up" data-aos-delay="100">
                        <span class="wrap-icon"><span class="flaticon-fish d-block mb-4"></span></span>
                        <h3 class="mb-2 text-primary">Fresh Sea Foods</h3>
                        <p>We have assortment of fresh sea foods which are exotic and just taken out of sea just for you..</p>
                        <!--<p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>-->
                    </div>
                    <div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-left service-block" data-aos="fade-up" data-aos-delay="200">
                        <span class="wrap-icon"><span class="flaticon-hot-coffee-rounded-cup-on-a-plate-from-side-view d-block mb-4"></span></span>
                        <h3 class="mb-2 text-primary">Cup of Coffees</h3>
                        <p>Every kind of coffee drink is availabe here. You name it and we got it..</p>
                    </div>
                    <div class="col-md-6 mb-4 mb-lg-0 col-lg-3 text-left service-block" data-aos="fade-up" data-aos-delay="300">
                        <span class="wrap-icon"><span class="flaticon-meat d-block mb-4"></span></span>
                        <h3 class="mb-2 text-primary">Meat Eaters</h3>
                        <p>Specially curated cuisine for meat eaters which are so native to the place and yet taste like that it has come from heaven..</p>
                    </div>
                </div>
            </div>
        </section>
        <section class="section pb-0">
            <div class="container">
                <div class="row mb-5 justify-content-center" data-aos="fade">
                    <div class="col-md-7 text-center heading-wrap">
                        <h2 data-aos="fade-up">Who we are?</h2>
                        <p data-aos="fade-up" data-aos-delay="100">For over a decade now, we’ve been empowering our users in discovering new tastes and experiences across countries. By putting together meticulous information for our users, we enable them to make an informed choice.</p>
                    </div>
                </div>
                <div class="row align-items-center">
                    <div class="col-lg-4">
                        <img src="img/dishes_1.jpg" alt="Image" class="img-fluid about_img_1" data-aos="fade" data-aos-delay="200">
                    </div>
                    <div class="col-lg-4">
                        <img src="img/about_1.jpg" alt="Image" class="img-fluid about_img_1" data-aos="fade" data-aos-delay="300">
                        <img src="img/about_2.jpg" alt="Image" class="img-fluid about_img_1" data-aos="fade" data-aos-delay="400">
                    </div>
                    <div class="col-lg-4">
                        <img src="img/dishes_3.jpg" alt="Image" class="img-fluid about_img_1" data-aos="fade" data-aos-delay="500">
                    </div>
                </div>
            </div>
        </section>
        <section class="section ">
            <div class="clearfix mb-5 pb-5">
                <div class="container-fluid mb-5">
                    <div class="row" data-aos="fade">
                        <div class="col-md-12 text-center heading-wrap">
                            <h2>Special Menu</h2>
                        </div>
                    </div>
                </div>
                <div class="owl-carousel centernonloop">
                    <a href="#" class="item-dishes" data-aos="fade-right" data-aos-delay="100">
                        <div class="text">
                            <p class="dishes-price">&#8377;110.50</p>
                            <h2 class="dishes-heading">Organic tomato salad, gorgonzola cheese, capers</h2>
                        </div>
                        <img src="img/dishes_1.jpg" alt="" class="img-fluid">
                    </a>
                    <a href="#" class="item-dishes" data-aos="fade-right" data-aos-delay="200">
                        <div class="text">
                            <p class="dishes-price">&#8377;120.00</p>
                            <h2 class="dishes-heading">Baked broccoli</h2>
                        </div>
                        <img src="img/dishes_2.jpg" alt="" class="img-fluid">
                    </a>
                    <a href="#" class="item-dishes" data-aos="fade-right" data-aos-delay="300">
                        <div class="text">
                            <p class="dishes-price">&#8377;110.00</p>
                            <h2 class="dishes-heading">Spicy meatballs</h2>
                        </div>
                        <img src="img/dishes_3.jpg" alt="" class="img-fluid">
                    </a>
                    <a href="#" class="item-dishes" data-aos="fade-right" data-aos-delay="400">
                        <div class="text">
                            <p class="dishes-price">&#8377;120.00</p>
                            <h2 class="dishes-heading">Eggplant parmigiana</h2>
                        </div>
                        <img src="img/dishes_4.jpg" alt="" class="img-fluid">
                    </a>
                </div>
            </div>
        </section> 
        <section class="section bg-light  top-slant-white bottom-slant-gray">
            <div class="clearfix mb-5 pb-5">
                <div class="container-fluid">
                    <div class="row" data-aos="fade">
                        <div class="col-md-12 text-center heading-wrap">
                            <h2>Our Menu</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-md-6">
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image order-2" style="background-image: url('img/dishes_4.jpg');" data-aos="fade"></div>
                            <div class="text order-1">
                                <h3>Grilled Caesar salad, shaved reggiano</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;120.00</p>
                            </div>
                        </div>
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image" style="background-image: url('img/dishes_1.jpg');" data-aos="fade"></div>
                            <div class="text">
                                <h3>Spicy Calamari and beans</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;120.00</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image order-2" style="background-image: url('img/dishes_2.jpg');" data-aos="fade"></div>
                            <div class="text order-1">
                                <h3>Bacon wrapped wild gulf prawns</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;180.00</p>
                            </div>
                        </div>
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image" style="background-image: url('img/dishes_3.jpg');" data-aos="fade"></div>
                            <div class="text">
                                <h3>Seared ahi tuna fillet*, honey-ginger sauce</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;160.00</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-md-6">
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image order-2" style="background-image: url('img/dishes_4.jpg');" data-aos="fade"></div>
                            <div class="text order-1">
                                <h3>Grilled Caesar salad, shaved reggiano</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;120.00</p>
                            </div>
                        </div>
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image" style="background-image: url('img/dishes_1.jpg');" data-aos="fade"></div>
                            <div class="text">
                                <h3>Spicy Calamari and beans</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;120.00</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image order-2" style="background-image: url('img/dishes_2.jpg');" data-aos="fade"></div>
                            <div class="text order-1">
                                <h3>Bacon wrapped wild gulf prawns</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;180.00</p>
                            </div>
                        </div>
                        <div class="sched d-block d-lg-flex">
                            <div class="bg-image" style="background-image: url('img/dishes_3.jpg');" data-aos="fade"></div>
                            <div class="text">
                                <h3>Seared ahi tuna fillet*, honey-ginger sauce</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto illo delectus...</p>
                                <p class="text-primary h3">&#8377;160.00</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section> 
        <section class="section relative-higher">
            <div class="clearfix mb-5 pb-5">
                <div class="container-fluid">
                    <div class="row" data-aos="fade">
                        <div class="col-md-12 text-center heading-wrap">
                            <h2>Testimonial</h2>

                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="owl-carousel centernonloop2">
                            <div class="slide" data-aos="fade-left" data-aos-delay="100">
                                <blockquote class="testimonial">
                                    <p>&ldquo;It has been a FABULOUS experience - so good, that what started out being special treat once or twice has become a regular weekly routine! I look forward to Monday’s and a refrigerator stocked full of a variety of delicious and healthy meals to last throughout the week. &rdquo;</p>
                                    <div class="d-flex author">
                                        <img src="img/person_1.jpg" alt="" class="mr-4">
                                        <div class="author-info">
                                            <h4>Mellisa Howard</h4>
                                            <p>Chef, Foody</p>
                                        </div>
                                    </div>
                                </blockquote>
                            </div>
                            <div class="slide" data-aos="fade-left" data-aos-delay="200">
                                <blockquote class="testimonial">
                                    <p>&ldquo;It has been a FABULOUS experience - so good, that what started out being special treat once or twice has become a regular weekly routine! I look forward to Monday’s and a refrigerator stocked full of a variety of delicious and healthy meals to last throughout the week. &rdquo;</p>
                                    <div class="d-flex author">
                                        <img src="img/person_2.jpg" alt="" class="mr-4">
                                        <div class="author-info">
                                            <h4>Mike Richardson</h4>
                                            <p>Chef, Foody</p>
                                        </div>
                                    </div>
                                </blockquote>
                            </div>
                            <div class="slide" data-aos="fade-left" data-aos-delay="300">
                                <blockquote class="testimonial">
                                    <p>&ldquo;It has been a FABULOUS experience - so good, that what started out being special treat once or twice has become a regular weekly routine! I look forward to Monday’s and a refrigerator stocked full of a variety of delicious and healthy meals to last throughout the week. &rdquo;</p>
                                    <div class="d-flex author">
                                        <img src="img/person_3.jpg" alt="" class="mr-4">
                                        <div class="author-info">
                                            <h4>Charles White</h4>
                                            <p>Chef, Foody</p>
                                        </div>
                                    </div>
                                </blockquote>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section> 
        <section class="section  bg-light top-slant-white">
            <div class="clearfix mb-5 pb-5">
                <div class="container-fluid">
                    <div class="row" data-aos="fade">
                        <div class="col-md-12 text-center heading-wrap">
                            <h2>Blog</h2>
                            <span class="back-text">Our Blog</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6" data-aos="fade-up" data-aos-delay="100">
                        <div class="blog d-block">
                            <a class="bg-image d-block" href="#" style="background-image: url('img/dishes_1.jpg');"></a>
                            <div class="text">
                                <h3><a href="https://blog.thermoworks.com/bread/how-to-cook-pasta-better-2/">Flavoury Receipe</a></h3>
                                <p class="sched-time">
                                    <span><span class="fa fa-calendar"></span> May 31, 2021</span> <br>
                                </p>
                                <p>If there is a food that is more versatile than pasta, I’m not sure what it is. The sheer taxonomy of it alone boggles the mind. Fresh and dried, filled and unfilled, extruded...</p>
                                <p><a href="https://blog.thermoworks.com/bread/how-to-cook-pasta-better-2/" target="_blank" class="btn btn-primary btn-sm">Read More</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6" data-aos="fade-up" data-aos-delay="200">
                        <div class="blog d-block">
                            <a class="bg-image d-block" href="#" style="background-image: url('img/dishes_2.jpg');"></a>
                            <div class="text">
                                <h3><a href="https://pinchofyum.com/" target="_blank">Pinch Of Yum</a></h3>
                                <p class="sched-time">
                                    <span><span class="fa fa-calendar"></span> May 31, 2021</span> <br>
                                </p>
                                <p>Chipotle Orange Shrimp with Cilantro Rice! Tender shrimp in a sweet-meets-smoky cream sauce piled high on cilantro-speckled rice with a side of tangy cucumbers.</p>
                                <p><a href="https://pinchofyum.com/" target="_blank" class="btn btn-primary btn-sm">Read More</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section> 
       <%@include file="footer.jsp"%>
    </body>

    <!-- Mirrored from preview.colorlib.com/theme/foody/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:44 GMT -->
</html>
