<%-- 
    Document   : ManageCuisines
    Created on : 18 May, 2021, 8:27:34 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="AdminHead.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <%
            String username="";
            if(session.getAttribute("admin_username")==null){
                response.sendRedirect("adminlogin.jsp");
            }
            else{
                 username=session.getAttribute("admin_username").toString();
            }
            %>
        <style>
            .table th{
                text-align: center;
            }
        </style>
        
        
        <script>
            function go(){
                var t1=document.getElementById("t1").value;
                var t2=document.getElementById("t2").value;
               var f1=document.getElementById("f1").files[0];

                console.log(t1);
                console.log(t2);
                console.log(f1);
            if(t1==""||t2==""||f1==undefined){
                    alert("All fields are required!!");
                }
                else{
                           var xhttp=new XMLHttpRequest();
                xhttp.onreadystatechange=function(){
                  if(this.readyState==4&&this.status==200){
                      var res=this.responseText.trim();
                      alert(res);
                      fetchCuisines();

//                      document.getElementById("d2").innerHTML=res;
                  }  
                };
                xhttp.open("POST","./AddCuisines",true);
                
                //Extra code for multipart request...
               var formdata=new FormData();
               
               //Attaching text data
               formdata.append("cuisine_name",t1);
               formdata.append("description",t2);
               
               //Attaching files...
               formdata.append("f1",document.getElementById("f1").files[0]);
               
               //Sending formdata bundle along with AJAX request...
               xhttp.send(formdata);
                    
                }
            }
            
            function fetchCuisines(){
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
                        ans=ans+"<th>Description</th>";
                        ans=ans+"<th>Photo</th>";
                        ans=ans+"<th>Delete</th>";
                        ans=ans+"</tr>";
                        for(var i=0;i<arr.length;i++){
                            ans=ans+"<tr>";
                            ans=ans+"<td>"+arr[i]["cuisine_name"]+"</td>";
                            ans=ans+"<td>"+arr[i]["description"]+"</td>";
                            ans=ans+"<td><img src=\""+arr[i]["photo"]+"\" style=\"width:150px;height:150px;\"/></td>";
                            ans=ans+"<td><button class='btn btn-danger' onclick=\'deleteCuisine(\""+arr[i].cuisine_name+"\")\' >Delete</button></td>";
                            ans=ans+"</tr>";
                        }
                        document.getElementById("d1").innerHTML=ans;
                    }
                };
                xhttp.open("GET", "./FetchCuisines", true);
                xhttp.send();
            }
            
            
            function deleteCuisine(cuisine_name){
                console.log(cuisine_name);
                var r=confirm("Are you sure you want to delete "+cuisine_name+"?");
                if(r){
                  var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var res = this.responseText.trim();
                        console.log(res);
                        alert(res);
                       fetchCuisines();
                       
                        }
//                        document.getElementById("d1").innerHTML=ans;
                    
                };
                xhttp.open("GET", "./DeleteCuisine?cuisine_name="+cuisine_name, true);
                xhttp.send();
            }
                
            }
            
            </script>
    </head>
    <body onload="fetchCuisines()">
        <%@include file="AdminHeader.jsp" %>
        <div class="container mt-3">
            <form>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label id="lb1">Cuisine Name</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" placeholder="cuisine name" id="t1" />
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Description</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" placeholder="description" id="t2"/>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Photo</label>
                    </div>
                    <div class="col-sm-6">
                        <input type="file" class="form-control" id="f1"  />
                    </div>
                </div>
                <br>
                <input type="button" value="Submit" class="btn btn-primary" onclick="go()"/>
            </form>
        </div>
        
        <div class="container text-center" style="margin-top: 30px;">
            <div id="d1">
                
            </div>
        </div>

    </body>
</html>
