package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ManageCuisines_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/AdminHead.jsp");
    _jspx_dependants.add("/AdminHeader.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("   <style>\n");
      out.write("            .apni li a{\n");
      out.write("                color:white;\n");
      out.write("            }   \n");
      out.write("        </style>");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("           ");

            String username="";
            if(session.getAttribute("admin_username")==null){
                response.sendRedirect("adminlogin.jsp");
            }
            else{
                 username=session.getAttribute("admin_username").toString();
            }
            
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .table th{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function go(){\n");
      out.write("                var t1=document.getElementById(\"t1\").value;\n");
      out.write("                var t2=document.getElementById(\"t2\").value;\n");
      out.write("               var f1=document.getElementById(\"f1\").files[0];\n");
      out.write("\n");
      out.write("                console.log(t1);\n");
      out.write("                console.log(t2);\n");
      out.write("                console.log(f1);\n");
      out.write("            if(t1==\"\"||t2==\"\"||f1==undefined){\n");
      out.write("                    alert(\"All fields are required!!\");\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                           var xhttp=new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange=function(){\n");
      out.write("                  if(this.readyState==4&&this.status==200){\n");
      out.write("                      var res=this.responseText.trim();\n");
      out.write("                      alert(res);\n");
      out.write("                      fetchCuisines();\n");
      out.write("\n");
      out.write("//                      document.getElementById(\"d2\").innerHTML=res;\n");
      out.write("                  }  \n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\",\"./AddCuisines\",true);\n");
      out.write("                \n");
      out.write("                //Extra code for multipart request...\n");
      out.write("               var formdata=new FormData();\n");
      out.write("               \n");
      out.write("               //Attaching text data\n");
      out.write("               formdata.append(\"cuisine_name\",t1);\n");
      out.write("               formdata.append(\"description\",t2);\n");
      out.write("               \n");
      out.write("               //Attaching files...\n");
      out.write("               formdata.append(\"f1\",document.getElementById(\"f1\").files[0]);\n");
      out.write("               \n");
      out.write("               //Sending formdata bundle along with AJAX request...\n");
      out.write("               xhttp.send(formdata);\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function fetchCuisines(){\n");
      out.write("                  var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        var mainobj=JSON.parse(res);\n");
      out.write("                        var arr=mainobj[\"ans\"];\n");
      out.write("                        var ans=\"<table class=\\\"table table-hover table-bordered\\\" id='table'>\";\n");
      out.write("                        ans=ans+\"<tr>\";\n");
      out.write("                        ans=ans+\"<th>Cuisine Name</th>\";\n");
      out.write("                        ans=ans+\"<th>Description</th>\";\n");
      out.write("                        ans=ans+\"<th>Photo</th>\";\n");
      out.write("                        ans=ans+\"<th>Delete</th>\";\n");
      out.write("                        ans=ans+\"</tr>\";\n");
      out.write("                        for(var i=0;i<arr.length;i++){\n");
      out.write("                            ans=ans+\"<tr>\";\n");
      out.write("                            ans=ans+\"<td>\"+arr[i][\"cuisine_name\"]+\"</td>\";\n");
      out.write("                            ans=ans+\"<td>\"+arr[i][\"description\"]+\"</td>\";\n");
      out.write("                            ans=ans+\"<td><img src=\\\"\"+arr[i][\"photo\"]+\"\\\" style=\\\"width:150px;height:150px;\\\"/></td>\";\n");
      out.write("                            ans=ans+\"<td><button class='btn btn-danger' onclick=\\'deleteCuisine(\\\"\"+arr[i].cuisine_name+\"\\\")\\' >Delete</button></td>\";\n");
      out.write("                            ans=ans+\"</tr>\";\n");
      out.write("                        }\n");
      out.write("                        document.getElementById(\"d1\").innerHTML=ans;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./FetchCuisines\", true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function deleteCuisine(cuisine_name){\n");
      out.write("                console.log(cuisine_name);\n");
      out.write("                  var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        alert(res);\n");
      out.write("                       fetchCuisines();\n");
      out.write("                       \n");
      out.write("                        }\n");
      out.write("//                        document.getElementById(\"d1\").innerHTML=ans;\n");
      out.write("                    \n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./DeleteCuisine?cuisine_name=\"+cuisine_name, true);\n");
      out.write("                xhttp.send();\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"fetchCuisines()\">\n");
      out.write("        ");
      out.write("<nav class=\"navbar bg-primary\" style=\"background-color: #040505\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <a class=\"navbar-brand\" style=\"color:white\" href=\"#\">FOODY</a>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav navbar-nav apni\">\n");
      out.write("      <li class=\"active\"><a href=\"AdminHome.jsp\">Home</a></li>\n");
      out.write("      <li class=\"active\"><a href=\"ManageCuisines.jsp\">Manage Cuisines</a></li>\n");
      out.write("      <li><a href=\"AdminChangePassword.jsp\">Change Password</a></li>\n");
      out.write("      <li><a href=\"adminlogout.jsp\">Logout</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        <div class=\"container mt-3\">\n");
      out.write("            <form>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label id=\"lb1\">Cuisine Name</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"cuisine name\" id=\"t1\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Description</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"description\" id=\"t2\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Photo</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"file\" class=\"form-control\" id=\"f1\"  />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"button\" value=\"Submit\" class=\"btn btn-primary\" onclick=\"go()\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"container text-center\" style=\"margin-top: 30px;\">\n");
      out.write("            <div id=\"d1\">\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
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
