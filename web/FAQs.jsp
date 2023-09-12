<%-- 
    Document   : FAQs
    Created on : Jul 4, 2023, 3:26:24 PM
    Author     : VNHCMLAP-0074
--%>

<%@page import="basicobject.Items"%>
<%@page import="dbaccess.CategoriesDao"%>
<%@page import="basicobject.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body
        <!-- cho nay de tim kiem item thong qua cateid -->
        <%
            ArrayList<Categories> list1 = (ArrayList<Categories>) CategoriesDao.getAllCategories();
            ArrayList<Items> list2 = (ArrayList<Items>) request.getAttribute("categoryResult");
        %>  

        <form action="CategoriesServlet" method="post">
            <h1>Item to get FQAs: </h1>
            <h1>    <select multiple=""  name="category" required="">
                    <%for (Categories categories : list1) {%>
                    <option value="<%= categories.getId()%>"><%= categories.getName()%> </option>
                    <%}%>
                </select>
            </h1>
            <td><input type="submit" value="show" name="submit" ></td>
            <td><input type="submit" value="Back" onclick="history.back()"></td>
        </form


        <%   if (list2 != null && list2.size() > 0) { %>
        <!-- cho nay de xuat ket qua sau khi tim kiem-->
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>Category ID</th>
            </tr>           
                <% for (Items item : list2) {
                %>
            <tr>
            <form action='FAQsServlet' method='post'>
                <input type='hidden' value='<%= item.getId()%>' name='FAQs'>
                
                <td><%= item.getId()%></td>
                <td><%= item.getName()%></td>
                <td><%= item.getPrice()%></td>
                <td><%= item.getCateid()%></td>

                <td><input type='submit' value='FAQs' name='FAQs'></td>
                
            </form>     
            </tr>
        <% } %>
    </table>
    <%
        } else {
            out.print("no data");
        }
    %>
</body>
</html>
