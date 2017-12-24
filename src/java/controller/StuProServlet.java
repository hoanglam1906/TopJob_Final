/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Account;
import business.Student;
import data.StuProDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thinh Phung
 */
public class StuProServlet extends HttpServlet {

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
        String url = "/Student.jsp";
        String action = request.getParameter("action");
        if (action.equals("ok")) {
            HttpSession session = request.getSession();
            String name = request.getParameter("name");
            String school = request.getParameter("school");
            String skill[]=request.getParameterValues("skill");
            int skill1=0,skill2=0,skill3=0;
            for(int i=0;i<skill.length;i++){
                if(skill[i].equals("skill1"))
                    skill1=1;
                if(skill[i].equals("skill2"))
                    skill2=1;
                if(skill[i].equals("skill3"))
                    skill3=1;
            }
            Student student=new Student((Account) session.getAttribute("account"), name, school, skill1, skill2, skill3);
            session.setAttribute("student", student);
            try {
                StuProDAO dao=new StuProDAO();
                dao.changeProfile(student);
            } catch (SQLException ex) {
                Logger.getLogger(StuProServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StuProServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            
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
