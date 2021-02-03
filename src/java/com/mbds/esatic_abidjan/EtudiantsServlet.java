/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbds.esatic_abidjan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
            String line="";
     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>Liste des étudiants</center></h1>");
            out.println("<table style='border: 1px solid #333;'>");
            out.println("<tr style='border: 1px solid #333;'>");
            out.println("<td style='border: 1px solid #333;'>           <FORM Method='GET' Action='formetudiant.html'>\n" +
 
"            <INPUT type=submit value=Ajouter >\n" +
"            </FORM></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br/>");
            out.println("<table border='1px'>");
            out.println("<tr>");
            out.println("<th>Nom</th>");
            out.println("<th>Prenom</th>");
            out.println("<th>Email</th>");
            out.println("</tr>");
               try{
        BufferedReader br = new BufferedReader(new FileReader("etudiants.csv"));
        while((line = br.readLine()) != null){
            String[] donne = line.split(",");
            out.println("<tr>");
            out.println("<td>"+donne[0]+"</td>");
            out.println("<td>"+donne[1]+"</td>");
            out.println("<td>"+donne[2]+"</td>");
            out.println("</tr>");
        }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
            out.println("<table>");
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
     FileWriter fw= new FileWriter("etudiants.csv",true);
    // filewritter.append(file_header);
     
     fw.append(nom);
     fw.append(Comma_delimiter);
     fw.append(prenom);
     fw.append(Comma_delimiter);
     fw.append(email);
     fw.append(Comma_delimiter);
     fw.append(new_line_separator);
     fw.flush();
     fw.close();
     PrintWriter out = response.getWriter();
     out.println("l'utilisateur "+nom+" a bien été enregistré");
     out.println("reussi");
     doGet(request,response);
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
