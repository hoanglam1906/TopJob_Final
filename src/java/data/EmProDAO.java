/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Account;
import business.Employer;
import business.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thinh Phung
 */
public class EmProDAO {

    private static Connection connection;
    private PreparedStatement statement;
    private ResultSet set;

    public EmProDAO() throws SQLException, ClassNotFoundException {
        connection = Utility.getConnection();
    }

    public void changeProfile(Employer employer) throws SQLException {
        statement = connection.prepareStatement("update employer set name = ? , company = ? where email = ?");
        statement.setString(1, employer.getName());
        statement.setString(2, employer.getCompany());
        statement.setString(3, employer.getAccount().getEmail());
        if(!statement.execute()){
            
        }
    }

    public Employer getProfile(Account account) throws SQLException {
        statement = connection.prepareStatement("select * from employer where email = ?");
        statement.setString(1, account.getEmail());
        set = statement.executeQuery();
        if (set.next()) {
            Employer employer = new Employer(account, set.getString(2), set.getString(3));
            return employer;
        }
        else return new Employer(account);
    }
}