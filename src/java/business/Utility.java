/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.Cookie;

/**
 *
 * @author Thinh Phung
 */
public class Utility {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection c;
        Class.forName("com.mysql.jdbc.Driver");
        c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/topjob", "root", "12345aA@");
        return c;
    }
    
    public static String getCookieValue(Cookie[] cookies,String cookieName){
        String cookieValue="";
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookieName.equals(cookie.getName())){
                    cookieValue=cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
