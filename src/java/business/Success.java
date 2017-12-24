/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Date;

/**
 *
 * @author Thinh Phung
 */
public class Success {

    private Student student;
    private Job job;
    private Date date;

    public Success(Student student, Job job) {
        this.student = student;
        this.job = job;
        date=new Date(new java.util.Date().getTime());
    }

    public Success(Student student, Job job, Date date) {
        this.student = student;
        this.job = job;
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
