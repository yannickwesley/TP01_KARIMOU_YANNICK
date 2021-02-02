/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbds.esatic_abidjan;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kykwy
 */
public class EtudiantsServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sauvegarder des étudiants</h1>");
            out.println("<FORM Method='POST' Action='etudiants'>");
            out.println("Nom : 		<INPUT type=text size=40 name='nom'><BR/><BR/>");
            out.println("Prénom : 	<INPUT type=text size=40 name='prenom'><BR/><BR/>");
            out.println("Email :        <INPUT type=text size=40 name='email'><BR/><BR/>");
            out.println("<INPUT type=submit value=Envoyer>");
            out.println("</FORM>");
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
     //   processRequest(request, response);
     String Comma_delimiter=",";
     String new_line_separator="\n";
     String file_header = "nom,prenom,email";
     String nom= request.getParameter("nom");
     String prenom = request.getParameter("prenom");
     String email = request.getParameter("email");
     FileWriter filewritter= new FileWriter("C:\\Users\\kykwy\\Dropbox\\Mon PC (DESKTOP-0HQ9HSH)\\Documents\\etudiants.csv",false);
     filewritter.append(file_header);
     filewritter.append(new_line_separator);
     filewritter.append(nom);
     filewritter.append(Comma_delimiter);
     filewritter.append(prenom);
     filewritter.append(Comma_delimiter);
     filewritter.append(email);
     filewritter.append(Comma_delimiter);
     filewritter.flush();
     filewritter.close();
     PrintWriter out = response.getWriter();
     out.println("l'utilisateur "+nom+" a bien été enregistré");
     out.println("reussi");
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
