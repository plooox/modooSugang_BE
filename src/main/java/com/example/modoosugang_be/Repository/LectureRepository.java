package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.lang.*;
@Component
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query(value = "SELECT v FROM Lecture v WHERE v.professor Like :univ%")
    List<Lecture> findLecture(@Param("univ")String univ);

    @Query(value = "SELECT v FROM Lecture v WHERE v.professor Like :univ% AND v.id = :id")
    Lecture findLectureByUnivAndID(@Param("univ") String univ, @Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Lecture v WHERE v.professor Like :univ%")
    void deleteByUniv(@Param("univ") String univ);
}
