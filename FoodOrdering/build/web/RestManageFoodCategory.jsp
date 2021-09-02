<%-- 
    Document   : RestManageFoodCategory
    Created on : 23 May, 2021, 6:30:18 PM
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
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                email=(String)session.getAttribute("restaurant_email");
            }
            %>
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%@include file="RestaurantHeader1.jsp" %>
        
           <style>
            .table th{
                text-align: center;
            }
        </style>
        <script>
            function addCategory(){
                var name=document.getElementById("name").value;
                var desc=document.getElementById("desc").value;
                var s1=document.getElementById("s1").value;
//                console.log(s1);
                var photo_wide=document.getElementById("photo_wide").files[0];
                var photo_square=document.getElementById("photo_square").files[0];

            if(name==""||desc==""||photo_wide==undefined||photo_square==undefined||s1==""){
                    alert("All fields are required!!");
                }
                else{
                    
                     if(s1=="select a cuisine"){
                        alert("Please select cuisine first!!!");
                    }
                    else{
                           var xhttp=new XMLHttpRequest();
                xhttp.onreadystatechange=function(){
                  if(this.readyState==4&&this.status==200){
                      var res=this.responseText.trim();
                      alert(res);
                       console.log(res);
                       document.getElementById("form1").reset();
                       viewCategories();
                  }  
                };
                xhttp.open("POST","./AddRestFoodCategory",true);
                
                //Extra code for multipart request...
               var formdata=new FormData();
               
               //Attaching text data
               formdata.append("name",name);
               formdata.append("desc",desc);
               formdata.append("s1",s1);
               
               //Attaching files...
               formdata.append("photo_wide",document.getElementById("photo_wide").files[0]);
               formdata.append("photo_square",document.getElementById("photo_square").files[0]);
               
               //Sending formdata bundle along with AJAX request...
               xhttp.send(formdata);
                    
                }
            }
            }
            
            
            function viewCategories(){
                    var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        var mainobj=JSON.parse(res);
                        var arr=mainobj["ans"];
                        var ans="<table class=\"table table-hover table-bordered\" id='table'>";
                        ans=ans+"<tr>";
                        ans=ans+"<th>Cuisine Name</th>";
                        ans=ans+"<th>Category Name</th>";
                        ans=ans+"<th>Description</th>";
                        ans=ans+"<th>Photo Wide</th>";
                        ans=ans+"<th>Photo Square</th>";
                        ans=ans+"<th>Action</th>";
                        ans=ans+"</tr>";
                        for(var i=0;i<arr.length;i++){
                            ans=ans+"<tr>";
                            ans=ans+"<td>"+arr[i]["cuisine_name"]+"</td>";
                            ans=ans+"<td>"+arr[i]["category_name"]+"</td>";
                            ans=ans+"<td>"+arr[i]["category_description"]+"</td>";
                            ans=ans+"<td><img src=\""+arr[i]["photo_wide"]+"\" style=\"width:150px;height:150px;\"/></td>";
                            ans=ans+"<td><img src=\""+arr[i]["photo_square"]+"\" style=\"width:150px;height:150px;\"/></td>";
                            ans=ans+"<td><button class='btn btn-danger' onclick=\'deleteCategory(\""+arr[i].category_name+"\","+arr[i]["cuisine_id"]+")\' >Delete</button></td>";
                            ans=ans+"</tr>";
                        }
                        document.getElementById("d1").innerHTML=ans;
                    }
                    
                };
                xhttp.open("GET", "./FetchCategories", true);
                xhttp.send();
            
            }
            
           
            function deleteCategory(category_name,s1){
                console.log(category_name);
                console.log(s1);
                var r = confirm("Are you sure you want to delete "+category_name+" ?");
                if(r){
                     var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);
                       viewCategories();
                       
                        }
//                        document.getElementById("d1").innerHTML=ans;
                    
                };
                xhttp.open("GET", "./DeleteCategory?category_name="+category_name+"&s1="+s1, true);
                xhttp.send();
                }
               
                
//                 
                
            }
        </script>
        
    </head>
    <body onload="viewCategories()">
         <%@include file="RestaurantHeader.jsp" %>
         <h1 class="text-center jumbotron" style="background-color: green;color: white;">Add/Delete Food Category</h1>
        <div class="container mt-5">
            <form id="form1">
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Select Cuisine</label>
                    </div>
                    <div class="col-sm-6">
                        <select class="form-select form-control" id="s1">
                            <option>select a cuisine</option>
                            <%
                                ResultSet rs=Dbloader.executeSql("select * from cuisines");
                                while(rs.next()){
                                    %>
                                    <option value="<%=rs.getInt("cuisine_id")%>"><%=rs.getString("cuisine_name")%></option>     
                                    <%
                                }
                                %>
                        </select>
                    </div>
                </div>
                
                 <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Food Category Name</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" id="name" class="form-control" placeholder="enter category name"/>
                    </div>
                </div>
                
                
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Food Category Description</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" id="desc" class="form-control" placeholder="enter category description"/>
                    </div>
                </div>
                
                
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Photo Wide</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="file" id="photo_wide" accept="image/*" class="form-control"/>
                    </div>
                </div>
                
                
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Photo Square</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="file" id="photo_square" accept="image/*" class="form-control" />
                    </div>
                </div>
                
                <div style="text-align: center; margin-top: 45px;">
                    <input type="button" class="btn btn-success " value="Submit" onclick="addCategory()"/> 
                </div>
               

            </form>
                        <br><br>     
                        
                        <div id="d1" class="text-center">
                            <h1 class="jumbotron text-center">Categories</h1>
                            
                        </div>

        </div>
                        <br><br><br>
    </body>
</html>
