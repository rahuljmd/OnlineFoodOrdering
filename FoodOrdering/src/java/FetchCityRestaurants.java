import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class FetchCityRestaurants extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        
        String selection=request.getParameter("selection");
        
        try {
            String jsondata=new RDBMS_TO_JSON().generateJSON("select * from food_ordering.restaurant "
                    + "where status='approve' and city='"+selection+"'");
            out.println(jsondata);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
