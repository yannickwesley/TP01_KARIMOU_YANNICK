/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbds.esatic_abidjan;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kykwy
 */
public class TestHttpServlet extends HttpServlet {

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
        InetAddress Ip = InetAddress.getLocalHost();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestHttpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>Ma première servlet</center></h1>");
    
            out.println("<h2>Information concernant l'adresse IP et le navigateur utilisé par le client :</h2>");
            out.println("<br/>");
            out.println("<p>Adresse IP du client : " + Ip.getHostAddress() +"</p>");
            out.println("<p>Navigateur du client : " + request.getHeader("User-Agent") +"</p>");
          
            out.println("<h2>Information concernant la requête du client :</h2>");
           
            out.println("<p>Méthode : "+ request.getMethod() +"</p>");
            out.println("<p>Protocole : "+ request.getProtocol() +"</p>");
            //out.println("<p>uri demandée : "+  +"</p>");
           
            out.println("<h2>Information concernant l'entête de la requête :</h2>");
          
            out.println("<p>host : "+ request.getServerName()+":"+ request.getServerPort()+"</p>");
            out.println("<p>user-agent : "+ request.getHeader("User-Agent") +"</p>");
            out.println("<p>accept : " + request.getHeader("Accept") +"</p>");
            out.println("<p>accept-language : "+ request.getHeader("Accept-Language") +"</p>");
            out.println("<p>accept-encoding : "+ request.getHeader("Accept-Encoding") +"</p>");
            out.println("<p>accept-charset : "+ request.getHeader("Accept-Charset") +"</p>");
            out.println("<p>keep-alive :"+ request.getHeader("Keep-Alive") +"</p>");
            out.println("<p>connection :"+ request.getHeader("Connection") +"</p>");
            out.println("</body>");
            out.println("</html>");
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
