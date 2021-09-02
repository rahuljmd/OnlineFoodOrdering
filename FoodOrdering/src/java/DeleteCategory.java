import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class DeleteCategory extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/text");
        PrintWriter out=response.getWriter();
        String email="";
        
        if(request.getSession().getAttribute("restaurant_email")==null){
              response.sendRedirect("RestaurantLogin.jsp");
          }
        else{
         email=(String)request.getSession().getAttribute("restaurant_email");
        }
       
        try {
            
            ResultSet rs=Dbloader.executeSql("select * from restaurant where email_id='"+email+"'");
            if(rs.next()){
                int rid=rs.getInt("restaurant_id");
            
            String name=request.getParameter("category_name");
            int s1=Integer.parseInt(request.getParameter("s1"));
//            out.println(name+"------ok tested");
            
            ResultSet rs1=Dbloader.executeSql("select * from rest_food_category where category_name='"+name+"' and restaurant_id='"+rid+"' and cuisine_id='"+s1+"'");
            if(rs1.next()){
                rs1.deleteRow();
                out.println("Category removed successfully");
            }
            else{
                out.println("No such category!!");
            }
            
            
        } 
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
