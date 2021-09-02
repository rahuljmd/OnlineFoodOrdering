import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class DeleteCartItem extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try {
           
            int id=Integer.parseInt(request.getParameter("id"));
    
    ResultSet rs=Dbloader.executeSql("select * from food_ordering.cart_details where cart_detail_id='"+id+"'");
        if(rs.next()){
            
            rs.deleteRow();
            out.println("Item deleted successfully!!");
            }
           
        }
      
        
          catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
