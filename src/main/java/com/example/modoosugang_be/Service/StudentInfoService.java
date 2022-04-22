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

    public int setUpdateStudent(String name, String birth, String phone, String major, String second, String grade, String enroll, int credit, String pw, String univ) {
        int students = studentInfoRepository.UpdateStudentInfo(name, birth, phone, major, second, grade, enroll, credit, pw, univ);

        return students;
    }
}

