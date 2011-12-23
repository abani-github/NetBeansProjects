/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springjsf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author beheraab
 */
@WebServlet(name = "AsyncServlet", urlPatterns = {"/AsyncServlet"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Early response");
       // out.flush();
        final AsyncContext ctx = request.startAsync();
        ctx.setTimeout(30000);
        ctx.addListener(new AsyncListener() {

            public void onComplete(AsyncEvent event) throws IOException {
                log("onComplete called");
            }

            public void onTimeout(AsyncEvent event) throws IOException {
                log("onTimeout called");
            }

            public void onError(AsyncEvent event) throws IOException {
                log("onError called");
            }

            public void onStartAsync(AsyncEvent event) throws IOException {
                log("onStartAsync called");
            }
        });
        ctx.start(new Runnable() {
            public void run() {
                try {
                    java.lang.Thread.sleep(5000);
                    ctx.getResponse().getWriter().write("Late response");
                } catch (Exception e) {
                    log("Problem processing task", e);
                }
                ctx.complete();
            }
        });

        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsyncServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsyncServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
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
}
