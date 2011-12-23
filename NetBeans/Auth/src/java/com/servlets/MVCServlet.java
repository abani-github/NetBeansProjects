/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.auth.ejbs.ShoppingCartBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author beheraab
 */
@WebServlet(name = "MVCServlet", urlPatterns = {"/mvc/*"})
public class MVCServlet extends HttpServlet {
    private @EJB ShoppingCartBean cart;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String pathInfo = request.getPathInfo();
        System.out.println("pathInfo " + pathInfo);
        String opertation = pathInfo.substring(1, pathInfo.length());
        System.out.println("opertation " + opertation);
        if (null != opertation && opertation.endsWith(".jsp")){
            if ("buy".equalsIgnoreCase(opertation)) {
                addItem(request, response);
            }
            if ("checkout".equalsIgnoreCase(opertation)) {
                processCheckout(request, response);
            }
            if ("listall".equalsIgnoreCase(opertation)) {
                 showReview(request, response);
            }
      
        }else {
            RequestDispatcher rd = request.getRequestDispatcher(pathInfo);
        rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String product = request.getParameter("product");
        String qty = request.getParameter("quantity");
        int quantity = 0 ;
        if ( null != qty) {
            quantity = Integer.parseInt(qty);
        }
        System.out.println("product " + product);
        System.out.println("quantity " + quantity);
        cart.buy(product, quantity);
        Map<String, Integer> prodMap = cart.getCartContents();
        System.out.println("prodMap " + prodMap);
        
        request.setAttribute("prodMap", prodMap);
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }

    private void processCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cart.checkout();
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }

    private void showReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Integer> prodMap = cart.getCartContents();
        System.out.println("prodMap " + prodMap);
        request.setAttribute("prodMap", prodMap);
        RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
        rd.forward(request, response);
    }
}
