import java.io.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.*;
@MultipartConfig
public class AddCuisines extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            
            //extracting data from request...
            String cuisine_name=request.getParameter("cuisine_name");
            String description=request.getParameter("description");
            
            Part p1=request.getPart("f1");
            
            // variables to use later in code
            String relpath="myuploads";
            String abspath=getServletContext().getRealPath("/"+relpath);
            String new_file_name=System.currentTimeMillis()+"-"+p1.getSubmittedFileName();
//            out.println(abspath+"<br>");
           
            
            
            ResultSet rs=Dbloader.executeSql("select * from cuisines where cuisine_name='"+cuisine_name+"'");
            if(rs.next()){
              out.println("Cuisine already added");
            }
            else{
                
                //Saving file on server(storage)...
                 String ans1=FileUploader.savefileonserver(p1, abspath,new_file_name);
//                 out.println("File saved on server: "+ans1);
                 
                 //Insert data into database(MySql)...
                rs.moveToInsertRow();
                rs.updateString("cuisine_name",cuisine_name);
                rs.updateString("description",description);
                rs.updateString("photo",relpath+"/"+new_file_name);
                rs.insertRow();
                out.println("Cuisine added successfully");
            }
        }
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
    }
}
