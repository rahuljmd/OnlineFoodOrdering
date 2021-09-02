
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from preview.colorlib.com/theme/foody/contact.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:44 GMT -->
<head>
<title>Foody &mdash; Website Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/style.css">
<script>
    function go() {
        var email=document.getElementById("email").value;
        var name=document.getElementById("name").value;
        var phone=document.getElementById("phone").value;
        var message=document.getElementById("message").value;
        if(email!=""&&name!=""&&phone!=""&&message!=""){
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        alert(res);

                    }
                };
                var url = "./contact?email="+email+"&phone="+phone+"&name="+name+"&message="+message;
                xhttp.open("GET", url, true);
                xhttp.send();
            }else{
              alert("All fields are required!!");  
            }
            
            }
</script>
</head>
<body>
    <%@include file="menubar.jsp" %>

<div class="slider-wrap no-slanted">
<div class="slider-item" style="background-image: url('img/hero_1.jpg');">
<div class="container">
<div class="row slider-text align-items-center justify-content-center">
<div class="col-md-8 text-center col-sm-12 ">
<h1 data-aos="fade-up">Contact Foody</h1>
<p class="mb-5" data-aos="fade-up" data-aos-delay="100">Handcrafted with love by <u>Rahul Bhatia</u></p>
<p data-aos="fade-up" data-aos-delay="200"><a href="ViewAllRestaurants.jsp" class="btn btn-white btn-outline-white">Get Started</a></p>
</div>
</div>
</div>
</div>

</div>
<section class="section  pt-5 top-slant-white2 relative-higher bottom-slant-gray">
<div class="container">
<div class="row">
<div class="col-lg-6">
<form action="#" method="post">
<div class="row">
<div class="col-md-6 form-group">
<label for="name">Name</label>
<input type="text" id="name" class="form-control ">
</div>
<div class="col-md-6 form-group">
<label for="phone">Phone</label>
<input type="text" id="phone" class="form-control ">
</div>
</div>
<div class="row">
<div class="col-md-12 form-group">
</div>
</div>
<div class="row">
<div class="col-md-12 form-group">
<label for="email">Email</label>
<input type="email" id="email" class="form-control ">
</div>
</div>
<div class="row">
<div class="col-md-12 form-group">
<label for="message">Write Message</label>
<textarea name="message" id="message" class="form-control " cols="30" rows="8"></textarea>
</div>
</div>
<div class="row">
<div class="col-md-6 form-group">
    <input type="button" value="Send Message" onclick="go()" class="btn btn-primary">
</div>
</div>
</form>
</div>
<div class="col-lg-6 pl-2 pl-lg-5">
<div class="col-md-8 mx-auto contact-form-contact-info">
<h4 class="mb-5">Contact Details</h4>
<p class="d-flex">
<span class="ion-ios-location icon mr-5"></span>
<span>76 Suraj Avenue, Amritsar , India</span>
</p>
<p class="d-flex">
<span class="ion-ios-telephone icon mr-5"></span>
<span>+91 7508117532</span>
</p>
<p class="d-flex">
<span class="ion-android-mail icon mr-5"></span>
<span>rahulbhatia76b@gmail.com</span>
</p>
</div>
</div>
</div>
</div>
</section>
 
    <%@include file="footer.jsp" %>
</body>

<!-- Mirrored from preview.colorlib.com/theme/foody/contact.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 05 May 2021 07:04:44 GMT -->
</html>