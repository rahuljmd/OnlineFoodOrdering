import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;

public class CustomerLogin extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       try{
           String email=request.getParameter("email");
//           out.println(user);
           String pass=request.getParameter("password");
//           out.println(pass);
           ResultSet rs=Dbloader.executeSql("Select * from food_ordering.customer where email_id='"+email+"'and password='"+pass+"'");
         if(rs.next()){
             
             String status=rs.getString("status");
             if(status.equalsIgnoreCase("approve")){
             request.getSession().setAttribute("customer_email",email);
             out.println("success");
             }
             else{
                 out.println("Your status is still pending Please verify your email first!!");
             }
         }
         else{
             out.println("login failed!!!!");
         }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

}
