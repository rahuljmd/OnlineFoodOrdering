package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PAYMENTDEMO_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("<!-- Live_Key rzp_live_ILgsfZCZoFIKMb   -->\n");
      out.write("<!-- TEST_Key rzp_test_96HeaVmgRvbrfT -->\n");
      out.write("        <script src=\"https://checkout.razorpay.com/v1/checkout.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function save_rec(){\n");
      out.write("                payment_done();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("             function payment_done() {\n");
      out.write("                var options = {\n");
      out.write("                    \"key\": \"rzp_test_96HeaVmgRvbrfT\", // Enter the Key ID generated from the Dashboard\n");
      out.write("                    \"amount\":10000, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise or INR 500.\n");
      out.write("                    \"currency\": \"INR\",\n");
      out.write("                    \"name\": \"TEST\",\n");
      out.write("                    \"description\": \"TEST\",\n");
      out.write("                    \"image\": \"img.png\",\n");
      out.write("                    \"handler\": function (response) {\n");
      out.write("                alert(response.razorpay_payment_id +\"...\"+response.razorpay_order_id+ \"...\"+response.razorpay_signature);\n");
      out.write("                       \n");
      out.write("                    },\n");
      out.write("                    \"prefill\": {\n");
      out.write("                        \"name\": \"test\", \"email\": \"test24pro@gmail.com\",\n");
      out.write("                        \"contact\": \"\"\n");
      out.write("                    },\n");
      out.write("                    \"notes\": {\n");
      out.write("                        \"address\": \"\"\n");
      out.write("                    },\n");
      out.write("                    \"theme\": {\n");
      out.write("                        \"color\": \"#F37254\"\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var rzp1 = new Razorpay(options);\n");
      out.write("                document.getElementById('cashbtn').onclick = function (e) {\n");
      out.write("                    rzp1.open();\n");
      out.write("                    e.preventDefault();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("                                            <a class=\"btn-hover\" href=\"#\" id=\"cashbtn\" onclick=\"save_rec()\">Place Order</a>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
