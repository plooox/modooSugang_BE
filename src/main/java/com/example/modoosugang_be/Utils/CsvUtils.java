package com.example.modoosugang_be.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.Professor;


import java.io.InputStream;
import java.io.InputStreamReader;
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
}

