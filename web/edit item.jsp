<%-- 
    Document   : edit
    Created on : Jul 4, 2023, 5:23:54 PM
    Author     : VNHCMLAP-0074
--%>
<%@page import="dbaccess.CategoriesDao"%>
<%@page import="basicobject.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="basicobject.Items"%>
<%@page import="dbaccess.ItemsDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Categories> list = (ArrayList<Categories>) CategoriesDao.getAllCategories();
            String id = request.getParameter("txtItemid");

        %>  


        <form action="EditServlet" method="post">
            <input type="hidden"value='<%=id%>' name ='id' >

            <h1>ID:<%=id%> </h1>
            <h1>Name:   <input type="text" name="name" required="" placeholder="Type here if you need edit"></h1>
            <h1>Price:  <input type="text" name="price" required="" placeholder="Type here if you need edit"></h1>
            <h1>Category: </h1>
            <h1>    <select multiple=""  name="category" required="">
                    <%for (Categories categories : list) {%>
                    <option value="<%= categories.getId()%>"><%= categories.getName()%> </option>
                    <%}%>
                </select>
            </h1>
            <td><input type="submit" value="Save" name="submit" ></td>
            <td><input type="submit" value="Back" onclick="history.back()"></td>
        </form>
    </body>
</html>
