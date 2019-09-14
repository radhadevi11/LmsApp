package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name= "known_courses")
    private String knownCourses;

    @Column(name="user_name")
    private String userName;

    @Column (name = "passwordd")
    private String password;

    public Trainer() {
    }

    public Trainer(Integer id) {
        this.id = id;
    }

    public Trainer(String firstName) {
        this(firstName, null,null ,null ,null ,null );
    }

    public Trainer(String firstName, String lastName, String gender, String knownCourses,
                   String userName, String password) {
        this(null, firstName, lastName, gender, knownCourses, userName, password);
    }

    public Trainer(Integer id, String firstName, String lastName, String gender, String knownCourses,
                   String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.knownCourses = knownCourses;
        this.userName = userName;
        this.password = password;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKnownCourses() {
        return knownCourses;
    }

    public void setKnownCourses(String knownCourses) {
        this.knownCourses = knownCourses;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
