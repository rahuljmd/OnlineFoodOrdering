import java.io.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.*;
@MultipartConfig
public class RestaurantSignUp extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            
            //extracting data from request...
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String city=request.getParameter("city");
            String pass=request.getParameter("pass");
            String mobile=request.getParameter("mobile");
            String address=request.getParameter("address");
            String location=request.getParameter("location");
            int min_del=Integer.parseInt(request.getParameter("min_del"));
            int del_charges=Integer.parseInt(request.getParameter("del_charges"));
            String start_time=request.getParameter("start_time");
            String end_time=request.getParameter("end_time");
            String comments=request.getParameter("comments");
            String desc=request.getParameter("desc");
            
            Part p1=request.getPart("photo_wide");
            Part p2=request.getPart("photo_square");
            
            // variables to use later in code
            String relpath="myuploads";
            String abspath=getServletContext().getRealPath("/"+relpath);
            String new_file_name1=System.currentTimeMillis()+"-"+p1.getSubmittedFileName();
            String new_file_name2=System.currentTimeMillis()+"-"+p2.getSubmittedFileName();
//            out.println(abspath+"<br>");
           
            
            
            ResultSet rs=Dbloader.executeSql("select * from restaurant where restaurant_name='"+name+"'");
            if(rs.next()){
              out.println("Restaurant already added");
            }
            else{
                
                //Saving file on server(storage)...
                 String ans1=FileUploader.savefileonserver(p1, abspath,new_file_name1);
                 String ans2=FileUploader.savefileonserver(p2, abspath,new_file_name2);
//                 out.println("File saved on server: "+ans1);
                 
                 //Insert data into database(MySql)...
                rs.moveToInsertRow();
                rs.updateString("restaurant_name",name);
                rs.updateString("email_id",email);
                rs.updateString("city",city);
                rs.updateString("password",pass);
                rs.updateString("mobile",mobile);
                rs.updateString("address",address);
                rs.updateString("status","pending");
                rs.updateInt("min_delivery",min_del);
                rs.updateInt("delivery_charges",del_charges);
                rs.updateString("delivery_start",start_time);
                rs.updateString("delivery_end",end_time);
                rs.updateString("description",desc);
                rs.updateString("photo_wide",relpath+"/"+new_file_name1);
                rs.updateString("photo_square",relpath+"/"+new_file_name2);
                rs.insertRow();
                out.println("SignUp successful!!");
            }
        }
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
    }
}
