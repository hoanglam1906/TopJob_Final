
import data.SuccessDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thinh Phung
 */
public class test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        SuccessDAO dao=new SuccessDAO();
        System.out.println(dao.numberMonth());
    }
}
