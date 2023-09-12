<%-- 
    Document   : item
    Created on : Jul 4, 2023, 3:26:07 PM
    Author     : VNHCMLAP-0074
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="basicobject.Items"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            ArrayList<Items> list = (ArrayList<Items>) request.getAttribute("Itemresult");
        %>  
        <h1></h1>
        <table cellspacing="12" cellpadding="6" style="text-align: center; width: 100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%  for (Items items : list) {%>
            <form action='edit item.jsp' method='post'>
                <input type='hidden' value='<%= items.getId()%>' name ='txtItemid'>
                <tr>
                    <td><%= items.getId()%></td>
                    <td><%= items.getName()%></td>
                    <!--<td><%= items.getPrice()%></td>-->
                    <!--<td><%= items.getCateid()%></td>-->
                    
                    <td><input type='submit' value = 'Edit' name=''></td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>
