import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;

public class adminlogin extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       try{
           String user=request.getParameter("username");
//           out.println(user);
           String pass=request.getParameter("password");
//           out.println(pass);
           ResultSet rs=Dbloader.executeSql("Select * from food_ordering.admin where username='"+user+"'and password='"+pass+"'");
         if(rs.next()){
             
             request.getSession().setAttribute("admin_username", user);
             out.println("success");
         }
         else{
             out.println("login failed!!!!");
         }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

}
