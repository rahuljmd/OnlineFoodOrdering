import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;
import vmm.SimpleMailDemo;

public class contact extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String name=request.getParameter("name");
        String message=request.getParameter("message");

        try {
            String msg="<br>Phone: "+phone+"<br>Email: "+email+"<br>Message: "+message;
SimpleMailDemo obj=new SimpleMailDemo("rahulbhatia76b@gmail.com", "Customer Contacted",msg );
SimpleMailDemo obj1=new SimpleMailDemo(email, "Thanks for contacting us","Your query has reached us. We will reply shortly!!" );
//         out.println("<h1>Subscribed successfully!!</h1>");   
//         out.println("<br><br><a href=\"index.jsp\">Go back to Home Page </a>");   
          out.println("We will get back to you!!");
        } 
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
      
    }

}
