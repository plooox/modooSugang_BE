package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Student;
import com.example.modoosugang_be.Utils.CsvUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.modoosugang_be.Service.StudentInfoService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class StudentInfoController {
    private final StudentInfoService studentService;

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
            s.setScore(new BigDecimal(list.get(i).get(6)));
            s.setEnroll(list.get(i).get(7));
            s.setPw(list.get(i).get(8));
            s.setUniv(list.get(i).get(9));
            studentService.setUpdateStudent(s);
        }
        return 0;
    }
}