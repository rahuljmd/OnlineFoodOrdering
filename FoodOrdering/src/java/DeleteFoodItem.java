import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class DeleteFoodItem extends HttpServlet {
   
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
            
            int food_id=Integer.parseInt(request.getParameter("food_id"));
//            out.println(name+"------ok tested");
            
            ResultSet rs1=Dbloader.executeSql("select * from food_items where food_id='"+food_id+"'");
            if(rs1.next()){
                rs1.deleteRow();
                out.println("Food Item removed successfully");
            }
            else{
                out.println("No such food item!!");
            }
            
        } 
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
