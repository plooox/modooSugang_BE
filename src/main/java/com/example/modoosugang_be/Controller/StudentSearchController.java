package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Service.LectureService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentSearchController {
    private final LectureService lectureService;

    @PostMapping("/student/class")
    public List searchLectures(@RequestBody Map<String, Object> param){

        String univ = param.get("univ").toString();
        System.out.println(univ);
        List<Lecture> lectures = lectureService.callUnivLecture(univ);
        List list = new ArrayList();

        for (Lecture lecture : lectures) {
            System.out.println(lecture.getId());
            System.out.println(lecture);
            JSONObject data = new JSONObject();

            data.put("lecture_id", lecture.getId());
            data.put("lecture_name", lecture.getName());
            data.put("lecture_professor", lecture.getProname());
            data.put("lecture_class", lecture.getClasses());
            data.put("lecture_major", lecture.getMajor());
            data.put("lecture_classify", lecture.getClassify());
            data.put("lecture_time", lecture.getTime());
            data.put("lecture_room", lecture.getRoom());
            data.put("lecture_credit", lecture.getCredit());
            data.put("lecture_limit", lecture.getLimit());


            list.add(data);
        }
        System.out.println(list);
        return list;
    }
}
