/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Account;
import business.Job;
import business.Student;
import business.Success;
import business.Utility;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 *
 * @author Thinh Phung
 */
public class SuccessDAO {

    private static Connection connection;
    private PreparedStatement statement;
    private ResultSet set;

    public SuccessDAO() throws SQLException, ClassNotFoundException {
        connection = Utility.getConnection();
    }

    public void add(Success success) throws SQLException, ClassNotFoundException {
        statement = connection.prepareStatement("insert into success (student,job,date) values (?,?,?) ");
        statement.setString(1, success.getStudent().getAccount().getEmail());
        statement.setInt(2, success.getJob().getId());
        statement.setDate(3, success.getDate());
        statement.execute();

    }

    public ArrayList<Success> get(Job job) throws SQLException, ClassNotFoundException {
        statement = connection.prepareStatement("select * from success where job = ?");
        statement.setInt(1, job.getId());
        set = statement.executeQuery();
        StudentDAO sDao = new StudentDAO();
        ArrayList<Success> listS = new ArrayList<>();
        while (set.next()) {
            String email = set.getString(2);
            Account account = new Account(email);
            Student student = sDao.getStudent(account);
            Success success = new Success(student, job, set.getDate(4));
            listS.add(success);
        }
        return listS;
    }

    public int numberDay() throws SQLException {
        Date date = new Date(new java.util.Date().getTime());
        statement = connection.prepareStatement("select count(date) from success where date = ?");
        statement.setDate(1, date);
        set = statement.executeQuery();
        set.next();
        return set.getInt(1);
    }

    public int numberMonth() throws SQLException {
        java.util.Date date = new java.util.Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        statement = connection.prepareStatement("select count(date) from success where month(date) = ?");
        statement.setInt(1, month);
        set=statement.executeQuery();
        set.next();
        return set.getInt(1);
    }
}
