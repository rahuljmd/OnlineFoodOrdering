import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class ChangeStatus extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try {
           
            int rid=Integer.parseInt(request.getParameter("rid"));
    
    ResultSet rs=Dbloader.executeSql("select * from food_ordering.restaurant where restaurant_id='"+rid+"'");
        if(rs.next()){
            String stat=rs.getString("status");
            if(stat.equalsIgnoreCase("pending")){
            rs.moveToCurrentRow();
            rs.updateString("status", "approve");
            rs.updateRow();
            }
            else if(stat.equalsIgnoreCase("approve")){
                rs.moveToCurrentRow();
            rs.updateString("status", "pending");
            rs.updateRow(); 
            }
        }
        else{
            out.println("No such row");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
