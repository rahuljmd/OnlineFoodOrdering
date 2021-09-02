import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;

public class CustomerChangePassword extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
       try{
           
           String email=request.getParameter("email");
           String old_pass=request.getParameter("old_pass");
           String new_pass=request.getParameter("new_pass");
           
           ResultSet rs=Dbloader.executeSql("Select * from customer where email_id='"+email+"'and password='"+old_pass+"'");
         if(rs.next()){
             rs.moveToCurrentRow();
             rs.updateString("password",new_pass);
             rs.updateRow();
             out.println("Password changed successfully!!");
         }
         else{
             out.println("Old password didn't match!!!!");
         }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

}
