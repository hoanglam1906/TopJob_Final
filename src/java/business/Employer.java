/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Thinh Phung
 */
public class Employer {
    private Account account;
    private String name;
    private String company;

    public Employer(Account account) {
        this.account = account;
    }

    public Employer(Account account, String name, String company) {
        this.account = account;
        this.name = name;
        this.company = company;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    
}
