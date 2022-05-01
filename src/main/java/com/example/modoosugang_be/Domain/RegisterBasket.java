package com.example.modoosugang_be.Domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter             // getter setter 자동생성
@RequiredArgsConstructor    // Constructor 주입 -> DI
@Entity()                   // Connect table in DB
@Table(name = "register_basket")    // DB table name = "register_lecture"
public class RegisterBasket implements Serializable {

    @Id
    @Column(name = "register_basket_id")
    private int id;

    @Column(name = "lecture_index")
    private int idx;
    @Column(name = "student_id")
    private String student;
    @Column(name = "schedule_index")
    private int schedule;
    @Column(name = "univ_name")
    private String univ;

}
