package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.lang.*;
import java.util.Optional;

@Component
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    Optional<Lecture> findByIdx(int idx);

    @Query(value = "SELECT v FROM Lecture v WHERE v.professor Like :univ%")
    List<Lecture> findLecture(@Param("univ")String univ);

    @Query(value = "SELECT v FROM Lecture v WHERE v.professor Like :univ% AND v.id = :id")
    Lecture findLectureByUnivAndID(@Param("univ") String univ, @Param("id") String id);

    @Query(value = "SELECT v FROM Lecture v WHERE v.professor Like :univ% AND v.idx = :idx")
    Lecture findLectureByUnivAndIdx(@Param("univ") String univ, @Param("idx") int idx);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Lecture v WHERE v.professor Like :univ%")
    void deleteByUniv(@Param("univ") String univ);

    List<Lecture> findAllBySemester(String semester);

    @Transactional
    @Modifying
    @Query("update Lecture l set l.remain = :inputRemain where l.idx = :code")
    int updateRemain(int code, int inputRemain);
}