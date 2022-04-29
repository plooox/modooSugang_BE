package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentInfoRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT v FROM Student v WHERE v.univ Like :univ%")
    List<Student> findStudent(@Param("univ")String univ);
}
