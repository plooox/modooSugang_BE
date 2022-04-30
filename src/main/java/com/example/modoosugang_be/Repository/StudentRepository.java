package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdAndUniv(String id, String univ);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Student v WHERE v.univ = :univ")
    void deleteByUniv(@Param("univ") String univ);
}
