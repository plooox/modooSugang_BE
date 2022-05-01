package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.RegisterLecture;
import com.example.modoosugang_be.Repository.RegisterLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterLectureService {

    private final RegisterLectureRepository registerLectureRepository;

    public List<RegisterLecture> DeleteLecture(int code, String univ, String semester, String student) {
        return registerLectureRepository.deleteRegisterLectureByLectureAndUnivAndSemesterAndStudent(code,univ,semester,student);
    }

    public List<RegisterLecture> findRegisterLecture(String univ, String student) {
        return registerLectureRepository.findAllByUnivAndStudent(univ, student);
    }

    public RegisterLecture save(RegisterLecture regist) {
        return registerLectureRepository.save(regist);
    }

    public List<RegisterLecture> findLectureList(String semester, String univ, String student_id) {
        return registerLectureRepository.findAllBySemesterAndUnivAndStudent(semester,univ,student_id);
    }
}
