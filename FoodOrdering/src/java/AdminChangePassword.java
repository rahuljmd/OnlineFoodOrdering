import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;

public class AdminChangePassword extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
       try{
           
           String user=request.getParameter("user");
           String old_pass=request.getParameter("old_pass");
           String new_pass=request.getParameter("new_pass");
           
           ResultSet rs=Dbloader.executeSql("Select * from admin where username='"+user+"'and password='"+old_pass+"'");
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
