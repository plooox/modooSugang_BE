package com.example.modoosugang_be.Domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter             // getter setter 자동생성
@RequiredArgsConstructor    // Constructor 주입 -> DI
@Entity()                   // Connect table in DB
@Table(name = "schedule")    // DB table name = "schedule"
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_index")
    private int Id;

    @Column(name = "univ_name")
    private String univ;
    @Column(name = "manager_id")
    private String manager;
    @Column(name = "semester")
    private String semester;
    @Column(name = "basket_start")
    private Timestamp BasketStart;
    @Column(name = "basket_end")
    private Timestamp BasketEnd;
    @Column(name = "register_start")
    private Timestamp RegisterStart;
    @Column(name = "register_end")
    private Timestamp RegisterEnd;
    @Column(name = "modify_start")
    private Timestamp ModifyStart;
    @Column(name = "modify_end")
    private Timestamp ModifyEnd;
    @Column(name = "cancel_start")
    private Timestamp CancelStart;
    @Column(name = "cancel_end")
    private Timestamp CancelEnd;
}
