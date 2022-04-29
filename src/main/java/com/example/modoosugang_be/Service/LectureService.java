package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Dto.LectureDto;
import com.example.modoosugang_be.Repository.LectureRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public List<Lecture> callUnivLecture(String univ) {
        List<Lecture> lectures = lectureRepository.findLecture(univ);
        return lectures;
    }

    public int setUpdateLecture(List<Lecture> lecturesList) {
        int lectures = 0;
        for (Lecture lecture :lecturesList){
            lectureRepository.saveAll(lecturesList);
        }

        return lectures;
    }

    public Lecture callLecutureByUnivAndId(String univ, String id) {
        return lectureRepository.findLectureByUnivAndID(univ, id);
    }

}

