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
            int rid=0;
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                email=(String)session.getAttribute("restaurant_email");
               rid=(int)session.getAttribute("rid");

            }
            %>
            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%@include file="RestaurantHeader1.jsp" %>
        
           <style>
            .table th{
                text-align: center;
            }
        </style>
        
        <script>
            
            function addFoodItem(){
                var name=document.getElementById("name").value;
                var desc=document.getElementById("desc").value;
                var price=document.getElementById("price").value;
                var offer_price=document.getElementById("offer_price").value;
                var s1=document.getElementById("s1").value;
//                console.log(s1);
                var photo=document.getElementById("photo").files[0];

            if(name==""||desc==""||photo==undefined||s1==""||price==""||offer_price==""){
                    alert("All fields are required!!");
                }
                else{
                    
                     if(s1=="select a category"){
                        alert("Please select category first!!!");
                    }
                    else{
                           var xhttp=new XMLHttpRequest();
                xhttp.onreadystatechange=function(){
                  if(this.readyState==4&&this.status==200){
                      var res=this.responseText.trim();
                      alert(res);
                       console.log(res);
                       document.getElementById("form1").reset();
                        viewFoodItems();
                  }  
                };
                xhttp.open("POST","./AddRestFoodItem",true);
                
                //Extra code for multipart request...
               var formdata=new FormData();
               
               //Attaching text data
               formdata.append("name",name);
               formdata.append("desc",desc);
               formdata.append("price",price);
               formdata.append("offer_price",offer_price);
               formdata.append("s1",s1);
               
               //Attaching files...
               formdata.append("photo",document.getElementById("photo").files[0]);
               
               //Sending formdata bundle along with AJAX request...
               xhttp.send(formdata);
                    
                }
            }
            }
            
            
            function viewFoodItems(){
                    var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        var mainobj=JSON.parse(res);
                        var arr=mainobj["ans"];
                        var ans="<table class=\"table table-hover table-bordered\" id='table'>";
                        ans=ans+"<tr>";
                        ans=ans+"<th>Category Name</th>";
                        ans=ans+"<th>Item Name</th>";
                        ans=ans+"<th>Price</th>";
                        ans=ans+"<th>Offer Price</th>";
                        ans=ans+"<th>Description</th>";
                        ans=ans+"<th>Photo</th>";
                        ans=ans+"<th>Action</th>";
                        ans=ans+"</tr>";
                        for(var i=0;i<arr.length;i++){
                            ans=ans+"<tr>";
                            ans=ans+"<td>"+arr[i]["category_name"]+"</td>";
                            ans=ans+"<td>"+arr[i]["item_name"]+"</td>";
                            ans=ans+"<td>"+arr[i]["price"]+"</td>";
                            ans=ans+"<td>"+arr[i]["offer_price"]+"</td>";
                            ans=ans+"<td>"+arr[i]["item_description"]+"</td>";
                            ans=ans+"<td><img src=\""+arr[i]["photo"]+"\" style=\"width:150px;height:150px;\"/></td>";
                            ans=ans+"<td><button class='btn btn-danger' onclick=\'deleteItem("+arr[i].food_id+")\' >Delete</button></td>";
                            ans=ans+"</tr>";
                        }
                        document.getElementById("d1").innerHTML=ans;
                    }
                    
                };
                xhttp.open("GET", "./FetchFoodItems", true);
                xhttp.send();
            
            }
            
           
            function deleteItem(food_id){
                console.log(food_id);
                var r=confirm("Are you sure you want to delete?");
                if(r){
                  var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);
                       viewFoodItems();
                       
                        }
//                        document.getElementById("d1").innerHTML=ans;
                    
                };
                xhttp.open("GET", "./DeleteFoodItem?food_id="+food_id, true);
                xhttp.send();
            }
                
            }
        </script>
        
    </head>
    <body onload="viewFoodItems()">
         <%@include file="RestaurantHeader.jsp" %>
         <h1 class="text-center jumbotron" style="background-color: green;color: white;">Add/Delete Food Items</h1>
        <div class="container mt-5">
            <form id="form1">
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Select Food Category</label>
                    </div>
                    <div class="col-sm-6">
                        <select class="form-select form-control" id="s1">
                            <option>select a category</option>
                            <%
                                ResultSet rs=Dbloader.executeSql("select * from rest_food_category where restaurant_id='"+rid+"'");
                                while(rs.next()){
                                    %>
                                    <option value="<%=rs.getInt("rest_cat_id")%>"><%=rs.getString("category_name")%></option>     
                                    <%
                                }
                                %>
                        </select>
                    </div>
                </div>
                
                 <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Food Item Name</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" id="name" class="form-control" placeholder="enter item name"/>
                    </div>
                </div>
                
                
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Food Item Description</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" id="desc" class="form-control" placeholder="enter item description"/>
                    </div>
                </div>
                
                
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Food Item Price</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" id="price" class="form-control" placeholder="enter price"/>
                    </div>
                </div>
                        
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Food Item Offer Price</label>
                    </div>
                    <div class="col-sm-6">
               <input type="text" id="offer_price" class="form-control" placeholder="enter offer price"/>

                    </div>
                </div>
                        
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Food Item Image</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="file" id="photo" accept="image/*" class="form-control"/>
                    </div>
                </div>
                
                
                <div style="text-align: center; margin-top: 45px;">
                    <input type="button" class="btn btn-success " value="Submit" onclick="addFoodItem()"/> 
                </div>
               

            </form>
                        <br><br>     
                        
                        <div id="d1" class="text-center">
                            <h1 class="jumbotron text-center">Food Items</h1>
                            
                        </div>

        </div>
                        <br><br><br>
    </body>
</html>
