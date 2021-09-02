import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class ChangeBillStatus extends HttpServlet {
   
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
            int bill_id=Integer.parseInt(request.getParameter("bill_id"));
            String option=request.getParameter("option");
            
            ResultSet rs=Dbloader.executeSql("select * from bill where bill_id='"+bill_id+"'");
            if(rs.next()){
                if(option.equalsIgnoreCase("delivered")){
                    rs.moveToCurrentRow();
                    rs.updateString("status","delivered");
                    rs.updateRow();
                    out.println("Status changed successfully!!");
                }
                else{
                    rs.moveToCurrentRow();
                    rs.updateString("status", "cooking");
                    rs.updateRow();
                    out.println("Status changed successfully!!");
                }
            }
     
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
