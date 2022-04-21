package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Repository.LectureRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public List<Lecture> findAllLecture() {
        return lectureRepository.findAll();
    }

    public List<Lecture> callUnivLecture(String univ) {
        List<Lecture> lectures = lectureRepository.findLecture(univ);
        return lectures;
    }

    public int setUpdateLecture(String id, String proid, String name, int limit, int credit, String major, String classes, String room, String semester, String proname, String time, String classify, String univ) {
        int lectures = lectureRepository.UpdateLecture(id, proid, name, limit, credit, major, classes, room, semester, proname, time, classify, univ);

        return lectures;
    }
}

