package com.example.modoosugang_be.Domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@RequiredArgsConstructor
@Entity()  // Connect table in DB
@Table(name = "manager")
public class Manager {

    @Id
    @Column(name = "manager_id")
    private String id;  // Primary Key

    @Column(name = "university_name")
    private String univ;
    @Column(name = "manager_email")
    private String email;
    @Column(name = "manager_pw")
    private String pw;
}
