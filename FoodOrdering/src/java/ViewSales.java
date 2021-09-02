import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class ViewSales extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        String email="";
        int rid=0;
        if(request.getSession().getAttribute("rid")==null){
            response.sendRedirect("RestaurantLogin.jsp");
        }
        else{
           email=(String)request.getSession().getAttribute("restaurant_email");
           rid=(int)request.getSession().getAttribute("rid");
            System.out.println(rid+"yeh hai rid");
        }
        try {
            String start=request.getParameter("start");
            String end=request.getParameter("end");
            System.out.println(start+"-------start date");
//            end=end+" 23:59:59";
            System.out.println(end+"------end date");

//    String jsondata=new RDBMS_TO_JSON().generateJSON("select date_time_of_bill, sum(total) as amount from bill where rest_id='"+rid+"' and date_time_of_bill between'"+start+"' and '"+end+"'");
//  String jsondata = new RDBMS_TO_JSON().generateJSON("SELECT date_time_of_bill, sum(total) as amount from  bill  where  rest_id = " + rid + " and date_time_of_bill between '" + start + "' and '" + end + "'   group by date_time_of_bill order by date_time_of_bill");
  String jsondata = new RDBMS_TO_JSON().generateJSON("SELECT date, sum(total) as amount from  bill  where  rest_id = " + rid + " and date between '" + start + "' and '" + end + "'   group by date order by date");
                      
out.println(jsondata);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
