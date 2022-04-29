package com.example.modoosugang_be.Controller;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.example.modoosugang_be.Domain.Student;
import com.example.modoosugang_be.Service.StudentInfoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class ManagerStudentController {
    private final StudentInfoService studentInfoService;

    @GetMapping("/manage/info/{univ}")
    public List searchStudents(@PathVariable(name = "univ") String univ){

        List<Student> students = studentInfoService.callUnivStudent(univ);
        List list = new ArrayList();

        for (Student student : students) {
            JSONObject data = new JSONObject();

            data.put("student_id", student.getId());
            data.put("student_name", student.getName());
            data.put("student_birth", student.getBirth());
            data.put("student_phone", student.getPhone());
            data.put("student_major", student.getMajor());
            data.put("student_second", student.getSecond());
            data.put("student_grade", student.getGrade());
            data.put("student_enroll", student.getEnroll());
            data.put("student_credit", student.getCredit());


            list.add(data);
        }
        System.out.println(list);
        return list;
    }
}


