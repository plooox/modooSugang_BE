package com.example.modoosugang_be.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.Professor;


import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.modoosugang_be.Domain.Student;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CsvUtils {
    public static String TYPE = "text/csv";
    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<Lecture> csvToLectures(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Lecture> lectures = new ArrayList<Lecture>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Lecture lecture = new Lecture();
                lecture.setFirstsch(csvRecord.get("first_schedule"));
                lecture.setSecondsch(csvRecord.get("second_schedule"));
                lecture.setProfessor(csvRecord.get("professor_id"));
                lecture.setId(csvRecord.get("lecture_id"));
                lecture.setName(csvRecord.get("lecture_name"));
                lecture.setLimit(Integer.parseInt(csvRecord.get("lecture_limit")));
                lecture.setCredit(Integer.parseInt(csvRecord.get("lecture_credit")));
                lecture.setMajor(csvRecord.get("lecture_major"));
                lecture.setClasses(csvRecord.get("lecture_class"));
                lecture.setRoom(csvRecord.get("lecture_room"));
                lecture.setSemester(csvRecord.get("lecture_semester"));
                lecture.setProname(csvRecord.get("lecture_professor"));
                lecture.setTime(csvRecord.get("lecture_time"));
                lecture.setClassify(csvRecord.get("lecture_classify"));
                lecture.setRemain(Integer.parseInt(csvRecord.get("lecture_remain")));

                lectures.add(lecture);
            }
            return lectures;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Professor> csvToProfessors(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Professor> professors = new ArrayList<Professor>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Professor professor = new Professor();

                professor.setId(csvRecord.get("professor_id"));
                professor.setName(csvRecord.get("lecture_professor"));
                professor.setEmail(csvRecord.get("professor_email"));
                professor.setMajor(csvRecord.get("professor_major"));

                professors.add(professor);
            }
            return professors;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Student> csvToStudents(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Student> students = new ArrayList<Student>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Student student = new Student();

                student.setId(csvRecord.get("student_id"));
                student.setUniv(csvRecord.get("univ_name"));
                student.setName(csvRecord.get("student_name"));
                student.setGrade(csvRecord.get("student_year"));
                student.setBirth(Date.valueOf(csvRecord.get("student_birth")));
                student.setPhone(csvRecord.get("student_phone"));
                student.setMajor(csvRecord.get("student_major"));
                student.setSecond(csvRecord.get("student_second_major"));
                student.setScore(BigDecimal.valueOf(Double.valueOf(csvRecord.get("student_grade"))));
                student.setEnroll(csvRecord.get("student_enroll"));
                student.setCredit(Integer.parseInt(csvRecord.get("student_credit")));
                student.setPw(csvRecord.get("student_pw"));

                students.add(student);
            }
            return students;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}

