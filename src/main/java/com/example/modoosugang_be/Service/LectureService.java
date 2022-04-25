package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public List<Lecture>callUnivLecture(String univ) {
        List<Lecture> lectures = lectureRepository.findLecture(univ);
        return lectures;
    }

    public Lecture callLecutureByUnivAndId(String univ, String id) {
        return lectureRepository.findLectureByUnivAndID(univ, id);
    }

    public List<Lecture> findLectureList(String semester) {
        List<Lecture> logs = lectureRepository.findAllBySemester(semester);
        return logs;
    }

    public Optional<Lecture> findRemain(Long code) {
        return lectureRepository.findById(code);
    }


    public int setRemain(long code, int inputRemain) {
        return lectureRepository.updateRemain(code, inputRemain);

    }

}
