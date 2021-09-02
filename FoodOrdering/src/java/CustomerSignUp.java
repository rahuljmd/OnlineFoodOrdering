import com.sun.mail.handlers.message_rfc822;
import java.io.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.*;
@MultipartConfig
public class CustomerSignUp extends HttpServlet{
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
            String otp=request.getParameter("otp");
            String pin=request.getParameter("pin");
            String sec_ques=request.getParameter("sec_ques");
            String sec_ans=request.getParameter("sec_ans");
            
            Part p1=request.getPart("photo");
            
            // variables to use later in code
            String relpath="myuploads";
            String abspath=getServletContext().getRealPath("/"+relpath);
            String new_file_name1=System.currentTimeMillis()+"-"+p1.getSubmittedFileName();
//            out.println(abspath+"<br>");
           
            
            
            ResultSet rs=Dbloader.executeSql("select * from customer where email_id='"+email+"'");
            if(rs.next()){
              out.println("Customer already added");
            }
            else{
                
                //Saving file on server(storage)...
                 String ans1=FileUploader.savefileonserver(p1, abspath,new_file_name1);
//                 out.println("File saved on server: "+ans1);
                 
                 //Insert data into database(MySql)...
                rs.moveToInsertRow();
                rs.updateString("full_name",name);
                rs.updateString("email_id",email);
                rs.updateString("city",city);
                rs.updateString("password",pass);
                rs.updateString("mobile",mobile);
                rs.updateString("address",address);
                rs.updateString("otp",otp);
                rs.updateString("status","pending");
                rs.updateString("security_question",sec_ques);
                rs.updateString("security_answer",sec_ans);
                rs.updateString("photo",relpath+"/"+new_file_name1);
                rs.insertRow();
                
                String msg = "";
                   
                msg +=  "<h1>Otp is "+otp+"</h1>";
                msg += "<br>";
                msg += "<br>";
                msg += "<h3>To verify Your Account Please Clck on Below Link</h3>";
                msg+= "<a href =\"http://localhost:8084/FoodOrdering/CustomerVerification.jsp?email="+email+"&otp="+otp+"\" >Click here To Verify Your Account</a>";
                
                
                msg += "<br>";
                msg += "<br>";
                msg += "This link and otp will expire in 10 mins";
                 msg += "<br>";
                msg += "<br>";
                System.out.println(""+msg);
                SimpleMailDemo s = new SimpleMailDemo(email, "Your Otp For User Signup",msg);
                out.println("SignUp successful!!");
            }
        }
        catch (Exception ex) {
            out.println(ex.toString());
        }
        
    }
}
