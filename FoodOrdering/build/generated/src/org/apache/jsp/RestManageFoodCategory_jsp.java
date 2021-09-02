package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import vmm.Dbloader;

public final class RestManageFoodCategory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/RestaurantHeader1.jsp");
    _jspx_dependants.add("/RestaurantHeader.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");

            String email="";
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                email=(String)session.getAttribute("restaurant_email");
            }
            
      out.write("\n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">-->\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        ");
      out.write(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("        \n");
      out.write("           <style>\n");
      out.write("            .table th{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function addCategory(){\n");
      out.write("                var name=document.getElementById(\"name\").value;\n");
      out.write("                var desc=document.getElementById(\"desc\").value;\n");
      out.write("                var s1=document.getElementById(\"s1\").value;\n");
      out.write("//                console.log(s1);\n");
      out.write("                var photo_wide=document.getElementById(\"photo_wide\").files[0];\n");
      out.write("                var photo_square=document.getElementById(\"photo_square\").files[0];\n");
      out.write("\n");
      out.write("            if(name==\"\"||desc==\"\"||photo_wide==undefined||photo_square==undefined||s1==\"\"){\n");
      out.write("                    alert(\"All fields are required!!\");\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    \n");
      out.write("                     if(s1==\"select a cuisine\"){\n");
      out.write("                        alert(\"Please select cuisine first!!!\");\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                           var xhttp=new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange=function(){\n");
      out.write("                  if(this.readyState==4&&this.status==200){\n");
      out.write("                      var res=this.responseText.trim();\n");
      out.write("                      alert(res);\n");
      out.write("                       console.log(res);\n");
      out.write("                       document.getElementById(\"form1\").reset();\n");
      out.write("                       viewCategories();\n");
      out.write("                  }  \n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\",\"./AddRestFoodCategory\",true);\n");
      out.write("                \n");
      out.write("                //Extra code for multipart request...\n");
      out.write("               var formdata=new FormData();\n");
      out.write("               \n");
      out.write("               //Attaching text data\n");
      out.write("               formdata.append(\"name\",name);\n");
      out.write("               formdata.append(\"desc\",desc);\n");
      out.write("               formdata.append(\"s1\",s1);\n");
      out.write("               \n");
      out.write("               //Attaching files...\n");
      out.write("               formdata.append(\"photo_wide\",document.getElementById(\"photo_wide\").files[0]);\n");
      out.write("               formdata.append(\"photo_square\",document.getElementById(\"photo_square\").files[0]);\n");
      out.write("               \n");
      out.write("               //Sending formdata bundle along with AJAX request...\n");
      out.write("               xhttp.send(formdata);\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function viewCategories(){\n");
      out.write("                    var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        var mainobj=JSON.parse(res);\n");
      out.write("                        var arr=mainobj[\"ans\"];\n");
      out.write("                        var ans=\"<table class=\\\"table table-hover table-bordered\\\" id='table'>\";\n");
      out.write("                        ans=ans+\"<tr>\";\n");
      out.write("                        ans=ans+\"<th>Cuisine Name</th>\";\n");
      out.write("                        ans=ans+\"<th>Category Name</th>\";\n");
      out.write("                        ans=ans+\"<th>Description</th>\";\n");
      out.write("                        ans=ans+\"<th>Photo Wide</th>\";\n");
      out.write("                        ans=ans+\"<th>Photo Square</th>\";\n");
      out.write("                        ans=ans+\"<th>Action</th>\";\n");
      out.write("                        ans=ans+\"</tr>\";\n");
      out.write("                        for(var i=0;i<arr.length;i++){\n");
      out.write("                            ans=ans+\"<tr>\";\n");
      out.write("                            ans=ans+\"<td>\"+arr[i][\"cuisine_name\"]+\"</td>\";\n");
      out.write("                            ans=ans+\"<td>\"+arr[i][\"category_name\"]+\"</td>\";\n");
      out.write("                            ans=ans+\"<td>\"+arr[i][\"category_description\"]+\"</td>\";\n");
      out.write("                            ans=ans+\"<td><img src=\\\"\"+arr[i][\"photo_wide\"]+\"\\\" style=\\\"width:150px;height:150px;\\\"/></td>\";\n");
      out.write("                            ans=ans+\"<td><img src=\\\"\"+arr[i][\"photo_square\"]+\"\\\" style=\\\"width:150px;height:150px;\\\"/></td>\";\n");
      out.write("                            ans=ans+\"<td><button class='btn btn-danger' onclick=\\'deleteCategory(\\\"\"+arr[i].category_name+\"\\\")\\' >Delete</button></td>\";\n");
      out.write("                            ans=ans+\"</tr>\";\n");
      out.write("                        }\n");
      out.write("                        document.getElementById(\"d1\").innerHTML=ans;\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./FetchCategories\", true);\n");
      out.write("                xhttp.send();\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            function deleteCategory(category_name){\n");
      out.write("                console.log(category_name);\n");
      out.write("                  var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        alert(res);\n");
      out.write("                       viewCategories();\n");
      out.write("                       \n");
      out.write("                        }\n");
      out.write("//                        document.getElementById(\"d1\").innerHTML=ans;\n");
      out.write("                    \n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./DeleteCategory?category_name=\"+category_name, true);\n");
      out.write("                xhttp.send();\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body onload=\"viewCategories()\">\n");
      out.write("         ");
      out.write("    <nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">Foody</a>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav navbar-nav\">\n");
      out.write("      <li class=\"active\"><a href=\"RestaurantHome.jsp\">Home</a></li>\n");
      out.write("      <li><a href=\"RestaurantChangePassword.jsp\">Change Password</a></li>\n");
      out.write("      <li><a href=\"RestaurantOrders.jsp\">Manage Orders</a></li>\n");
      out.write("      <li><a href=\"RestManageFoodCategory.jsp\">Manage Categories</a></li>\n");
      out.write("      <li><a href=\"RestManageFoodItems.jsp\">Manage Food Items</a></li>\n");
      out.write("      <li><a href=\"#\">Edit Profile</a></li>\n");
      out.write("      <li><a href=\"RestaurantLogout.jsp\">Logout</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <form id=\"form1\">\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Select Cuisine</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <select class=\"form-select form-control\" id=\"s1\">\n");
      out.write("                            <option>select a cuisine</option>\n");
      out.write("                            ");

                                ResultSet rs=Dbloader.executeSql("select * from cuisines");
                                while(rs.next()){
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(rs.getInt("cuisine_id"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("cuisine_name"));
      out.write("</option>     \n");
      out.write("                                    ");

                                }
                                
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                 <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Food Category Name</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"text\" id=\"name\" class=\"form-control\" placeholder=\"enter category name\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Food Category Description</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"text\" id=\"desc\" class=\"form-control\" placeholder=\"enter category description\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Photo Wide</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"file\" id=\"photo_wide\" accept=\"image/*\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Photo Square</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"file\" id=\"photo_square\" accept=\"image/*\" class=\"form-control\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div style=\"text-align: center; margin-top: 45px;\">\n");
      out.write("                    <input type=\"button\" class=\"btn btn-primary \" value=\"Submit\" onclick=\"addCategory()\"/> \n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("                        <br><br>     \n");
      out.write("                        \n");
      out.write("                        <div id=\"d1\" class=\"text-center\">\n");
      out.write("                            <h1 class=\"jumbotron text-center\">Categories</h1>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("                        <br><br><br>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
