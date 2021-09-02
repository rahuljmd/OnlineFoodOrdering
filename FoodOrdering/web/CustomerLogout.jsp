<%
    session.removeAttribute("customer_email");
    response.sendRedirect("CustomerLogin.jsp");
    %>