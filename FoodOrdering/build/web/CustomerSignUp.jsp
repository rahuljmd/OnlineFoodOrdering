<%-- 
    Document   : CustomerSignUp
    Created on : 20 May, 2021, 6:14:44 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">                                                                       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer SignUp Page</title>
        <script>
            function generatePaasword() { 
          

    var string = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
    let OTP = ''; 
      
    // Find the length of string 
    var len = string.length; 
    for (let i = 0; i < 6; i++ ) { 
        OTP += string[Math.floor(Math.random() * len)]; 
    } 
    return OTP; 
}

function fetchpass(){
    var abc = generatePaasword();
    document.getElementById('otp').value=abc;
}

             function readandpreview(fileobj, imageid)
            {
                var firstfile = fileobj.files[0];
                var reader = new FileReader();
//                alert("File name :" + firstfile.name);
//                alert("File size :" + firstfile.size);
                reader.onload = (function (f)
                {
                    return function read(e)
                    {
                        document.getElementById(imageid).src = e.target.result;
                    }
                })(firstfile);
                reader.readAsDataURL(firstfile);
            }
            
              function go(){
                var name=document.getElementById("name").value;
                var email=document.getElementById("email").value;
                var city=document.getElementById("city").value;
                var pass=document.getElementById("pass").value;
                var confirm_pass=document.getElementById("confirm_pass").value;
                var mobile=document.getElementById("mobile").value;
                var address=document.getElementById("address").value;
                var photo=document.getElementById("photo").files[0];
                var pin=document.getElementById("pin").value;
                var otp=document.getElementById("otp").value;
                var sec_ques=document.getElementById("sec_ques").value;
                var sec_ans=document.getElementById("sec_ans").value;

            if(name==""||otp==""||email==""||photo==undefined||city==""||pass==""||confirm_pass==""||mobile==""||address==""||pin==""||sec_ques==""||sec_ans==""){
                    alert("All fields are required!!");
                }
                else{
                    if(confirm_pass!=pass){
                        alert("passwords don't match!!");
                    }
                     else if(city=="Select City"){
                        alert("Please select city first!!!");
                    }
                     else if(sec_ques=="Select a security question"){
                        alert("Please select security question!!!");
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
                xhttp.open("POST","./CustomerSignUp",true);
                
                //Extra code for multipart request...
               var formdata=new FormData();
               
               //Attaching text data
               formdata.append("name",name);
               formdata.append("email",email);
               formdata.append("city",city);
               formdata.append("pass",pass);
               formdata.append("mobile",mobile);
               formdata.append("address",address);
               formdata.append("otp",otp);
               formdata.append("pin",pin);
               formdata.append("sec_ans",sec_ans);
               formdata.append("sec_ques",sec_ques);
               
               //Attaching files...
               formdata.append("photo",document.getElementById("photo").files[0]);
               
               //Sending formdata bundle along with AJAX request...
               xhttp.send(formdata);
                    
                }
            }
            }
            
        </script>
    </head>
    <body onload="fetchpass()">
        <div class="container">
            <h1 class="jumbotron text-center mb-4" style="background-color: #007bff;color: white;">Customer SignUp</h1>

            <form>

                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Full Name</label>
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
                        <select class="form-control form-select" id="city">
                            <option>Select City</option>
                            <option>Amritsar</option>
                            <option>Jalandhar</option>
                            <option>Ludhiana</option>
                            <option>Banglore</option>
                            <option>Batala</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <label>Enter OTP</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" readonly placeholder="enter otp" id="otp" class="form-control"/>
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
                        <label>Mobile Number</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="enter mobile" id="mobile" class="form-control"/>
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
                        <label>Security Question</label>
                    </div>
                    <div class="col-sm-3">
                        <select id="sec_ques" class="form-select form-control">
                            <option>Select a security question</option>
                            <option>Your nick name?</option>
                            <option>Your favourite color?</option>
                            <option>your favourite movie?</option>
                        </select>
                    </div>
                </div>


                <div class="row form-group">
                       <div class="col-sm-3">
                        <label>Pin code</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="enter 6 digit area code" id="pin" class="form-control"/>
                    </div>
                  <div class="col-sm-3">
                        <label>Security Answer</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="security answer" id="sec_ans" class="form-control"/>
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
                        <label>Photo</label>
                    </div>
                    <div class="col-sm-3">
                         <img src="" style="height:200px;width:100%" id="docphoto" name="docphoto"/>

                                <input type="file" id="photo" name="photo" onchange="readandpreview(this, 'docphoto')"/>

                        <!--<input type="file" id="photo" class="form-control" accept="image/*" />-->
                    </div>
                </div>


                <br>
                <div class="text-center">
                    <input type="button" class="btn btn-primary btn-lg" value="Submit" id="b1" onclick="go()" />
                </div>

            </form>
            <br><br><br>
        </div>
    </body>
</html>
