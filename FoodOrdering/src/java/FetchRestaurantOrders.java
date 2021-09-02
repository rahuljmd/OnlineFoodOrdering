import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class FetchRestaurantOrders extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        String email="";
//        int rid=0;
        if(request.getSession().getAttribute("restaurant_email")==null){
              response.sendRedirect("RestaurantLogin.jsp");
          }
        else{
         email=(String)request.getSession().getAttribute("restaurant_email");
        }
       
        try {
//           ResultSet rs=Dbloader.executeSql("select * from restaurant where email_id='"+email+"'");
//   if(rs.next()){
//        rid=rs.getInt("restaurant_id");
//   }
            
            String jsondata=new RDBMS_TO_JSON().generateJSON("select * from bill inner join restaurant on restaurant.restaurant_id=bill.rest_id where restaurant.email_id='"+email+"'"+"order by bill.bill_id desc");
            out.println(jsondata);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
