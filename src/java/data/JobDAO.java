/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Account;
import business.Employer;
import business.Job;
import business.Utility;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thinh Phung
 */
public class JobDAO {

    private static Connection connection;
    private PreparedStatement statement;
    private ResultSet set;

    public JobDAO() throws SQLException, ClassNotFoundException {
        connection = Utility.getConnection();
    }

    public ArrayList<Job> getJobs(Employer employer) throws SQLException {
        ArrayList<Job> jobs = new ArrayList<>();
        String email = employer.getAccount().getEmail();
        statement = connection.prepareStatement("select * from job where email = ?");
        statement.setString(1, email);
        set = statement.executeQuery();
        Job j;
        while (set.next()) {
            j = new Job(set.getInt(1), employer, set.getString(2), set.getInt(7), set.getDate(8), set.getInt(3), set.getInt(4), set.getInt(5));
            jobs.add(j);
        }
        return jobs;
    }

    public void deleteJob(int id) throws SQLException {
        statement = connection.prepareStatement("delete from job where id = ?");
        statement.setInt(1, id);
        statement.execute();
    }

    public int addJob(Job job) throws SQLException {
        statement = connection.prepareStatement("insert into job (title,skill1,skill2,skill3,email,salary,expiry) values (?,?,?,?,?,?,?)");
        statement.setString(1, job.getTitle());
        statement.setInt(2, job.getSkill1());
        statement.setInt(3, job.getSkill2());
        statement.setInt(4, job.getSkill3());
        statement.setString(5, job.getEmployer().getAccount().getEmail());
        statement.setInt(6, job.getSalary());
        statement.setDate(7, job.getExpiry());
        statement.execute();
        statement = connection.prepareStatement("SELECT LAST_INSERT_ID() from job");
        set = statement.executeQuery();
        set.next();
        return set.getInt(1);
    }

    public void editJob(Job job) throws SQLException {
        statement = connection.prepareStatement("update job set title=?,skill1=?,skill2=?,skill3=?,salary=?,expiry=? where id = ?");
        statement.setString(1, job.getTitle());
        statement.setInt(2, job.getSkill1());
        statement.setInt(3, job.getSkill2());
        statement.setInt(4, job.getSkill3());
        statement.setInt(5, job.getSalary());
        statement.setDate(6, job.getExpiry());
        statement.setInt(7, job.getId());
        statement.execute();

    }

    public ArrayList<Job> getAllJobs() throws SQLException, ClassNotFoundException {
        statement = connection.prepareStatement("select * from job");
        set = statement.executeQuery();
        ArrayList<Job> jobs = new ArrayList<>();
        EmProDAO eDao = new EmProDAO();
        while (set.next()) {
            int id = set.getInt(1);
            String title = set.getString(2);
            int skill1 = set.getInt(3);
            int skill2 = set.getInt(4);
            int skill3 = set.getInt(5);
            String email = set.getString(6);
            int salary = set.getInt(7);
            Date expiry = set.getDate(8);
            Account account = new Account(email);
            Employer employer = eDao.getProfile(account);
            Job j = new Job(id, employer, title, salary, expiry, skill1, skill2, skill3);
            jobs.add(j);
        }
        return jobs;
    }

    public int getSalary(int id) throws SQLException {
        statement = connection.prepareStatement("select salary from job where id = ?");
        statement.setInt(1, id);
        set = statement.executeQuery();
        set.next();
        return set.getInt(1);
    }

    public Job getMaxSalary() throws SQLException {
        statement = connection.prepareStatement("select * from job where salary = (select max(salary) from job)");
        set = statement.executeQuery();
        set.next();
        int id = set.getInt(1);
        String title = set.getString(2);
        int skill1 = set.getInt(3);
        int skill2 = set.getInt(4);
        int skill3 = set.getInt(5);
        String email = set.getString(6);
        Employer employer=new Employer(new Account(email));
        int salary = set.getInt(7);
        Date expiry = set.getDate(8);
        return new Job(id, employer, title, salary, expiry, skill1, skill2, skill3);
    }
    
     public Job getMinSalary() throws SQLException {
        statement = connection.prepareStatement("select * from job where salary = (select min(salary) from job)");
        set = statement.executeQuery();
        set.next();
        int id = set.getInt(1);
        String title = set.getString(2);
        int skill1 = set.getInt(3);
        int skill2 = set.getInt(4);
        int skill3 = set.getInt(5);
        String email = set.getString(6);
        int salary = set.getInt(7);
        Date expiry = set.getDate(8);
        Employer employer=new Employer(new Account(email));
        return new Job(id, employer, title, salary, expiry, skill1, skill2, skill3);
    }
}
