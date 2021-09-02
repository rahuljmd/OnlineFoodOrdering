package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            String username="";
            if(session.getAttribute("admin_username")==null){
                response.sendRedirect("adminlogin.jsp");
            }
            else{
                 username=session.getAttribute("admin_username").toString();
            }
            
      out.write("\n");
      out.write("      \n");
      out.write("        <script>\n");
      out.write("//            var rid;\n");
      out.write("            function pendingRestaurants(){\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                          var res = this.responseText;\n");
      out.write("                        var mainobj= JSON.parse(res.trim());\n");
      out.write("                        var arr=mainobj[\"ans\"];\n");
      out.write("                        console.log(arr);\n");
      out.write("               var ans=\"<table class=\\\"table table-bordered\\\">\";\n");
      out.write("               ans=ans+\"<tr>\";\n");
      out.write("               ans=ans+\"<th>id</th>\";\n");
      out.write("               ans=ans+\"<th>name</th>\";\n");
      out.write("               ans=ans+\"<th>city</th>\";\n");
      out.write("               ans=ans+\"<th>mobile</th>\";\n");
      out.write("               ans=ans+\"<th>address</th>\";\n");
      out.write("               ans=ans+\"<th>description</th>\";\n");
      out.write("               ans=ans+\"<th>photo</th>\";\n");
      out.write("               ans=ans+\"<th>open time</th>\";\n");
      out.write("               ans=ans+\"<th>close time</th>\";\n");
      out.write("               ans=ans+\"<th>Minimum delivery</th>\";\n");
      out.write("               ans=ans+\"<th>Delivery charges</th>\";\n");
      out.write("               ans=ans+\"<th>Action</th>\";\n");
      out.write("               ans=ans+\"</tr>\";\n");
      out.write("               for(var i=0;i<arr.length;i++){\n");
      out.write("                      ans = ans + \"<tr>\";\n");
      out.write("                            ans = ans + \"<td id='td1'>\" + arr[i][\"restaurant_id\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"restaurant_name\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"city\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"mobile\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"address\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"description\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td><img src=\\\"\" + arr[i][\"photo_square\"] + \"\\\" style='width:100;height:100;'/></td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"delivery_start\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"delivery_end\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"min_delivery\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"delivery_charges\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td><button class='btn btn-primary' onclick=\\'go(\"+arr[i][\"restaurant_id\"]+\")\\'>Approve</button></td>\";\n");
      out.write("                            ans = ans + \"</tr>\";\n");
      out.write("//                            rid= arr[i][\"restaurant_id\"];\n");
      out.write("                            \n");
      out.write("               }\n");
      out.write("               ans=ans+\"</table>\";\n");
      out.write("                        \n");
      out.write("                 document.getElementById(\"d1\").innerHTML =ans;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./ViewPendingRestaurants\", true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function approvedRestaurants(){\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                          var res = this.responseText;\n");
      out.write("                        var mainobj= JSON.parse(res.trim());\n");
      out.write("                        var arr=mainobj[\"ans\"];\n");
      out.write("                        console.log(arr);\n");
      out.write("               var ans=\"<table class=\\\"table table-bordered\\\">\";\n");
      out.write("               ans=ans+\"<tr>\";\n");
      out.write("               ans=ans+\"<th>id</th>\";\n");
      out.write("               ans=ans+\"<th>name</th>\";\n");
      out.write("               ans=ans+\"<th>city</th>\";\n");
      out.write("               ans=ans+\"<th>mobile</th>\";\n");
      out.write("               ans=ans+\"<th>address</th>\";\n");
      out.write("               ans=ans+\"<th>description</th>\";\n");
      out.write("               ans=ans+\"<th>photo</th>\";\n");
      out.write("               ans=ans+\"<th>open time</th>\";\n");
      out.write("               ans=ans+\"<th>close time</th>\";\n");
      out.write("               ans=ans+\"<th>Minimum delivery</th>\";\n");
      out.write("               ans=ans+\"<th>Delivery charges</th>\";\n");
      out.write("               ans=ans+\"<th>Action</th>\";\n");
      out.write("               ans=ans+\"</tr>\";\n");
      out.write("               for(var i=0;i<arr.length;i++){\n");
      out.write("                      ans = ans + \"<tr>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"restaurant_id\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"restaurant_name\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"city\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"mobile\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"address\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"description\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td><img src=\\\"\" + arr[i][\"photo_square\"] + \"\\\" style='width:100;height:100;'/></td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"delivery_start\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"delivery_end\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"min_delivery\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td>\" + arr[i][\"delivery_charges\"] + \"</td>\";\n");
      out.write("                            ans = ans + \"<td><button class=\\'btn btn-primary\\' onclick=\\'go(\"+arr[i][\"restaurant_id\"]+\")\\'>Pending</button></td>\";\n");
      out.write("                            ans = ans + \"</tr>\";\n");
      out.write("               }\n");
      out.write("               ans=ans+\"</table>\";\n");
      out.write("                        \n");
      out.write("                 document.getElementById(\"d2\").innerHTML =ans;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./ViewApprovedRestaurants\", true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function go(rid) {\n");
      out.write("                \n");
      out.write("                console.log(rid);\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                     var res=this.responseText;\n");
      out.write("                     console.log(res);\n");
      out.write("                     pendingRestaurants();\n");
      out.write("                     approvedRestaurants();\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./ChangeStatus?rid=\" + rid, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"pendingRestaurants(),approvedRestaurants()\">\n");
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
      out.write("        <h3 class=\"text-center mt-3\">Pending Restaurants</h3>\n");
      out.write("        <div id=\"d1\">\n");
      out.write("            Answer will be shown here....\n");
      out.write("        </div>\n");
      out.write("         <h3 class=\"text-center mt-3\">Approved Restaurants</h3>\n");
      out.write(" \n");
      out.write("        <div id=\"d2\">\n");
      out.write("            \n");
      out.write("        </div>\n");
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
