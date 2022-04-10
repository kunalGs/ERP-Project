package com.example.esd_project.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Courses")
public class Courses implements Serializable {
    @Id
    @Column(name="course_id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    @Column
    private String course_name;
    @Column
    private String course_code;
    @Column
    private String Specialization;
    @Column
    private int capacity;
    @Column
    private int credit;
    @Column
    private String prerequisite;

//    @ManyToOne(cascade={CascadeType.ALL})
//    @JoinColumn(name="prereq_id")
//    private Courses prerequisite;
//
//    @OneToMany(mappedBy="prerequisite")
//    private Set<Courses> subordinates = new HashSet<Courses>();

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }
//    public Courses getPrerequisite() {
//        return prerequisite;
//    }
//
//    public void setPrerequisite(Courses prerequisite) {
//        this.prerequisite = prerequisite;
//    }
//
//    public Set<Courses> getSubordinates() {
//        return subordinates;
//    }
//
//    public void setSubordinates(Set<Courses> subordinates) {
//        this.subordinates = subordinates;
//    }
}
