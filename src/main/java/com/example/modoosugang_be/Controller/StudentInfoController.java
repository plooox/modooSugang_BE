package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Student;
import com.example.modoosugang_be.Service.StudentInfoService;
import com.example.modoosugang_be.Utils.CsvUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.text.ParseException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class StudentInfoController {
    private final StudentInfoService StudentInfoService;

    @PostMapping("/manage/upload/studentInfo")
    public int UploadStudentInfo(@RequestBody Map<String, Object> param) throws NumberFormatException, ParseException {
        String path = param.get("url").toString();
        List<List<String>> list = CsvUtils.readToList(path);
        for (int i = 1; i < list.size(); i++) {
            Student s = new Student();
            s.setId(list.get(i).get(0));
            s.setName(list.get(i).get(1));
            java.sql.Date day = new java.sql.Date(Long.parseLong(list.get(i).get(2)));
            s.setBirth(day);
            s.setPhone(list.get(i).get(3));
            s.setMajor(list.get(i).get(4));
            s.setSecond(list.get(i).get(5));
            s.setGrade(new BigDecimal(list.get(i).get(6)));
            s.setEnroll(list.get(i).get(7));
            s.setPw(list.get(i).get(8));
            s.setUniv(list.get(i).get(9));
            StudentInfoService.setUpdateStudent(s);
        }
        return 0;
    }
}