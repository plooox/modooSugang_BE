package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Repository.LectureRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public List<Lecture> callUnivLecture(String univ) {
        List<Lecture> lectures = lectureRepository.findLecture(univ);
        return lectures;
    }

    public void setUpdateLecture(Lecture lecture){
        lectureRepository.save(lecture);
    //lectureRepository.UpdateLecture(id, professor, name, limit, credit, major, classes, room, semester, proname, time, classify, univ, idx);
    }

    public Lecture callLecutureByUnivAndId(String univ, String id) {
        return lectureRepository.findLectureByUnivAndID(univ, id);
    }

    public Lecture callLectureByUnivAndIdx(String univ, int idx) {
        return lectureRepository.findLectureByUnivAndIdx(univ, idx);
    }

    public List<Lecture> findLectureList(String semester) {
        List<Lecture> logs = lectureRepository.findAllBySemester(semester);
        return logs;
    }

    public Optional<Lecture> findRemain(int idx) {
        return lectureRepository.findByIdx(idx);

    }

    public int setRemain(int code, int inputRemain) {
        return lectureRepository.updateRemain(code, inputRemain);

    }

}
