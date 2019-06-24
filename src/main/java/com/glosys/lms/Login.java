package com.glosys.lms;

import javax.persistence.*;

@Entity
@Table(name = "login")

public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "signup_id")
    private Integer id;
    @Column(name = "mail_id")
    private String mailId;
    @Column (name = "passwordd")
    private String password;

    public Login() {

    }

    public Login(String mailId, String password) {
        this.mailId = mailId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
