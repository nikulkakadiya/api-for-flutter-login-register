package com.example.new_api.bean;

public class Registration {
    int id;
    String fname;
    String lname;
    String email;
    String pass;
    String confpass;

    public Registration() {
    }

    public Registration(int id, String fname, String lname, String email, String pass, String confpass) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pass = pass;
        this.confpass = confpass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfpass() {
        return confpass;
    }

    public void setConfpass(String confpass) {
        this.confpass = confpass;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", confpass='" + confpass + '\'' +
                '}';
    }
}
