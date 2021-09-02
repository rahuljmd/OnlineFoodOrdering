<%
    session.removeAttribute("admin_username");
    response.sendRedirect("adminlogin.jsp");
    

%>