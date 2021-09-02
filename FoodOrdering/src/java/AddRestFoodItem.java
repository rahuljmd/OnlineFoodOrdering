import java.io.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.*;
@MultipartConfig
public class AddRestFoodItem extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        int rid=0;
        String email="";
        if(request.getSession().getAttribute("restaurant_email")==null){
           response.sendRedirect("RestaurantLogin.jsp");
        }
        else{
            email=(String)request.getSession().getAttribute("restaurant_email");
        }
        int rid=(int)request.getSession().getAttribute("rid");
        
        try {
            
            //extracting data from request...
            String name=request.getParameter("name");
            String desc=request.getParameter("desc");
            int price=Integer.parseInt(request.getParameter("price"));
            int offer_price=Integer.parseInt(request.getParameter("offer_price"));
            int rest_cat_id=Integer.parseInt(request.getParameter("s1"));
            System.out.println(rest_cat_id);
            
            Part p1=request.getPart("photo");
            
            // variables to use later in code
            String relpath="myuploads";
            String abspath=getServletContext().getRealPath("/"+relpath);
            String new_file_name1=System.currentTimeMillis()+"-"+p1.getSubmittedFileName();
//            out.println(abspath+"<br>");
       
               
            ResultSet rs=Dbloader.executeSql("select * from food_items where rest_id='"+rid+"'and item_name='"+name+"'and rest_cat_id='"+rest_cat_id+"'");
            if(rs.next()){
              out.println("Food Item already added");
            }
            else{
                
                //Saving file on server(storage)...
                 String ans1=FileUploader.savefileonserver(p1, abspath,new_file_name1);
//                 out.println("File saved on server: "+ans1);
                 
                 //Insert data into database(MySql)...
                rs.moveToInsertRow();
                rs.updateString("item_name",name);
                rs.updateInt("price",price);
                rs.updateInt("offer_price",offer_price);
                rs.updateInt("rest_cat_id",rest_cat_id);
                rs.updateInt("rest_id",rid);
                rs.updateString("item_description",desc);
                rs.updateString("photo",relpath+"/"+new_file_name1);
                rs.insertRow();
                out.println("Food Item added successfully!!");
            }
           
        }
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
    }
}
