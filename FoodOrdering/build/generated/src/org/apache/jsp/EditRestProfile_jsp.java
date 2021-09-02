package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import vmm.Dbloader;

public final class EditRestProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         ");

            String email="";
            int rid=0;
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                email=(String)session.getAttribute("restaurant_email");
               rid=(int)session.getAttribute("rid");

            }
            
      out.write("\n");
      out.write("        ");
      out.write(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Restaurant SignUp Page</title>\n");
      out.write("        <script>\n");
      out.write("              function go(){\n");
      out.write("                var name=document.getElementById(\"name\").value;\n");
      out.write("                var email=document.getElementById(\"email\").value;\n");
      out.write("                var city=document.getElementById(\"city\").value;\n");
      out.write("                var mobile=document.getElementById(\"mobile\").value;\n");
      out.write("                var address=document.getElementById(\"address\").value;\n");
      out.write("                var photo_wide=document.getElementById(\"photo_wide\").files[0];\n");
      out.write("                var photo_square=document.getElementById(\"photo_square\").files[0];\n");
      out.write("                var min_del=document.getElementById(\"min_del\").value;\n");
      out.write("                var del_charges=document.getElementById(\"del_charges\").value;\n");
      out.write("                var start_time=document.getElementById(\"start_time\").value;\n");
      out.write("                var end_time=document.getElementById(\"end_time\").value;\n");
      out.write("                var desc=document.getElementById(\"desc\").value;\n");
      out.write("\n");
      out.write("            if(name==\"\"||desc==\"\"||email==\"\"||photo_wide==undefined||photo_square==undefined||city==\"\"||mobile==\"\"||address==\"\"||min_del==\"\"||del_charges==\"\"||start_time==\"\"||end_time==\"\"){\n");
      out.write("                    alert(\"All fields are required!!\");\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                   \n");
      out.write("                     if(city==\"Select City\"){\n");
      out.write("                        alert(\"Please select city first!!!\");\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                           var xhttp=new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange=function(){\n");
      out.write("                  if(this.readyState==4&&this.status==200){\n");
      out.write("                      var res=this.responseText.trim();\n");
      out.write("                      alert(res);\n");
      out.write("\n");
      out.write("//                      document.getElementById(\"d2\").innerHTML=res;\n");
      out.write("                  }  \n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\",\"./RestaurantSignUp1\",true);\n");
      out.write("                \n");
      out.write("                //Extra code for multipart request...\n");
      out.write("               var formdata=new FormData();\n");
      out.write("               \n");
      out.write("               //Attaching text data\n");
      out.write("               formdata.append(\"name\",name);\n");
      out.write("               formdata.append(\"email\",email);\n");
      out.write("               formdata.append(\"city\",city);\n");
      out.write("               formdata.append(\"mobile\",mobile);\n");
      out.write("               formdata.append(\"address\",address);\n");
      out.write("               formdata.append(\"min_del\",min_del);\n");
      out.write("               formdata.append(\"del_charges\",del_charges);\n");
      out.write("               formdata.append(\"start_time\",start_time);\n");
      out.write("               formdata.append(\"end_time\",end_time);\n");
      out.write("               formdata.append(\"desc\",desc);\n");
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
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
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
      out.write("      <li><a href=\"ViewRestSale.jsp\">View Sales</a></li>\n");
      out.write("      <li><a href=\"EditRestProfile.jsp\">Edit Profile</a></li>\n");
      out.write("      <li><a href=\"RestaurantLogout.jsp\">Logout</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1 class=\"jumbotron text-center mb-4\" style=\"background-color: green;color: white; margin-top: 0px;\" >Edit Profile</h1>\n");
      out.write("\n");
      out.write("            <form>\n");
      out.write("                ");

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
                    
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Restaurant Name</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"enter name\" value=\"");
      out.print(name);
      out.write("\" id=\"name\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Email </label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"email\" placeholder=\"enter email\" value=\"");
      out.print(em);
      out.write("\" id=\"email\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>City</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\" id=\"s1\">\n");
      out.write("                        <select class=\"form-control\" id=\"city\" selected=\"");
      out.print(city);
      out.write("\" >\n");
      out.write("                            <option>Select City</option>\n");
      out.write("                            <option value=\"Amritsar\">Amritsar</option>\n");
      out.write("                            <option value=\"Jalandhar\">Jalandhar</option>\n");
      out.write("                            <option value=\"Ludhiana\">Ludhiana</option>\n");
      out.write("                            <option value=\"Banglore\">Banglore</option>\n");
      out.write("                            <option value=\"Batala\">Batala</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Photo Wide</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"file\" id=\"photo_wide\" class=\"form-control\" value=\"");
      out.print(pw);
      out.write("\" accept=\"image/*\" />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                     <div class=\"col-sm-3\">\n");
      out.write("                        <label>Minimum Delivery</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"min_allowed_delivery\" id=\"min_del\" value=\"");
      out.print(min_del);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Photo Square</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"file\" id=\"photo_square\" class=\"form-control\" accept=\"image/*\" />\n");
      out.write("                    </div>  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("         \n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Mobile Number</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"enter mobile\" id=\"mobile\" value=\"");
      out.print(mobile);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Delivery Charges</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"delivery charges\" id=\"del_charges\" value=\"");
      out.print(del_charges);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Address</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <textarea class=\"form-control\" rows=\"3\" placeholder=\"enter complete address\" value=\"");
      out.print(address1);
      out.write("\" style=\"resize: none;\" id=\"address\"></textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Delivery Start Time</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"time\" placeholder=\"start time\" id=\"start_time\" value=\"");
      out.print(start);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Description</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"description\" id=\"desc\" value=\"");
      out.print(desc);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Delivery End Time</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"time\" placeholder=\"close time\" id=\"end_time\" value=\"");
      out.print(end);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"button\" class=\"btn btn-success btn-lg\" value=\"Submit\" id=\"b1\" onclick=\"go()\" />\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <br><br><br>\n");
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
