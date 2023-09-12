/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import basicobject.Items;
import basicobject.Items;
import dbaccess.CategoriesDao;
import dbaccess.ItemsDao;
import dbaccess.ItemsDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VNHCMLAP-0074
 */
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String Cateid = request.getParameter("category");

            Items item = new Items(id, name, Double.parseDouble(price), Cateid);
            ItemsDao.updateItem(id, item);

//            response.sendRedirect("");
            request.getRequestDispatcher("MainServlet?action=1").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        try {
//            String id = request.getParameter("id");
//            Items itemUpdate = ItemsDao.getItemById(id);
//            request.setAttribute("itemUpdate", itemUpdate);
//            request.getRequestDispatcher("MainController?action=5").forward(request, response);
//        } catch (Exception ex) {
//            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        try {
//            
//            String id = request.getParameter("id");
//            String name = request.getParameter("name");
//            String price = request.getParameter("price");
//            String cateId = request.getParameter("Itemresult");
//            
//            Items item = new Items(id, name, Double.parseDouble(price), cateId);
//            ItemsDao.UpdateItems2(item);
//
////          response.sendRedirect("Items.jsp");
//            request.getRequestDispatcher("MainController?action=1").forward(request, response);
//        } catch (Exception ex) {
//            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
