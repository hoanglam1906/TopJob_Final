/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Account;
import business.Employer;
import business.Job;
import business.Student;
import business.Utility;
import data.AccountDAO;
import data.EmProDAO;
import data.JobDAO;
import data.StuProDAO;
import data.SuccessDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thinh Phung
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String url = "/Login.html";
        String action = request.getParameter("action");

        if (action.equals("check")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String chk = request.getParameter("chkRemember");
            Account account = new Account(email, password);
            try {

                AccountDAO dao = new AccountDAO();
                if (dao.checkLogin(account).equals("false")) {

                } else {
                    Cookie em = new Cookie("em", account.getEmail());
                    Cookie pa = new Cookie("pa", account.getPassword());

                    if (chk == null) {
                        em.setMaxAge(0);
                        pa.setMaxAge(0);
                    } else {
                        em.setMaxAge(60 * 60 * 24);
                        pa.setMaxAge(60 * 60 * 24);
                    }

                    response.addCookie(pa);
                    response.addCookie(em);

                    HttpSession session = request.getSession();
                    session.setAttribute("account", account);

                    if (dao.checkLogin(account).equals("student")) {
                        url = "/Student.jsp";
                        StuProDAO sDao = new StuProDAO();
                        Student student = sDao.getProfile(account);
//                        if(student.getSkill1()==1){
//                            request.setAttribute("skill1", "1");
//                        }
//                        if(student.getSkill2()==1){
//                            request.setAttribute("skill2", "1");
//                        }
//                        if(student.getSkill3()==1){
//                            request.setAttribute("skill3", "1");
//                        }
                        session.setAttribute("student", student);
                        SuccessDAO ssDao = new SuccessDAO();
                        session.setAttribute("day", ssDao.numberDay());
                        session.setAttribute("month", ssDao.numberMonth());
                        //Xuat file Json
                        JobDAO jDao = new JobDAO();
                        ArrayList<Job> jobL = jDao.getAllJobs();
                        File file = new File("...\\Projects\\TopJob\\web\\data.json");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        try (BufferedWriter bw = new BufferedWriter(fw)) {
                            bw.write(Job.toJSONString(jobL));
                        }

                        String cookie = null;
                        Cookie[] cookies = null;
                        cookies = request.getCookies();
                        cookie=Utility.getCookieValue(cookies, "history");
                        if(!cookie.equals("")){
                            int s = Integer.parseInt(cookie);
                            if (s > 125) {
                                Job b = jDao.getMaxSalary();
                                session.setAttribute("jobR", b);
                            } else {
                                Job b = jDao.getMinSalary();
                                session.setAttribute("jobR", b);
                            }
                        }

                    } else {
                        if (dao.checkLogin(account).equals("employer")) {
                            url = "/Employer.jsp";
                            EmProDAO eDao = new EmProDAO();
                            Employer employer = eDao.getProfile(account);
                            session.setAttribute("employer", employer);

                            JobDAO jDao = new JobDAO();
                            ArrayList<Job> jobs = jDao.getJobs(employer);
                            session.setAttribute("jobs", jobs);

                        } else {
                            url = "/Admin.html";
                        }
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
