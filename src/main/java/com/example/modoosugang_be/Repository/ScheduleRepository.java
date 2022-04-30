package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    Optional<Schedule> findBySemester(String semester);

    Optional<Schedule> findByUnivAndSemester(String univ, String semester);

    @Transactional
    @Modifying
    @Query("update Schedule m set m.BasketStart = :start , m.BasketEnd = :end where m.univ = :univ and m.semester = :semester")
    int updateBasket(Timestamp start, Timestamp end, String univ, String semester);

    @Transactional
    @Modifying
    @Query("update Schedule m set m.RegisterStart = :start , m.RegisterEnd = :end where m.univ = :univ and m.semester = :semester")
    int updateRegister(Timestamp start, Timestamp end, String univ, String semester);

    @Transactional
    @Modifying
    @Query("update Schedule m set m.ModifyStart = :start , m.ModifyEnd = :end where m.univ = :univ and m.semester = :semester")
    int updateModify(Timestamp start, Timestamp end, String univ, String semester);

    @Transactional
    @Modifying
    @Query("update Schedule m set m.CancelStart = :start , m.CancelEnd = :end where m.univ = :univ and m.semester = :semester")
    int updateCancel(Timestamp start, Timestamp end, String univ, String semester);

}
