import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class ViewCart extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        String email="";
        
        if(request.getSession().getAttribute("customer_email")==null){
              response.sendRedirect("CustomerLogin.jsp");
          }
        else{
         email=(String)request.getSession().getAttribute("customer_email");
        }
       
        try {
            String jsondata=new RDBMS_TO_JSON().generateJSON("SELECT * FROM cart_details inner join restaurant on cart_details.restaurant_id=restaurant.restaurant_id where cart_details.email_id='"+email+"'");
            out.println(jsondata);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
