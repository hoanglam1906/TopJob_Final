/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Account;
import business.Application;
import business.Employer;
import business.Job;
import business.Student;
import business.Success;
import data.ApplicationDAO;
import data.JobDAO;
import data.SuccessDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class ManJobServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException, SQLException, ClassNotFoundException {
        String url = "/job.jsp";
        String action = request.getParameter("action");

        if (action.equals("delete")) {
            HttpSession session = request.getSession();
            ArrayList<Job> jobs = (ArrayList<Job>) session.getAttribute("jobs");
            int id = Integer.parseInt(request.getParameter("id"));
            for (Job j : jobs) {
                if (j.getId() == id) {
                    jobs.remove(j);
                    break;
                }
            }
            session.setAttribute("jobs", jobs);
            try {
                JobDAO jDao = new JobDAO();
                jDao.deleteJob(id);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ManJobServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (action.equals("add")) {
                HttpSession session = request.getSession();
                ArrayList<Job> jobs = (ArrayList<Job>) session.getAttribute("jobs");
                String title = request.getParameter("title");
                int salary = Integer.parseInt(request.getParameter("salary"));
                String skill[] = request.getParameterValues("skill");
                String expiryString = request.getParameter("expiry");
                Employer employer = (Employer) session.getAttribute("employer");
                int skill1 = 0, skill2 = 0, skill3 = 0;
                for (int i = 0; i < skill.length; i++) {
                    if (skill[i].equals("skill1")) {
                        skill1 = 1;
                    }
                    if (skill[i].equals("skill2")) {
                        skill2 = 1;
                    }
                    if (skill[i].equals("skill3")) {
                        skill3 = 1;
                    }
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date expiryU = sdf.parse(expiryString);
                Date expiry = new Date(expiryU.getTime());
                Job job = new Job(employer, title, salary, expiry, skill1, skill2, skill3);
                JobDAO jDao = new JobDAO();
                int id = jDao.addJob(job);
                job.setId(id);
                jobs.add(job);
                session.setAttribute("jobs", jobs);
            }
            if (action.equals("edit")) {
                HttpSession session = request.getSession();
                ArrayList<Job> jobs = (ArrayList<Job>) session.getAttribute("jobs");
                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                int salary = Integer.parseInt(request.getParameter("salary"));
                int skill1 = Integer.parseInt(request.getParameter("skill1"));
                int skill2 = Integer.parseInt(request.getParameter("skill2"));
                int skill3 = Integer.parseInt(request.getParameter("skill3"));
                String expiryString = request.getParameter("expiry");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date expiryU = sdf.parse(expiryString);
                Date expiry = new Date(expiryU.getTime());
                Employer employer = (Employer) session.getAttribute("employer");
                Job job = new Job(id, employer, title, salary, expiry, skill1, skill2, skill3);
                for (Job j : jobs) {
                    if (j.getId() == id) {
                        int k = jobs.indexOf(j);
                        jobs.set(k, job);
                        break;
                    }
                }
                session.setAttribute("jobs", jobs);
                JobDAO jDao = new JobDAO();
                jDao.editJob(job);
            }
            if (action.equals("view")) {
                url = "/application.jsp";
                int id = Integer.parseInt(request.getParameter("id"));
                HttpSession session = request.getSession();
                ArrayList<Job> jobs = (ArrayList<Job>) session.getAttribute("jobs");
                Job job = new Job();
                for (Job j : jobs) {
                    if (j.getId() == id) {
                        job = j;
                        break;
                    }
                }
                ApplicationDAO aDao=new ApplicationDAO();
                Application application=aDao.getApplication(job);
                
                SuccessDAO sDao=new SuccessDAO();
                ArrayList<Success> listS=sDao.get(application.getJob());
                session.setAttribute("listS", listS);
                session.setAttribute("application", application);
                request.setAttribute("title", job.getTitle());
            }
            if(action.equals("accept")){
                HttpSession session = request.getSession();
                Application application=(Application) session.getAttribute("application");
                String email=request.getParameter("email");
                Account account=new Account(email);
                Student student=new Student(account);
                
                ApplicationDAO aDao=new ApplicationDAO();
                aDao.remove(student, application.getJob());
                for(Student s:application.getStudents()){
                    if(s.getAccount().getEmail().equals(email)){
                        student=s;
                        application.getStudents().remove(s);
                        break;
                    }
                }
                session.setAttribute("application", application);
                
                SuccessDAO sDao=new SuccessDAO();
                Success success=new Success(student, application.getJob());
                sDao.add(success);
                
                ArrayList<Success> listS=sDao.get(application.getJob());
                session.setAttribute("listS", listS);
                url = "/application.jsp";
            }
        }
        
        if(action.equals("back")){
            
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
        } catch (ParseException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManJobServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManJobServlet.class.getName()).log(Level.SEVERE, null, ex);
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
