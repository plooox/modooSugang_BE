package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.lang.*;
@Component
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Transactional
    @Modifying
    @Query(value = "update Lecture m set m.id = :id, m.proid = :proid, m.name = :name, m.limit = :limit, m.credit = :credit, m.major = :major, m.classes = :classes, m.room = :room, m.semester = :semester, m.proname = :proname, m.time = :time, m.classify = :classify, m.univ = :univ where m.index = :idx")
    int UpdateLecture (String id, String proid,String name,int limit, int credit, String major,String classes, String room, String semester, String proname, String time, String classify, String univ, int idx);

    @Query(value = "SELECT v FROM Lecture v WHERE v.univ Like :univ%")
    List<Lecture> findLecture(@Param("univ")String univ);

    @Query(value = "SELECT v FROM Lecture v WHERE v.professor Like :univ% AND v.id = :id")
    Lecture findLectureByUnivAndID(@Param("univ") String univ, @Param("id") String id);
}
