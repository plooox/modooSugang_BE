package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.modoosugang_be.Service.LectureService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LectureController {
    @Autowired LectureService lectureService;

    @PostMapping("/lecture")
    public List<Lecture> lectureList() {
        List<Lecture> lectureList = lectureService.findAllLecture(); //univ별 강의?
        return lectureList;
    }
}
//전체 강의 반환