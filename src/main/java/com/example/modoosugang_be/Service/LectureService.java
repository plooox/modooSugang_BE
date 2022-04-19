package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public List<Lecture>callUnivLecture(String univ) {
        System.out.println("Service: "+univ);
        List<Lecture> lectures = lectureRepository.findLecture(univ);

        return lectures;
    }
}
