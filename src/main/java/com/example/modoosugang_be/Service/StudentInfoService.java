package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Student;
import com.example.modoosugang_be.Repository.StudentInfoRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final StudentInfoRepository studentInfoRepository;

    public List<Student> callUnivStudent(String univ) {
        List<Student> students = studentInfoRepository.findStudent(univ);
        return students;
    }

    public void setUpdateStudent(Student student) {
        studentInfoRepository.save(student);
    }
}

