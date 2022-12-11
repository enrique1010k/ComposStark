<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection con = null;
            Statement st = null;
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                            + "BDComposStark3?user=root&password=1010Kaekd");
                        st = con.createStatement();
                        // st.executeUpdate("DELETE FROM T_Producto where idpro='"+request.getParameter("txtid")+"' ;");
                        st.executeUpdate("UPDATE T_Cliente set estcli = 0 where idcli='"+request.getParameter("txtid")+"' ;");
                        request.getRequestDispatcher("listaclientes.jsp").forward(request, response);

        %>
    </body>
</html>
