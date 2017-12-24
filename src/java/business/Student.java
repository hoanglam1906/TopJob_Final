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
public class Student {
    private Account account;
    private String name;
    private String school;
    private int skill1;
    private int skill2;
    private int skill3;

    public Student(Account account, String name, String school, int skill1, int skill2, int skill3) {
        this.account = account;
        this.name = name;
        this.school = school;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    public Student(Account account) {
        this.account = account;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getSkill1() {
        return skill1;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }
    
    
}
