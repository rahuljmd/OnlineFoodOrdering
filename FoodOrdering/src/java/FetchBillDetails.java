import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class FetchBillDetails extends HttpServlet {
   
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
            int bill_id=Integer.parseInt(request.getParameter("bill_id"));
            
            String jsondata=new RDBMS_TO_JSON().generateJSON("select * from bill_details where bill_id='"+bill_id+"'");
            out.println(jsondata);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
