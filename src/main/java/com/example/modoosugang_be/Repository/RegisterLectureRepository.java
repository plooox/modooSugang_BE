package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.RegisterLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterLectureRepository extends JpaRepository<RegisterLecture, Long> {
    List<RegisterLecture> findAllByUnivAndStudent(String univ, String student);

    List<RegisterLecture> findAllByStudent(String student);


    List<RegisterLecture> findAllBySemesterAndUnivAndStudent(String semester, String univ, String student_id);

}
