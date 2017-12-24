/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Account;
import business.Student;
import business.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thinh Phung
 */
public class StuProDAO {

    private static Connection connection;
    private PreparedStatement statement;
    private ResultSet set;

    public StuProDAO() throws SQLException, ClassNotFoundException {
        connection = Utility.getConnection();
    }

    public boolean changeProfile(Student student) throws SQLException {
        statement = connection.prepareStatement("update student set name = ? , school = ?, skill1=?,skill2=?,skill3=? where email = ?");
        statement.setString(1, student.getName());
        statement.setString(2, student.getSchool());
        statement.setInt(3, student.getSkill1());
        statement.setInt(4, student.getSkill2());
        statement.setInt(5, student.getSkill3());
        statement.setString(6, student.getAccount().getEmail());
        return statement.execute();
    }

    public Student getProfile(Account account) throws SQLException {
        statement = connection.prepareStatement("select * from student where email = ?");
        statement.setString(1, account.getEmail());
        set = statement.executeQuery();
        if (set.next()) {
            Student student = new Student(account, set.getString(2), set.getString(3), set.getInt(4), set.getInt(5), set.getInt(6));
            return student;
        }
        return new Student(account);
    }

}
