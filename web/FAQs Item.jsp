<%-- 
    Document   : FQAs Item
    Created on : Jul 7, 2023, 10:07:42 AM
    Author     : VNHCMLAP-0074
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="basicobject.FAQs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<FAQs> list = (ArrayList<FAQs>) request.getAttribute("fAQsResult");
        %>  


        <%   if (list != null && list.size() > 0) { %>
        <h1>abcxyz</h1>
        <table cellspacing="12" cellpadding="6" style="text-align: center; width: 100%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Content</th>
                    <th>Item ID</th>
                </tr>
            </thead>
            <tbody>
                <%  for (FAQs faqs : list) {%>
            <form>
                <tr>
                    <td><%= faqs.getId()%></td>
                    <td><%= faqs.getName()%></td>
                    <td><%= faqs.getContent()%></td>
                    <td><%= faqs.getItemId()%></td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        } else {
            out.print("no data");
        }
    %>
    <h1></h1>

</body>
</html>
