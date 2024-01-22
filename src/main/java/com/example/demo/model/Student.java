package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "STUDENT_1")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STUDENT_1")
    @SequenceGenerator(name = "SEQ_STUDENT_1", sequenceName = "SEQ_STUDENT_1", allocationSize = 1)
    @Column(name = "ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "TELEPHONE")
    private int telephone;
    @Column(name = "EMAIL")
    private String email;

//    @ManyToOne
//    @JoinColumn(name="TEACHER_1_ID", nullable=false)
//    private Teacher teacher;


//    @ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(name = "",
//    JoinColumns={
//            @JoinColumn(name = "ID",referencedColumnName = "ID")
//    },
//    inverseJoinColumns = {
//            @JoinColumn(name = "ID",referencedColumnName = "ID")
//    })




}
