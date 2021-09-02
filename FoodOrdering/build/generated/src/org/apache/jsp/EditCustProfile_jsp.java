package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import vmm.Dbloader;
import vmm.Dbloader;

public final class EditCustProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");

            String email="";
            if(session.getAttribute("customer_email")==null){
                response.sendRedirect("CustomerLogin.jsp");
            }
            else{
                email=(String)session.getAttribute("customer_email");
            }
            
      out.write("\n");
      out.write("         <!-- Latest compiled and minified CSS -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">                                                                       \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Customer SignUp Page</title>\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("             function readandpreview(fileobj, imageid)\n");
      out.write("            {\n");
      out.write("                var firstfile = fileobj.files[0];\n");
      out.write("                var reader = new FileReader();\n");
      out.write("//                alert(\"File name :\" + firstfile.name);\n");
      out.write("//                alert(\"File size :\" + firstfile.size);\n");
      out.write("                reader.onload = (function (f)\n");
      out.write("                {\n");
      out.write("                    return function read(e)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(imageid).src = e.target.result;\n");
      out.write("                    }\n");
      out.write("                })(firstfile);\n");
      out.write("                reader.readAsDataURL(firstfile);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("              function go(){\n");
      out.write("                var name=document.getElementById(\"name\").value;\n");
      out.write("                var email=document.getElementById(\"email\").value;\n");
      out.write("                var city=document.getElementById(\"city\").value;\n");
      out.write("                var mobile=document.getElementById(\"mobile\").value;\n");
      out.write("                var address=document.getElementById(\"address\").value;\n");
      out.write("                var photo=document.getElementById(\"photo\").files[0];\n");
      out.write("                var sec_ques=document.getElementById(\"sec_ques\").value;\n");
      out.write("                var sec_ans=document.getElementById(\"sec_ans\").value;\n");
      out.write("\n");
      out.write("            if(name==\"\"||email==\"\"||photo==undefined||city==\"\"||mobile==\"\"||address==\"\"||sec_ques==\"\"||sec_ans==\"\"){\n");
      out.write("                    alert(\"All fields are required!!\");\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    \n");
      out.write("                     if(city==\"Select City\"){\n");
      out.write("                        alert(\"Please select city first!!!\");\n");
      out.write("                    }\n");
      out.write("                     else if(sec_ques==\"Select a security question\"){\n");
      out.write("                        alert(\"Please select security question!!!\");\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                           var xhttp=new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange=function(){\n");
      out.write("                  if(this.readyState==4&&this.status==200){\n");
      out.write("                      var res=this.responseText.trim();\n");
      out.write("                      alert(res);\n");
      out.write("                      window.location.href=\"CustomerLogin.jsp\";\n");
      out.write("\n");
      out.write("//                      document.getElementById(\"d2\").innerHTML=res;\n");
      out.write("                  }  \n");
      out.write("                };\n");
      out.write("                xhttp.open(\"POST\",\"./EditCustProfile\",true);\n");
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
      out.write("               formdata.append(\"sec_ans\",sec_ans);\n");
      out.write("               formdata.append(\"sec_ques\",sec_ques);\n");
      out.write("               \n");
      out.write("               //Attaching files...\n");
      out.write("               formdata.append(\"photo\",document.getElementById(\"photo\").files[0]);\n");
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
      out.write("        <div class=\"container\">\n");
      out.write("            <h1 class=\"jumbotron text-center mb-4\" style=\"background-color: #007bff;color: white;\">Edit Profile</h1>\n");
      out.write("\n");
      out.write("            <form>\n");
      out.write("                  ");

               ResultSet rs=Dbloader.executeSql("select * from customer where email_id='"+email+"'");
               String name="";
               String city="";
               String mobile ="";
               String em="";
               String address="";
               String photo="";
               String sec_q="";
               String sec_ans="";
               
               if(rs.next()){
                        name = rs.getString("full_name");
                        city = rs.getString("city");
                        mobile = rs.getString("mobile");
                        em = rs.getString("email_id");
                        address = rs.getString("address");
                        photo = rs.getString("photo");
                        sec_q = rs.getString("security_question");
                        sec_ans = rs.getString("security_answer");
                   
               }
                    
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Full Name</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"enter name\" id=\"name\" value=\"");
      out.print(name);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Email </label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"email\" placeholder=\"enter email\" id=\"email\" value=\"");
      out.print(em);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label> Change City</label>&nbsp;<label>(");
      out.print(city);
      out.write(")</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\" id=\"s1\">\n");
      out.write("                        <select class=\"form-control form-select\" id=\"city\">\n");
      out.write("                            <option>Select City</option>\n");
      out.write("                            <option>Amritsar</option>\n");
      out.write("                            <option>Jalandhar</option>\n");
      out.write("                            <option>Ludhiana</option>\n");
      out.write("                            <option>Banglore</option>\n");
      out.write("                            <option>Batala</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <label>Mobile Number</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"enter mobile\" id=\"mobile\" value=\"");
      out.print(mobile);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                   \n");
      out.write("                  <div class=\"col-sm-3\">\n");
      out.write("                        <label>Security Question</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <select id=\"sec_ques\" class=\"form-select form-control\">\n");
      out.write("                            <option>Select a security question</option>\n");
      out.write("                            <option>Your nick name?</option>\n");
      out.write("                            <option>Your favourite color?</option>\n");
      out.write("                            <option>your favourite movie?</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                     <div class=\"col-sm-3\">\n");
      out.write("                        <label>Security Answer</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <input type=\"text\" placeholder=\"security answer\" id=\"sec_ans\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                       \n");
      out.write("                 \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row form-group\">\n");
      out.write("                     <div class=\"col-sm-3\">\n");
      out.write("                        <label>Address</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <!--<textarea class=\"form-control\" rows=\"3\" placeholder=\"enter complete address\" style=\"resize: none;\" id=\"address\"></textarea>-->\n");
      out.write("        <input type=\"textarea\" rows=\"3\" placeholder=\"address\" id=\"address\" value=\"");
      out.print(address);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    \n");
      out.write("                    </div>\n");
      out.write("                \n");
      out.write("                 <div class=\"col-sm-3\">\n");
      out.write("                        <label>Photo</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                         <img src=\"");
      out.print(photo);
      out.write("\" style=\"height:200px;width:100%\" id=\"docphoto\" name=\"docphoto\"/>\n");
      out.write("\n");
      out.write("                                <input type=\"file\" id=\"photo\" name=\"photo\" onchange=\"readandpreview(this, 'docphoto')\"/>\n");
      out.write("\n");
      out.write("                        <!--<input type=\"file\" id=\"photo\" class=\"form-control\" accept=\"image/*\" />-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"button\" class=\"btn btn-primary btn-lg\" value=\"Submit\" id=\"b1\" onclick=\"go()\" />\n");
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
