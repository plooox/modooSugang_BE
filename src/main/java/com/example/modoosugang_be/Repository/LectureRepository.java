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
public interface LectureRepository extends JpaRepository<Lecture, Integer> {
    //마지막줄만 업데이트됨
   /* @Transactional
    @Modifying
    @Query( value = "update Lecture m set m.id = :id, m.professor = :professor, m.name = :name, m.limit = :limit, m.credit = :credit, m.major = :major, m.classes = :classes, m.room = :room, m.semester = :semester, m.proname = :proname, m.time = :time, m.classify = :classify, m.univ = :univ, m.idx = :idx where m.idx is null")
   void UpdateLecture (@Param("id")String id,@Param("professor")String professor, @Param("name")String name,@Param("limit")int limit, @Param("credit")int credit,
                       @Param("major")String major,@Param("classes")String classes, @Param("room")String room, @Param("semester")String semester, @Param("proname")String proname,
                       @Param("time")String time, @Param("classify")String classify, @Param("univ")String univ, @Param("idx")int idx);
*/
    @Query(value = "SELECT v FROM Lecture v WHERE v.univ Like :univ%")
    List<Lecture> findLecture(@Param("univ")String univ);

}
