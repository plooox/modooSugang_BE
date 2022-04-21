package com.example.modoosugang_be.Domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter             // getter setter 자동생성
@RequiredArgsConstructor    // Constructor 주입 -> DI
@Entity()                   // Connect table in DB
@Table(name = "lecture")    // DB table name = "lecture"
public class Lecture {

    @Id
    @Column(name = "lecture_index")
    private int index;

    @Column(name = "lecture_id")
    private String id;
    @Column(name = "professor_id")
    private String proid;
    @Column(name = "lecture_name")
    private String name;
    @Column(name = "lecture_limit")
    private int limit;
    @Column(name = "lecture_credit")
    private int credit;
    @Column(name = "lecture_major")
    private String major;
    @Column(name = "lecture_class")
    private String classes;
    @Column(name = "lecture_room")
    private String room;
    @Column(name = "lecture_semester")
    private String semester;
    @Column(name = "lecture_professor")
    private String proname;
    @Column(name = "lecture_time")
    private String time;
    @Column(name = "lecture_classify")
    private String classify;
    @Column(name = "university_name")
    private String univ;
}
