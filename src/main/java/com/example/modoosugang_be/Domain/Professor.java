package com.example.modoosugang_be.Domain;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter             // getter setter 자동생성
@RequiredArgsConstructor    // Constructor 주입 -> DI
@Entity()                   // Connect table in DB
@Table(name = "professor")
public class Professor {

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