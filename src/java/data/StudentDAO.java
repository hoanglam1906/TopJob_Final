package data;


import business.Account;
import business.Student;
import business.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static jdk.nashorn.internal.runtime.Debug.id;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thinh Phung
 */
public class StudentDAO {
    private static Connection connection;
    private PreparedStatement statement;
    private ResultSet set;

    public StudentDAO() throws SQLException, ClassNotFoundException {
        connection=Utility.getConnection();
    }
    
    public Student getStudent(Account account) throws SQLException{
        statement=connection.prepareStatement("select * from student where email = ?");
        statement.setString(1, account.getEmail());
        set=statement.executeQuery();
        set.next();
        Student student=new Student(account, set.getString(2), set.getString(3), set.getInt(4), set.getInt(5), set.getInt(6));
        return student;
    }
}
