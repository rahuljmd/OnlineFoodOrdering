import java.io.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.Dbloader;
import vmm.RDBMS_TO_JSON;
import vmm.SimpleMailDemo;

public class SaveBill extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String email="";
        
        if(request.getSession().getAttribute("customer_email")==null){
              response.sendRedirect("CustomerLogin.jsp");
          }
        else{
         email=(String)request.getSession().getAttribute("customer_email");
        }
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss z");
//Date date = new Date(System.currentTimeMillis());
//System.out.println(formatter.format(date));
//    String s=formatter.format(date);
        try {
           
            int rest_id=Integer.parseInt(request.getParameter("rest_id"));
            int subtotal=Integer.parseInt(request.getParameter("subtotal"));
            int tax=Integer.parseInt(request.getParameter("tax"));
            int del_charges=Integer.parseInt(request.getParameter("del_charges"));
            int discount=Integer.parseInt(request.getParameter("discount"));
            int total=Integer.parseInt(request.getParameter("total"));
            String option=request.getParameter("option");
    ResultSet rs=Dbloader.executeSql("select * from bill");
         
            rs.moveToInsertRow();
           rs.updateInt("rest_id",rest_id);
           rs.updateInt("subtotal",subtotal);
           rs.updateInt("delivery_charges",del_charges);
           rs.updateInt("tax(%)",tax);
           rs.updateInt("discount",discount);
           rs.updateInt("total",total);
           rs.updateString("payment_method",option);
           
           //code to insert current date time in database
           Date d=new Date();
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String current_date_time=sdf.format(d);
           System.out.println("-----"+current_date_time);
           
           SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
           String current_date=sdf2.format(d);
           System.out.println(current_date);
      
      
            
           
            rs.updateString("date",current_date);
            rs.updateString("date_time_of_bill",current_date_time);
           rs.updateString("status","confirmed");
           rs.updateString("customer_email",email);
//           rs.updateString("date_time_of_bill","2019-02-27 17:18:17");
           rs.insertRow();
           
           ResultSet rs2=Dbloader.executeSql("select max(bill_id) as bill_id from bill;");
           if(rs2.next()){
                int bill_id=rs2.getInt("bill_id");
                System.out.println(bill_id);
              
                ResultSet rs3=Dbloader.executeSql("select * from cart_details where email_id='"+email+"'");
              while(rs3.next()){
                  int food_id=rs3.getInt("food_id");
                  int price=rs3.getInt("price");
                  int quantity=rs3.getInt("quantity");
                  int amount=rs3.getInt("amount");
                  String item_name =rs3.getString("item_name");
                  
           ResultSet rs4=Dbloader.executeSql("select * from bill_details");       
                  rs4.moveToInsertRow();
                  rs4.updateInt("bill_id",bill_id);
                  rs4.updateInt("food_id",food_id);
                  rs4.updateInt("price",price);
                  rs4.updateInt("quantity",quantity);
                  rs4.updateInt("amount",amount);
                  rs4.updateString("item_name",item_name);
                  rs4.insertRow();
                  
                  rs3.deleteRow();
              }
           }
           SimpleMailDemo obj = new SimpleMailDemo(email, "Order status","Your Order has been placed successfully!!");
           out.println("success");

//           out.println("Mail sent successfully!!");
        
        }catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

}
