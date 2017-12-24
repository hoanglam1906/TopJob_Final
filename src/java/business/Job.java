/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import org.json.simple.JSONAware;

/**
 *
 * @author Thinh Phung
 */
public class Job implements Serializable, JSONAware{
    private int id;
    private Employer employer;
    private String title;
    private int salary;
    private Date expiry;
    private int skill1;
    private int skill2;
    private int skill3;

    public Job() {
    }

    public Job(int id, Employer employer, String title, int salary, Date expiry, int skill1, int skill2, int skill3) {
        this.id = id;
        this.employer = employer;
        this.title = title;
        this.salary = salary;
        this.expiry = expiry;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    public Job(Employer employer, String title, int salary, Date expiry, int skill1, int skill2, int skill3) {
        this.employer = employer;
        this.title = title;
        this.salary = salary;
        this.expiry = expiry;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

   

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public int getSkill1() {
        return skill1;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\":\"").append(getId()).append("\"");
        sb.append(",");
        sb.append("\"title\":\"").append(getTitle()).append("\"");
        sb.append(",");
        sb.append("\"employer\":\"").append(getEmployer().getName()).append("\"");
        sb.append(",");
        sb.append("\"salary\":\"").append(getSalary()).append("\"");
        sb.append(",");
        sb.append("\"expiry\":\"").append(getExpiry()).append("\"");
        sb.append(",");
        sb.append("\"skill1\":\"").append(getSkill1()).append("\"");
        sb.append(",");
        sb.append("\"skill2\":\"").append(getSkill2()).append("\"");
        sb.append(",");
        sb.append("\"skill3\":\"").append(getSkill3()).append("\"");
        sb.append("}");
        return sb.toString();
    }
    
    public static String toJSONString(ArrayList<Job> jobs){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(jobs.get(0).toJSONString());
        for(int i=1;i<jobs.size();i++){
            sb.append(",");
            sb.append(jobs.get(i).toJSONString());
        }
        sb.append("]");
        return sb.toString();
    }
}
