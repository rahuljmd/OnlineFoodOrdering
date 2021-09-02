package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vmm.Dbloader;
import java.sql.ResultSet;

public final class RestaurantHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
      out.write("        ");

            String email="";
            if(session.getAttribute("restaurant_email")==null){
                response.sendRedirect("RestaurantLogin.jsp");
            }
            else{
                 email=session.getAttribute("restaurant_email").toString();
            }
            
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
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
      out.write("      <li><a href=\"#\">Change Password</a></li>\n");
      out.write("      <li><a href=\"RestaurantOrders.jsp\">Manage Orders</a></li>\n");
      out.write("      <li><a href=\"#\">Edit Profile</a></li>\n");
      out.write("      <li><a href=\"#\">Logout</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"conatiner\">\n");
      out.write("            ");

            ResultSet rs=Dbloader.executeSql("select * from restaurant where email_id='"+email+"'");
            while(rs.next()){
               String name=rs.getString("restaurant_name");
               String photo_wide=rs.getString("photo_wide");
               String photo_square=rs.getString("photo_square");
               String mobile=rs.getString("mobile");
               String del_start=rs.getString("delivery_start");
               String del_end=rs.getString("delivery_end");
               int min_del= rs.getInt("min_delivery");
               int del_charges= rs.getInt("delivery_charges");
            
            
      out.write("\n");
      out.write("           \n");
      out.write("            <div class=\"conatiner text-center\">\n");
      out.write("                <img src=\"");
      out.print(photo_wide);
      out.write("\" alt=\"image\" style=\"width: 100%;height:120px;\"/>     <br>\n");
      out.write("                <h2>Welcome ");
      out.print(name);
      out.write("</h2>\n");
      out.write("            </div>\n");
      out.write("                <br><br>\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("               <div class=\"row\">\n");
      out.write("                   <div class=\"col-sm-4\">\n");
      out.write("                       <img src=\"");
      out.print(photo_square);
      out.write("\" alt=\"image\"/>\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"col-sm-4 text-left\" style=\"margin-top: 20px;\">\n");
      out.write("                       <label>Mobile: ");
      out.print( mobile);
      out.write("</label><br>\n");
      out.write("                       <label>Email: ");
      out.print( email);
      out.write("</label><br>\n");
      out.write("                       <label>Delivery Charges: ");
      out.print( del_charges);
      out.write("</label><br>\n");
      out.write("                       <label>Minimum Delivery: ");
      out.print( min_del);
      out.write("</label><br>\n");
      out.write("                       <label>Start Time: ");
      out.print( del_start);
      out.write("</label><br>\n");
      out.write("                       <label>Close Time: ");
      out.print( del_end);
      out.write("</label><br>\n");
      out.write("                   </div>\n");
      out.write("               </div>\n");
      out.write("                </div>\n");
      out.write("               ");

               }
               
      out.write("\n");
      out.write("               \n");
      out.write("        </div>\n");
      out.write("               <br><br><br><br>\n");
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
