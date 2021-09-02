import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;
import vmm.SimpleMailDemo;

public class Subscription extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");

        try {
SimpleMailDemo obj=new SimpleMailDemo(email, "Subscription Request", "Your subscription request has been approved!!!");
         out.println("<h1>Subscribed successfully!!</h1>");   
         out.println("<br><br><a href=\"index.jsp\">Go back to Home Page </a>");   
        } 
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
      
    }

}
