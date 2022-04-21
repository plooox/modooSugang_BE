package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.modoosugang_be.Service.LectureService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class LectureController {
    private final LectureService lectureService;

    @PostMapping("/manage/upload/timetable")
    public int UploadLecture(@RequestBody Map<String, Object> param) {
        String id = param.get("id").toString();
        String proid = param.get("proid").toString();
        String name = param.get("name").toString();
        int limit = (int) param.get("limit");
        int credit = (int)param.get("credit");
        String major = param.get("major").toString();
        String classes = param.get("classes").toString();
        String room = param.get("room").toString();
        String semester = param.get("semester").toString();
        String proname = param.get("proname").toString();
        String time = param.get("time").toString();
        String classify = param.get("classify").toString();
        String univ = param.get("univ").toString();

        return lectureService.setUpdateLecture(id, proid, name, limit, credit, major, classes, room, semester, proname, time, classify, univ);
    }
}