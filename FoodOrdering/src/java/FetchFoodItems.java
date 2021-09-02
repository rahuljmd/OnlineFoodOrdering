import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class FetchFoodItems extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        String email="";
        int rid=0;
        if(request.getSession().getAttribute("restaurant_email")==null){
              response.sendRedirect("RestaurantLogin.jsp");
          }
        else{
         email=(String)request.getSession().getAttribute("restaurant_email");
         rid=(int)request.getSession().getAttribute("rid");
        }
       
        try {
                        
            String jsondata=new RDBMS_TO_JSON().generateJSON("select * from food_items inner join rest_food_category on food_items.rest_cat_id=rest_food_category.rest_cat_id where rest_id='"+rid+"' order by category_name");
            out.println(jsondata);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
