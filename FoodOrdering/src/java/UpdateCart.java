import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;

public class UpdateCart extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try {
           
            int rid=Integer.parseInt(request.getParameter("rid"));
            int food_id=Integer.parseInt(request.getParameter("food_id"));
            
        ArrayList <CartDetails>al=new ArrayList<>();
      ResultSet rs=Dbloader.executeSql("select * from food_ordering.food_items where rest_id='"+rid+"'and food_id=\'"+food_id+"\'");
        if(rs.next()){
        String item_name=rs.getString("item_name");
        String item_description=rs.getString("item_description");
        String photo = rs.getString("photo");
        int price = rs.getInt("price");
        int offer_price = rs.getInt("offer_price");
        int qty=1;
        int amount=price;
        boolean flag=false;
        if(request.getSession().getAttribute("al")!=null){
            al=(ArrayList)request.getSession().getAttribute("al");
        }
            for(int i=0;i<al.size();i++){
                CartDetails obj=al.get(i);
                if(obj.food_id==food_id){
                    obj.qty=qty+1;
                    obj.amount=price*obj.qty;
                    flag=true;
                    out.println("success again!!");

                }
            }
        if(flag==false){
            CartDetails obj=new CartDetails(item_name,item_description,photo,food_id
            ,price,offer_price,amount,qty);
            al.add(obj);
            request.getSession().setAttribute("al", al);
            out.println("success");
        }
            }
        out.println(al);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
