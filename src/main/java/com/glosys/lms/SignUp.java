package com.glosys.lms;

import javax.persistence.*;

@Entity
@Table(name = "signup")

public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "signup_id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mail_id")
    private String mailId;
    @Column(name = "college_name")
    private String collegeName;
    @Column (name = "passwordd")
    private String password;
    @Column (name = "re_password")
    private String rePassword;

    public SignUp() {
    }

    public SignUp(String firstName, String lastName, String mailId, String collegeName, String password, String rePassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailId = mailId;
        this.collegeName = collegeName;
        this.password = password;
        this.rePassword = rePassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
