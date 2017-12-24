/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Account;
import business.Application;
import business.Job;
import business.Student;
import business.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thinh Phung
 */
public class ApplicationDAO {

    private static Connection connection;
    private PreparedStatement statement;
    private ResultSet set;

    public ApplicationDAO() throws SQLException, ClassNotFoundException {
        connection = Utility.getConnection();
    }

    public Application getApplication(Job job) throws SQLException, ClassNotFoundException {
        statement = connection.prepareStatement("select * from application where job = ?");
        statement.setInt(1, job.getId());
        set = statement.executeQuery();
        StudentDAO sDao = new StudentDAO();
        ArrayList<Student> students = new ArrayList<>();
        int id = 0;
        while (set.next()) {
            id = set.getInt(1);
            String email = set.getString(3);
            Account account = new Account(email);
            Student student = sDao.getStudent(account);
            students.add(student);
        }
        Application application = new Application(id, students, job);
        return application;
    }

    public void remove(Student student, Job job) throws SQLException {
        statement = connection.prepareStatement("delete from application where job = ? and student=?");
        statement.setInt(1, job.getId());
        statement.setString(2, student.getAccount().getEmail());
        statement.execute();
    }

    public void add(int jobId, String studentEmail) throws SQLException {
        statement = connection.prepareStatement("select * from success where job = ? and student = ?");
        statement.setInt(1, jobId);
        statement.setString(2, studentEmail);
        set = statement.executeQuery();
        if (!set.next()) {
            statement = connection.prepareStatement("select * from application where job = ? and student = ?");
            statement.setInt(1, jobId);
            statement.setString(2, studentEmail);
            set = statement.executeQuery();
            if (!set.next()) {
                statement = connection.prepareStatement("insert into application (job,student) values (?,?)");
                statement.setInt(1, jobId);
                statement.setString(2, studentEmail);
                statement.execute();
            }
        }
    }
}
