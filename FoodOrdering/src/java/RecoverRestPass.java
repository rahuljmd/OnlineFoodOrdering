import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.SimpleMailDemo;

public class RecoverRestPass extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       try{
           String email=request.getParameter("email");
           String new_pass=request.getParameter("new_pass");
           
           ResultSet rs=Dbloader.executeSql("Select * from food_ordering.restaurant where email_id='"+email+"'");
         if(rs.next()){
             
            rs.moveToCurrentRow();
            rs.updateString("password",new_pass);
            rs.updateRow();
            out.println("Password recovered successfully!!");
         }
         else{
             out.println("Invalid credentials!!!!");
         }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

}
