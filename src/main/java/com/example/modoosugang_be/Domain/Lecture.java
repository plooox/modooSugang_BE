package com.example.modoosugang_be.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter             // getter setter 자동생성
//@RequiredArgsConstructor    // Constructor 주입 -> DI
@Entity()                   // Connect table in DB
@Table(name = "lecture")    // DB table name = "lecture"
public class Lecture {
    /*@ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
     */
    /*@OneToMany(mappedBy = "professor_id")
    private List <Professor> professors = new ArrayList<>();
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_index")
    private int idx;
    @Column(name = "professor_id")
    private String professor;
    @Column(name = "lecture_id")
    private String id;
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
