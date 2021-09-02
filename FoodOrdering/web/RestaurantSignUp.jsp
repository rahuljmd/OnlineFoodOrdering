<%-- 
    Document   : RestaurantSignUp
    Created on : 20 May, 2021, 6:14:44 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="RestaurantHeader1.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant SignUp Page</title>
        <script>
              function go(){
                var name=document.getElementById("name").value;
                var email=document.getElementById("email").value;
                var city=document.getElementById("city").value;
                var pass=document.getElementById("pass").value;
                var confirm_pass=document.getElementById("confirm_pass").value;
                var mobile=document.getElementById("mobile").value;
                var address=document.getElementById("address").value;
                var location=document.getElementById("location").value;
                var photo_wide=document.getElementById("photo_wide").files[0];
                var photo_square=document.getElementById("photo_square").files[0];
                var min_del=document.getElementById("min_del").value;
                var del_charges=document.getElementById("del_charges").value;
                var start_time=document.getElementById("start_time").value;
                var end_time=document.getElementById("end_time").value;
                var comments=document.getElementById("comments").value;
                var desc=document.getElementById("desc").value;

            if(name==""||desc==""||email==""||photo_wide==undefined||photo_square==undefined||city==""||pass==""||confirm_pass==""||mobile==""||address==""||min_del==""||del_charges==""||start_time==""||end_time==""){
                    alert("All fields are required!!");
                }
                else{
                    if(confirm_pass!=pass){
                        alert("passwords don't match!!!");
                    }
                    else if(city=="Select City"){
                        alert("Please select city first!!!");
                    }
                    else{
                           var xhttp=new XMLHttpRequest();
                xhttp.onreadystatechange=function(){
                  if(this.readyState==4&&this.status==200){
                      var res=this.responseText.trim();
                      alert(res);

//                      document.getElementById("d2").innerHTML=res;
                  }  
                };
                xhttp.open("POST","./RestaurantSignUp",true);
                
                //Extra code for multipart request...
               var formdata=new FormData();
               
               //Attaching text data
               formdata.append("name",name);
               formdata.append("email",email);
               formdata.append("city",city);
               formdata.append("pass",pass);
               formdata.append("mobile",mobile);
               formdata.append("address",address);
               formdata.append("location",location);
               formdata.append("min_del",min_del);
               formdata.append("del_charges",del_charges);
               formdata.append("start_time",start_time);
               formdata.append("end_time",end_time);
               formdata.append("comments",comments);
               formdata.append("desc",desc);
               
               //Attaching files...
               formdata.append("photo_wide",document.getElementById("photo_wide").files[0]);
               formdata.append("photo_square",document.getElementById("photo_square").files[0]);
               
               //Sending formdata bundle along with AJAX request...
               xhttp.send(formdata);
                    
                }
            }
            }
            
        </script>
    </head>
    <body>
        <div class="container">
            <h1 class="jumbotron text-center mb-4" style="background-color: green;color: white;">Restaurant SignUp</h1>

            <form>

                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Restaurant Name</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="enter name" id="name" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Email </label>
                    </div>
                    <div class="col-sm-3">
                        <input type="email" placeholder="enter email" id="email" class="form-control"/>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>City</label>
                    </div>
                    <div class="col-sm-3" id="s1">
                        <select class="form-control" id="city">
                            <option>Select City</option>
                            <option>Amritsar</option>
                            <option>Jalandhar</option>
                            <option>Ludhiana</option>
                            <option>Banglore</option>
                            <option>Batala</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <label>Photo Wide</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="file" id="photo_wide" class="form-control" accept="image/*" />
                    </div>
                </div>


                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Password</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="password" placeholder="enter password" id="pass" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Photo Square</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="file" id="photo_square" class="form-control" accept="image/*" />
                    </div>
                </div>


                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Confirm Password</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="password" placeholder="confirm password" id="confirm_pass" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Minimum Delivery</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="min_allowed_delivery" id="min_del" class="form-control"/>
                    </div>
                </div>


                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Mobile Number</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="enter mobile" id="mobile" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Delivery Charges</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="delivery charges" id="del_charges" class="form-control"/>
                    </div>
                </div>


                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Address</label>
                    </div>
                    <div class="col-sm-3">
                        <textarea class="form-control" rows="3" placeholder="enter complete address" style="resize: none;" id="address"></textarea>
                    </div>
                    <div class="col-sm-3">
                        <label>Delivery Start Time</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="time" placeholder="start time" id="start_time" class="form-control"/>
                    </div>
                </div>


                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Location</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="location" id="location" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Delivery End Time</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="time" placeholder="close time" id="end_time" class="form-control"/>
                    </div>
                </div>
                
                
                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Description</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="description" id="desc" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Comments</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="comments" id="comments" class="form-control"/>
                    </div>
                </div>
                
                <br>
                <div class="text-center">
                    <input type="button" class="btn btn-success btn-lg" value="Submit" id="b1" onclick="go()" />
                </div>

            </form>
            <br><br><br>
        </div>
    </body>
</html>
