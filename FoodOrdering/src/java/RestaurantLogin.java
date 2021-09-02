import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;

public class RestaurantLogin extends HttpServlet {
   
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
           ResultSet rs=Dbloader.executeSql("Select * from food_ordering.restaurant where email_id='"+email+"'and password='"+pass+"'");
         if(rs.next()){
             
             String status = rs.getString("status");
             if(status.equals("pending")){
                out.println("Your Status Is still Pending please contact to admin!!");
             }
             else {
                request.getSession().setAttribute("restaurant_email",email);
             request.getSession().setAttribute("rid",rs.getInt("restaurant_id"));
             out.println("success");   
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
