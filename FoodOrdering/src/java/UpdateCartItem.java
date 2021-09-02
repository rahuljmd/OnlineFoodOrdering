import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class UpdateCartItem extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try {
           
            int id=Integer.parseInt(request.getParameter("id"));
            String res=request.getParameter("res");
    ResultSet rs=Dbloader.executeSql("select * from food_ordering.cart_details where cart_detail_id='"+id+"'");
        if(rs.next()){
            int qty=rs.getInt("quantity");
            int amt=rs.getInt("amount");
            int price=rs.getInt("price");
            if(res.equalsIgnoreCase("add")){
                qty=qty+1;
                amt=price*qty;
                rs.moveToCurrentRow();
                rs.updateInt("quantity",qty);
                rs.updateInt("amount",amt);
                rs.updateRow();
                
                out.println("Item updated successfully!!");

            }else{
                if(qty==0){
                    rs.deleteRow();
                     return;
                }
                qty=qty-1;
                amt=price*qty;
                rs.moveToCurrentRow();
                rs.updateInt("quantity",qty);
                rs.updateInt("amount",amt);
                rs.updateRow();
                
                out.println("Item updated successfully!!");

            }
            }
           
        }
      
        
          catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
