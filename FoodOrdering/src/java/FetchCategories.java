import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class FetchCategories extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");
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
            
            String jsondata=new RDBMS_TO_JSON().generateJSON("select * from rest_food_category inner join cuisines on cuisines.cuisine_id=rest_food_category.cuisine_id where restaurant_id='"+rid+"' order by cuisine_name");
            out.println(jsondata);
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
