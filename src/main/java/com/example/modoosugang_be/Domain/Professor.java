package com.example.modoosugang_be.Domain;

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
    @Id
    @Column(name = "professor_id")
    private String id;

    @Column(name = "professor_name")
    private String name;
    @Column(name = "professor_major")
    private String major;
    @Column(name = "professor_email")
    private String email;
}