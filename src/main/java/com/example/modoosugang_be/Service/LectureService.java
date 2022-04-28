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

    public List<Lecture> callUnivLecture(String univ) {
        List<Lecture> lectures = lectureRepository.findLecture(univ);
        return lectures;
    }

<<<<<<< HEAD
    public void setUpdateLecture(Lecture lecture){
        lectureRepository.save(lecture);
    //lectureRepository.UpdateLecture(id, professor, name, limit, credit, major, classes, room, semester, proname, time, classify, univ, idx);
    }
=======
    public Lecture callLecutureByUnivAndId(String univ, String id) {
        return lectureRepository.findLectureByUnivAndID(univ, id);
    }

>>>>>>> a67c5f0f5c698fb33d699f02a68307ec669a3b06
}

