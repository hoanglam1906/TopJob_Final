/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import org.json.simple.JSONAware;

/**
 *
 * @author Thinh Phung
 */
public class Account implements JSONAware{

    private String email;
    private String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String email) {
        this.email = email;
    }

    public Account() {
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"email\":\"").append(getEmail()).append("\"");
        sb.append(",");
        sb.append("\"password\":\"").append(getPassword()).append("\"");
        sb.append("}");
        return sb.toString();
    }

}
