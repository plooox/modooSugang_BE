package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Service.LectureService;
import com.example.modoosugang_be.Utils.CsvUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LectureController {
    private final LectureService LectureService;

    @PostMapping("/manage/upload/timetable")
    public int UploadLecture(@RequestBody Map<String, Object> param) throws NumberFormatException {
        String path = param.get("url").toString();
        List<List<String>> list = CsvUtils.readToList(path);

        for (int i = 1; i < list.size(); i++) {
            Lecture l = new Lecture();
            l.setIdx(Integer.parseInt(list.get(i).get(0)));
            l.setProfessor(list.get(i).get(1));
            l.setId(list.get(i).get(2));
            l.setName(list.get(i).get(3));
            l.setLimit(Integer.parseInt(list.get(i).get(4)));
            l.setCredit(Integer.parseInt(list.get(i).get(5)));
            l.setMajor(list.get(i).get(6));
            l.setClasses(list.get(i).get(7));
            l.setRoom(list.get(i).get(8));
            l.setSemester(list.get(i).get(9));
            l.setProname(list.get(i).get(10));
            l.setTime(list.get(i).get(11));
            l.setClassify(list.get(i).get(12));
            l.setUniv(list.get(i).get(13));
            LectureService.setUpdateLecture(l);
        }
        return 0;
    }
}