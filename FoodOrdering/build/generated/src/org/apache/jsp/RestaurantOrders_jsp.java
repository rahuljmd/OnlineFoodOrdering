package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import vmm.Dbloader;

public final class RestaurantOrders_jsp extends org.apache.jasper.runtime.HttpJspBase
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
                email=session.getAttribute("restaurant_email").toString();
            }
            
      out.write("\n");
      out.write("            \n");
      out.write("            <script>\n");
      out.write("                function fetchRestaurantOrders(){\n");
      out.write("                                     var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                      var res = this.responseText.trim();\n");
      out.write("                      console.log(res);\n");
      out.write("                      var mainobj=JSON.parse(res);\n");
      out.write("                      var arr=mainobj[\"ans\"];\n");
      out.write("                      var ans=\"<table class='table table-hover table-bordered'>\";\n");
      out.write("                      ans=ans+\"<tr>\";\n");
      out.write("                      ans=ans+\"<th>Bill id</th>\";\n");
      out.write("                      ans=ans+\"<th>Restaurant Name</th>\";\n");
      out.write("                      ans=ans+\"<th>Customer email</th>\";\n");
      out.write("                      ans=ans+\"<th>Date Time</th>\";\n");
      out.write("                      ans=ans+\"<th>Subtotal</th>\";\n");
      out.write("                      ans=ans+\"<th>Delivery Charges</th>\";\n");
      out.write("                      ans=ans+\"<th>tax(%)</th>\";\n");
      out.write("                      ans=ans+\"<th>Discount</th>\";\n");
      out.write("                      ans=ans+\"<th>Total</th>\";\n");
      out.write("                      ans=ans+\"<th>Payment Method</th>\";\n");
      out.write("                      ans=ans+\"<th>View Details</th>\";\n");
      out.write("                      ans=ans+\"</tr>\";\n");
      out.write("                      for(var i=0;i<arr.length;i++){\n");
      out.write("                          ans=ans+\"<tr>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i][\"bill_id\"]+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i][\"restaurant_name\"]+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i].customer_email+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i].date_time_of_bill+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i].subtotal+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i].delivery_charges+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i][\"tax(%)\"]+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i].discount+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i].total+\"</td>\";\n");
      out.write("                          ans=ans+\"<td>\"+arr[i].payment_method+\"</td>\";\n");
      out.write("                          ans=ans+\"<td><button class=\\'btn btn-success\\' data-toggle=\\\"modal\\\" data-target=\\\"#exampleModal\\\" onclick='fetchOrderDetails(\"+arr[i][\"bill_id\"]+\")'>View</button></td>\";\n");
      out.write("                          ans=ans+\"</tr>\";\n");
      out.write("                      }\n");
      out.write("            ans=ans+\"</table>\";\n");
      out.write("            document.getElementById(\"d1\").innerHTML=ans;\n");
      out.write("   \n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./FetchRestaurantOrders\", true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            </script>\n");
      out.write("          \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"fetchRestaurantOrders()\">\n");
      out.write("        ");
      out.write("    <nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">Foody</a>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav navbar-nav\">\n");
      out.write("      <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("      <li><a href=\"#\">Change Password</a></li>\n");
      out.write("      <li><a href=\"RestaurantOrders.jsp\">Manage Orders</a></li>\n");
      out.write("      <li><a href=\"#\">Edit Profile</a></li>\n");
      out.write("      <li><a href=\"#\">Logout</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"conatiner\" id=\"d1\">\n");
      out.write("            \n");
      out.write("            \n");
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
