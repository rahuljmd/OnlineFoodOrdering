package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CustomerLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"> \n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Customer Login</title>\n");
      out.write("        <script>\n");
      out.write("            function go() {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                var email = document.getElementById(\"email\").value;\n");
      out.write("                var pass = document.getElementById(\"pass\").value;\n");
      out.write("                     if(email!=\"\"&&pass!=\"\"){\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    \n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        var res = this.responseText.trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        if(res===\"success\"){\n");
      out.write("                           window.location.href=\"index.jsp\"; \n");
      out.write("                        }\n");
      out.write("                        else{\n");
      out.write("                        alert(res);\n");
      out.write("                    }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var url = \"./CustomerLogin?email=\"+email+\"&password=\"+pass;\n");
      out.write("                xhttp.open(\"GET\", url, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            else{\n");
      out.write("                alert(\"Fill the form properly!!!\");\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1 class=\"jumbotron text-center\" style=\"background-color: #007bff ; color:white;\">Customer Login</h1>\n");
      out.write("            <form>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Email</label>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"email\" placeholder=\"email\" id=\"email\" required class=\"form-control\"/> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <label>Password</label>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <input type=\"password\" placeholder=\"password\" id=\"pass\" required=\"required\" class=\"form-control\"/>   \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div style=\"text-align: left\">\n");
      out.write("                    <input type=\"button\" value=\"Submit\" class=\"btn btn-success\" onclick=\"go()\" />\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("              <br>\n");
      out.write("            <a href=\"CustomerSignUp.jsp\" style=\"color: blue;\">Signup Now</a>&nbsp;&nbsp;\n");
      out.write("            <a href=\"ForgotPasswordCust.jsp\" style=\"color: red;\">Forgot Password</a>\n");
      out.write("\n");
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
