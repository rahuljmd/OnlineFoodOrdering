import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;
import vmm.SimpleMailDemo;

public class EmailTesting1 extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        try {
SimpleMailDemo obj=new SimpleMailDemo("rahulbhatia76b@gmail.com", "Order Status", "Your Order has been successfully placed!!!");
         out.println("Mail sent successfully!!");   
        } 
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
      
    }

}
