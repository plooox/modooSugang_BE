package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentInfoRepository extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query(value = "update Student m set m.name = :name, m.birth = :birth, m.phone = :phone, m.major = :major, m.second = :second, m.grade = :grade, m.enroll = :enroll, m.credit = :credit, m.pw = :pw, m.univ = :univ where m.id = :id")
    int UpdateStudentInfo(String name, String birth, String phone, String major, String second, String grade, String enroll, int credit, String univ, String id);

    @Query(value = "SELECT v FROM Student v WHERE v.univ Like :univ%")
    List<Student> findStudent(@Param("univ")String univ);
}
