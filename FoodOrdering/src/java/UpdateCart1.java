import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class UpdateCart1 extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String email="";
        
        if(request.getSession().getAttribute("customer_email")==null){
              out.println("notlogin");
          }
        else{
         email=(String)request.getSession().getAttribute("customer_email");
        }
        try {
           
            int rid=Integer.parseInt(request.getParameter("rid"));
            int food_id=Integer.parseInt(request.getParameter("food_id"));
            System.out.println(""+rid);
            
      ResultSet rs=Dbloader.executeSql("select * from food_ordering.cart_details where restaurant_id='"+rid+"'and "
              + "food_id=\'"+food_id+"\'and email_id=\'"+email+"\'");
        if(rs.next()){
            int qty = rs.getInt("quantity");
            int amount = rs.getInt("amount");
            int price = rs.getInt("price");
                  
            
            
            qty = qty + 1;
            amount = price * qty;
            rs.moveToCurrentRow();
            rs.updateInt("quantity",qty);
            rs.updateInt("amount",amount);
            rs.updateRow();
            
            out.println(" Quantity updated successfully!!");
            }
        else{
            ResultSet rs_2=Dbloader.executeSql("select * from food_ordering.cart_details where "
              + "email_id=\'"+email+"\'"); 
            
            while(rs_2.next()){
                int new_rid = rs_2.getInt("restaurant_id");
                
                if(new_rid != rid){
                    rs_2.deleteRow();
                }
            }
            
            
            
            ResultSet rs2=Dbloader.executeSql("select * from food_ordering.food_items where food_id='"+food_id+"'");
            if(rs2.next()){
                 String item_name=rs2.getString("item_name");
        String item_description=rs2.getString("item_description");
        String photo = rs2.getString("photo");
        int price = rs2.getInt("offer_price");
        int offer_price = rs2.getInt("offer_price");
        int qty=1;
        int amount=offer_price;
        
        
        
        
        
        rs.moveToInsertRow();
        rs.updateString("photo", photo);
        rs.updateString("item_name",item_name);
        rs.updateString("email_id",email);
        rs.updateString("item_description",item_description);
        rs.updateInt("food_id",food_id);
        rs.updateInt("price",price);
        rs.updateInt("restaurant_id",rid);
        rs.updateInt("amount",amount);
        rs.updateInt("quantity",qty);
        rs.insertRow();
        
        out.println("Item added to cart");

            }
        }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
