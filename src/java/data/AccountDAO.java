/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Account;
import business.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thinh Phung
 */
public class AccountDAO {
    private static Connection connection;
    private PreparedStatement statement;
    private ResultSet set;
    public AccountDAO() throws SQLException, ClassNotFoundException {
        connection=Utility.getConnection();
    }
    
    public String checkLogin(Account account) throws SQLException{
        statement=connection.prepareStatement("select * from account where email=? and password=?");
        statement.setString(1, account.getEmail());
        statement.setString(2, account.getPassword());
        set=statement.executeQuery();
        if(set.next()){
            return set.getString(3);
        }
        else return "false";
    }
    
    public boolean signup(Account account, String position) throws SQLException{
        statement=connection.prepareStatement("select * from account where email = ?");
        statement.setString(1,account.getEmail());
        set=statement.executeQuery();
        if(set.next())
            return false;
        else{
            statement=connection.prepareStatement("insert into account values (?, ?, ?)");
            statement.setString(1, account.getEmail());
            statement.setString(2, account.getPassword());
            statement.setString(3, position);
            statement.execute();
            return true;
        }
    }
}
