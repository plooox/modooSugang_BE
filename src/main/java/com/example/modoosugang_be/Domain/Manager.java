package com.example.modoosugang_be.Domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@RequiredArgsConstructor
@Entity()  // Connect table in DB
@Table(name = "manager")
public class Manager {

    @Id
    private String managerId;  // Primary Key

    private String universityName;
    private String managerEmail;
    private String managerPw;
}
