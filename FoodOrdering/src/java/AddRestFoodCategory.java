import java.io.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.*;
@MultipartConfig
public class AddRestFoodCategory extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int rid=0;
        String email="";
        if(request.getSession().getAttribute("restaurant_email")==null){
           response.sendRedirect("RestaurantLogin.jsp");
        }
        else{
            email=(String)request.getSession().getAttribute("restaurant_email");
        }
        
        try {
            
            //extracting data from request...
            String name=request.getParameter("name");
            String desc=request.getParameter("desc");
            int s1=Integer.parseInt(request.getParameter("s1"));
            System.out.println(s1);
            
            Part p1=request.getPart("photo_wide");
            Part p2=request.getPart("photo_square");
            
            // variables to use later in code
            String relpath="myuploads";
            String abspath=getServletContext().getRealPath("/"+relpath);
            String new_file_name1=System.currentTimeMillis()+"-"+p1.getSubmittedFileName();
            String new_file_name2=System.currentTimeMillis()+"-"+p2.getSubmittedFileName();
//            out.println(abspath+"<br>");
       
            ResultSet rs1=Dbloader.executeSql("select * from restaurant where email_id='"+email+"'");
           if(rs1.next()){
               rid=rs1.getInt("restaurant_id");
               
            ResultSet rs=Dbloader.executeSql("select * from rest_food_category where restaurant_id='"+rid+"'and category_name='"+name+"'and cuisine_id='"+s1+"'");
            if(rs.next()){
              out.println("Category already added");
            }
            else{
                
                //Saving file on server(storage)...
                 String ans1=FileUploader.savefileonserver(p1, abspath,new_file_name1);
                 String ans2=FileUploader.savefileonserver(p2, abspath,new_file_name2);
//                 out.println("File saved on server: "+ans1);
                 
                 //Insert data into database(MySql)...
                rs.moveToInsertRow();
                rs.updateString("category_name",name);
                rs.updateInt("cuisine_id",s1);
                rs.updateInt("restaurant_id",rid);
                rs.updateString("category_description",desc);
                rs.updateString("photo_wide",relpath+"/"+new_file_name1);
                rs.updateString("photo_square",relpath+"/"+new_file_name2);
                rs.insertRow();
                
                String ans = "";
                  ResultSet rs_3 = Dbloader.executeSql("select * from restaurant_cuisines where restaurant_id="+rid+" and cuisine_id="+s1);
                if(rs_3.next()){
                    ans = "Mapping already exists";
                }else {
                    
                    rs_3.moveToInsertRow();
                    rs_3.updateInt("restaurant_id", rid);
                    rs_3.updateInt("cuisine_id", s1);
                    
                    
                    rs_3.insertRow();
                    ans = "mapping added";
                }
              
                
                
                
                out.println("Category added successfully!!");
//                out.println(ans);
                
            }
           }
        }
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
    }
}
