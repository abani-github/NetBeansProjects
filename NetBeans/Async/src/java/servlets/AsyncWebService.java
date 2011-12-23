/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

//import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;

/**
 *
 * @author beheraab
 */
public class AsyncWebService implements Runnable {

    AsyncContext ctx;
    private RequestDispatcher rd;
    public AsyncWebService(AsyncContext ctx) {
        this.ctx = ctx;
        rd = ctx.getRequest().getRequestDispatcher("/index.jsp");
    }

    @Override
    public void run() {
//        try {
                    try {
                        for (int i =0; i < 4; i++){
                            Thread.sleep(2000);
                            ctx.getResponse().getWriter().print("<br/> message " + i);
                            ctx.getResponse().getWriter().flush();
                        }
                       // ctx.dispatch("/index.jsp");;
                    } catch (Exception ex) {
                        Logger.getLogger(AsyncWebService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.ctx.complete();
//                    rd.forward(ctx.getRequest(), ctx.getResponse());
//                    this.ctx.dispatch("/index.jsp");
//        } catch (ServletException ex) {
//            Logger.getLogger(AsyncWebService.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(AsyncWebService.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
