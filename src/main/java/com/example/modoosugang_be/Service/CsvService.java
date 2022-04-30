package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.Professor;
import com.example.modoosugang_be.Domain.Schedule;
import com.example.modoosugang_be.Domain.Student;
import com.example.modoosugang_be.Repository.LectureRepository;
import com.example.modoosugang_be.Repository.ProfessorRepository;
import com.example.modoosugang_be.Repository.ScheduleRepository;
import com.example.modoosugang_be.Repository.StudentRepository;
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
    private final StudentRepository studentRepository;
    private final ScheduleRepository scheduleRepository;

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

    public void saveStudent(MultipartFile file, String univ) {
        studentRepository.deleteByUniv(univ);
        try {
            List<Student> students = CsvUtils.csvToStudents(file.getInputStream());
            List<Schedule> schedules = scheduleRepository.findAllByUniv(univ);

            int schNum = 0;
            for (Schedule schedule : schedules) {
                if (schNum < schedule.getId()) {
                    schNum = schedule.getId();
                }
            }

            for (Student student : students) {
                student.setSch(schNum);
            }
            studentRepository.saveAll(students);

        } catch (IOException e){
            throw new RuntimeException("fail to store csv data" + e.getMessage());
        }
    }
}
