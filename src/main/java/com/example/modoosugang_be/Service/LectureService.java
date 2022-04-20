package com.example.modoosugang_be.Service;

import org.springframework.transaction.annotation.Transactional;
import com.example.modoosugang_be.Converter.LectureConverter;
import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Dto.LectureDto;
import com.example.modoosugang_be.Repository.LectureRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final LectureConverter lectureConverter;

    public List<Lecture> findAllLecture() {
        return lectureRepository.findAll();
    }
    public List<Lecture>callUnivLecture(String univ) {
        List<Lecture> lectures = lectureRepository.findLecture(univ);
        return lectures;
    }

    //적재
    @Transactional
    public Lecture putLectureDto(LectureDto lectureDto) {
        Lecture lecture = lectureConverter.dtoToDomain(lectureDto);
        lecture = lectureRepository.save(lecture);
        return lecture;
    }

    @Transactional
    public void putLectureDomain(Lecture lecture) {
        lectureRepository.save(lecture);
    }
}


