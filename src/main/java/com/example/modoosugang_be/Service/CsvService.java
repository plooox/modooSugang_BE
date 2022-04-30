package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.Professor;
import com.example.modoosugang_be.Repository.LectureRepository;
import com.example.modoosugang_be.Repository.ProfessorRepository;
import com.example.modoosugang_be.Utils.CsvUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final LectureRepository lectureRepository;
    private final ProfessorRepository professorRepository;

    public void saveLectures(MultipartFile file, String univ) {
        lectureRepository.deleteByUniv(univ);
        try {
            List<Lecture> lectures = CsvUtils.csvToLectures(file.getInputStream());
            List<Professor> professors = CsvUtils.csvToProfessors(file.getInputStream());

            professorRepository.saveAll(professors);
            lectureRepository.saveAll(lectures);
        } catch (IOException e){
            throw new RuntimeException("fail to store csv data" + e.getMessage());
        }
    }
}
