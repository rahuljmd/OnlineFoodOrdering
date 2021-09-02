import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.SimpleMailDemo;

public class ForgotPassCust extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       try{
           String email=request.getParameter("email");
           ResultSet rs=Dbloader.executeSql("Select * from food_ordering.customer where email_id='"+email+"'");
         if(rs.next()){
             
             String msg="";
             msg+="<a href=\"http://localhost:8084/FoodOrdering/RecoverCustPass.jsp?email="+email+"\" >Click here to recover password</a>";
             msg+="<br><br>This link is valid for 10 minutes!!";
             SimpleMailDemo obj=new SimpleMailDemo(email,"Recover Password",msg);
             out.println("Recover password link has been sent to your email!!");
         }
         else{
             out.println("Invalid Email!!!!");
         }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

}
