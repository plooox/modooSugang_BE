package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.modoosugang_be.Service.StudentInfoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class StudentInfoController {
    private final StudentInfoService studentService;

    @PostMapping("/manage/upload/info")
    public int UploadStudentInfo(@RequestBody Map<String, Object> param) {
        String name = param.get("name").toString();
        String birth = param.get("birth").toString();
        String phone = param.get("phone").toString();
        String major = param.get("major").toString();
        String second = param.get("second").toString();
        String grade = param.get("grade").toString();
        String enroll = param.get("enroll").toString();
        int credit = (int)param.get("credit");
        String pw = param.get("pw").toString();
        String univ = param.get("univ").toString();

        return studentService.setUpdateStudent(name, birth, phone, major, second, grade, enroll, credit, pw, univ);
    }
}