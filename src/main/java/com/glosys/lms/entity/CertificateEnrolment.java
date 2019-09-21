package com.glosys.lms.entity;

import javax.persistence.*;

@Entity(name = "certificate_enrolment")
@Table
public class CertificateEnrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_enrolment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public CertificateEnrolment() {
    }

    public CertificateEnrolment(Certificate certificate, Student student) {
        this(null, certificate, student);
    }

    public CertificateEnrolment(Integer id, Certificate certificate, Student student) {
        this.id = id;
        this.certificate = certificate;
        this.student = student;
    }

    public CertificateEnrolment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
