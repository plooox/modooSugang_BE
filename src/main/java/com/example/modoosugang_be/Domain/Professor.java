package com.example.modoosugang_be.Domain;

<<<<<<< HEAD
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity()
@Table(name = "professor")
public class Professor {
    /*@ManyToOne
    @JoinColumn(name = "lecture_index")
    private Lecture lecture;
    */
   /* @OneToMany(mappedBy = "lecture_id", cascade = {CascadeType.ALL})
    private List<Lecture> lectures = new ArrayList<>();
    */
=======
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
@Table(name = "professor")
public class Professor {

>>>>>>> a67c5f0f5c698fb33d699f02a68307ec669a3b06
    @Id
    @Column(name = "professor_id")
    private String id;

    @Column(name = "professor_name")
    private String name;
    @Column(name = "professor_major")
    private String major;
    @Column(name = "professor_email")
    private String email;
<<<<<<< HEAD
}
=======
}
>>>>>>> a67c5f0f5c698fb33d699f02a68307ec669a3b06
