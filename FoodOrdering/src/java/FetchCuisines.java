import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class FetchCuisines extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");
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
            
            String jsondata=new RDBMS_TO_JSON().generateJSON("select * from cuisines");
            out.println(jsondata);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
