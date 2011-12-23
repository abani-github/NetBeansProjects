/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author beheraab
 */
@WebServlet(name = "MailServlet", urlPatterns = {"/MailServlet"})
public class MailServlet extends HttpServlet {
    private @Resource(mappedName= "mail/james") Session session;
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
        Message msg  = new MimeMessage(session);
        StringBuilder sb = new StringBuilder();
        sb.append("<b>Hallo Kunal </b> This is a sample mail ");
        sb.append("<a href='http://google.co.in'>Click Here</a> to login in Gmail Account");
        PrintWriter out = response.getWriter();
        try {
                msg.setSubject("A sample HTML Mail");
                
                msg.setContent(sb.toString(), "text/html");
                msg.setFrom(new InternetAddress("abani@arb.jms.ml"));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress("kunal@arb.jms.ml"));
                Transport.send(msg);
                
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MailServlet</title>");  
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet MailServlet at message sent</h1>");
                out.println("</body>");
                out.println("</html>");
                
            } catch (MessagingException ex) {
                Logger.getLogger(MailServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
         finally {            
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
