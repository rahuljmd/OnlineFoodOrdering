import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class DeleteCuisine extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/text");
        PrintWriter out=response.getWriter();
//        String email="";
//        
//        if(request.getSession().getAttribute("customer_email")==null){
//              response.sendRedirect("CustomerLogin.jsp");
//          }
//        else{
//         email=(String)request.getSession().getAttribute("customer_email");
//        }
       
        try {
            String name=request.getParameter("cuisine_name");
            out.println(name+"------ok tested");
            ResultSet rs=Dbloader.executeSql("select * from cuisines where cuisine_name='"+name+"'");
            if(rs.next()){
                rs.deleteRow();
                out.println("Cuisine removed successfully");
            }
            else{
                out.println("No such cuisine");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
