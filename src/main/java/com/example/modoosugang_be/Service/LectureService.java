package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Repository.LectureRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public List<Lecture> callUnivLecture(String univ) {
        List<Lecture> lectures = lectureRepository.findLecture(univ);
        return lectures;
    }

    public Lecture callLecutureByUnivAndId(String univ, String id) {
        return lectureRepository.findLectureByUnivAndID(univ, id);
    }

}

