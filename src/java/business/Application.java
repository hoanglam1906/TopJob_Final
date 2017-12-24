/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Thinh Phung
 */
public class Application {
    private int id;
    private ArrayList<Student> students;
    private Job job;

    public Application(ArrayList<Student> students, Job job) {
        this.students = students;
        this.job = job;
    }

    public Application(int id, ArrayList<Student> students, Job job) {
        this.id = id;
        this.students = students;
        this.job = job;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
