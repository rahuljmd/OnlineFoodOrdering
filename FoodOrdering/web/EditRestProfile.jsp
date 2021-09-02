<%-- 
    Document   : RestaurantSignUp
    Created on : 20 May, 2021, 6:14:44 PM
    Author     : RAHUL
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="vmm.Dbloader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%
            String email="";
            int rid=0;
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                email=(String)session.getAttribute("restaurant_email");
               rid=(int)session.getAttribute("rid");

            }
            %>
        <%@include file="RestaurantHeader1.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant SignUp Page</title>
        <script>
              function go(){
                var name=document.getElementById("name").value;
                var email=document.getElementById("email").value;
                var city=document.getElementById("city").value;
                var mobile=document.getElementById("mobile").value;
                var address=document.getElementById("address").value;
                var photo_wide=document.getElementById("photo_wide").files[0];
                var photo_square=document.getElementById("photo_square").files[0];
                var min_del=document.getElementById("min_del").value;
                var del_charges=document.getElementById("del_charges").value;
                var start_time=document.getElementById("start_time").value;
                var end_time=document.getElementById("end_time").value;
                var desc=document.getElementById("desc").value;

            if(name==""||desc==""||email==""||photo_wide==undefined||photo_square==undefined||city==""||mobile==""||address==""||min_del==""||del_charges==""||start_time==""||end_time==""){
                    alert("All fields are required!!");
                }
                else{
                   
                     if(city=="Select City"){
                        alert("Please select city first!!!");
                    }
                    else{
                           var xhttp=new XMLHttpRequest();
                xhttp.onreadystatechange=function(){
                  if(this.readyState==4&&this.status==200){
                      var res=this.responseText.trim();
                      alert(res);
                      window.location.href="RestaurantLogin.jsp";

//                      document.getElementById("d2").innerHTML=res;
                  }  
                };
                xhttp.open("POST","./EditRestProfile",true);
                
                //Extra code for multipart request...
               var formdata=new FormData();
               
               //Attaching text data
               formdata.append("name",name);
               formdata.append("email",email);
               formdata.append("city",city);
               formdata.append("mobile",mobile);
               formdata.append("address",address);
               formdata.append("min_del",min_del);
               formdata.append("del_charges",del_charges);
               formdata.append("start_time",start_time);
               formdata.append("end_time",end_time);
               formdata.append("desc",desc);
               
               //Attaching files...
               formdata.append("photo_wide",document.getElementById("photo_wide").files[0]);
               formdata.append("photo_square",document.getElementById("photo_square").files[0]);
               
               //Sending formdata bundle along with AJAX request...
               xhttp.send(formdata);
                    
                }
            }
            }
            
             function readandpreview(fileobj, imageid){
                 
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
            
        </script>
    </head>
    <body>
        <%@include file="RestaurantHeader.jsp" %>
        <div class="container">
            <h1 class="jumbotron text-center mb-4" style="background-color: green;color: white; margin-top: 0px;" >Edit Profile</h1>

            <form>
                <%
               ResultSet rs=Dbloader.executeSql("select * from restaurant where restaurant_id='"+rid+"'");
               String name="";
               String city="";
               String mobile ="";
               String em="";
               String address1="";
               String desc="";
               String pw="";
               String ps="";
               String start="";
               String end="";
               int min_del=0;
               int del_charges=0;
               
               if(rs.next()){
                        name = rs.getString("restaurant_name");
                        city = rs.getString("city");
                        mobile = rs.getString("mobile");
                        em = rs.getString("email_id");
                        address1 = rs.getString("address");
                        desc = rs.getString("description");
                        pw = rs.getString("photo_wide");
                        ps = rs.getString("photo_square");
                        start = rs.getString("delivery_start");
                        end = rs.getString("delivery_end");
                        min_del = rs.getInt("min_delivery");
                        del_charges = rs.getInt("delivery_charges");
                   
               }
                    %>

                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Restaurant Name</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="enter name" value="<%=name%>" id="name" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Email </label>
                    </div>
                    <div class="col-sm-3">
                        <input type="email" placeholder="enter email" value="<%=em%>" id="email" class="form-control"/>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-sm-3">
                        <label> Change City</label>&nbsp;<label>(<%=city%>)</label>
                    </div>
                    <div class="col-sm-3" id="s1">
                        <select class="form-control" id="city" >
                            <option>Select City</option>
                            <option value="Amritsar">Amritsar</option>
                            <option value="Jalandhar">Jalandhar</option>
                            <option value="Ludhiana">Ludhiana</option>
                            <option value="Banglore">Banglore</option>
                            <option value="Batala">Batala</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <label>Minimum Delivery</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="min_allowed_delivery" id="min_del" value="<%=min_del%>" class="form-control"/>
                    </div>
                </div>


                <div class="row form-group">
                     <div class="col-sm-3">
                        <label>Photo Wide</label>
                    </div>
                    <div class="col-sm-3">
                        <!--<input type="file" id="photo_wide" class="form-control" value="<%=pw%>" accept="image/*" />-->
                     <!--<img src ="<%=pw%>" style="height: 150px; width:100%;">-->
                        <!--<input type="file" id="photo_wide" class="form-control" accept="image/*" />-->
                     <img src="<%=pw%>" style="height:150px;width:100%" id="docphoto" name="docphoto"/>

                                <input type="file" id="photo_wide" name="photo_wide" onchange="readandpreview(this, 'docphoto')"/>
                    </div>
                   
                    <div class="col-sm-3">
                        <label>Photo Square</label>
                    </div>
                    <div class="col-sm-3">
<!--                        <img src ="<%=ps%>" style="height: 150px; width: 100%;">
                        <input type="file" id="photo_square" class="form-control" accept="image/*" />-->
                     <img src="<%=ps%>" style="height:150px;width:100%" id="docphoto1" name="docphoto1"/>

                                <input type="file" id="photo_square" name="photo_square" onchange="readandpreview(this, 'docphoto1')"/>
                    </div>  
                </div>
                        

                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Mobile Number</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="enter mobile" id="mobile" value="<%=mobile%>" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Delivery Charges</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="delivery charges" id="del_charges" value="<%=del_charges%>" class="form-control"/>
                    </div>
                </div>


                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Address</label>
                    </div>
                    <div class="col-sm-3">
                        <!--<textarea class="form-control" rows="3" placeholder="enter complete address" style="resize: none;" id="address"></textarea>-->
        <input type="textarea" rows="3" placeholder="address" id="address" value="<%=address1%>" class="form-control"/>

                    </div>
                    <div class="col-sm-3">
                        <label>Delivery Start Time</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="time" placeholder="start time" id="start_time" value="<%=start%>" class="form-control"/>
                    </div>
                </div>


                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Description</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" placeholder="description" id="desc" value="<%=desc%>" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Delivery End Time</label>
                    </div>
                    <div class="col-sm-3">
                        <input type="time" placeholder="close time" id="end_time" value="<%=end%>" class="form-control"/>
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
