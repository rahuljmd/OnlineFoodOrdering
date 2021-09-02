package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CustomerChangePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         ");

            String email="";
            if(session.getAttribute("customer_email")==null){
                response.sendRedirect("CustomerLogin.jsp");
            }
            else{
                 email=session.getAttribute("customer_email").toString();
            }
            
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function go() {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                var email = document.getElementById(\"email\").value;\n");
      out.write("                var old_pass = document.getElementById(\"old_pass\").value;\n");
      out.write("                var new_pass = document.getElementById(\"new_pass\").value;\n");
      out.write("                var confirm_pass = document.getElementById(\"confirm_pass\").value;\n");
      out.write("                if (email != \"\" && old_pass != \"\" && new_pass != \"\"&&confirm_pass!=\"\") {\n");
      out.write("                    if (confirm_pass != new_pass) {\n");
      out.write("                        alert(\"New passwords don't match!!\");\n");
      out.write("                    } else {\n");
      out.write("\n");
      out.write("                        xhttp.onreadystatechange = function () {\n");
      out.write("\n");
      out.write("                            if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                                var res = this.responseText.trim();\n");
      out.write("                                console.log(res);\n");
      out.write("                                alert(res);\n");
      out.write("                            }\n");
      out.write("                        };\n");
      out.write("                        var url = \"./CustomerChangePassword?email=\" +email+\"&old_pass=\"+old_pass+\"&new_pass=\"+new_pass;\n");
      out.write("                        xhttp.open(\"GET\", url, true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    alert(\"All fields are required!!!\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!--style=\"background-color: #007bff ; color:white;\"-->\n");
      out.write("            <h1 class=\"jumbotron text-center\" >Customer Change Password</h1>\n");
      out.write("            <form>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Enter Email</label>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"email\" placeholder=\"email\" id=\"email\" value=\"");
      out.print(email);
      out.write("\" readonly=\"readonly\" class=\"form-control\"/> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Enter Old Password</label>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"password\" placeholder=\" old password\" id=\"old_pass\" required=\"required\" class=\"form-control\"/>   \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Enter New Password</label>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"password\" placeholder=\"new password\" id=\"new_pass\" required=\"required\" class=\"form-control\"/>   \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Confirm New Password</label>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"password\" placeholder=\" confirm password\" id=\"confirm_pass\" required=\"required\" class=\"form-control\"/>   \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div style=\"text-align: left\">\n");
      out.write("                    <input type=\"button\" value=\"Submit\" class=\"btn btn-success\" onclick=\"go()\" />\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <br><br><br>\n");
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
