package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Service.CsvService;
import com.example.modoosugang_be.Service.LectureService;
import com.example.modoosugang_be.Utils.CsvUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LectureController {
    private final CsvService csvService;

//    @PostMapping("/manage/upload/timetable")
//    public void UploadLecture(@RequestBody Map<String, Object> param) throws NumberFormatException {
//        String path = param.get("url").toString();
//        List<List<String>> list = CsvUtils.readToList(path);
//
//        for (int i = 1; i < list.size(); i++) {
//            Lecture l = new Lecture();
//            l.setIdx(Integer.parseInt(list.get(i).get(0)));
//            l.setFirstsch(list.get(i).get(1));
//            l.setSecondsch(list.get(i).get(2));
//            l.setProfessor(list.get(i).get(3));
//            l.setId(list.get(i).get(4));
//            l.setName(list.get(i).get(5));
//            l.setLimit(Integer.parseInt(list.get(i).get(6)));
//            l.setCredit(Integer.parseInt(list.get(i).get(7)));
//            l.setMajor(list.get(i).get(8));
//            l.setClasses(list.get(i).get(9));
//            l.setRoom(list.get(i).get(10));
//            l.setSemester(list.get(i).get(11));
//            l.setProname(list.get(i).get(12));
//            l.setTime(list.get(i).get(13));
//            l.setClassify(list.get(i).get(14));
//
//            LectureService.setUpdateLecture(l);
//        }
//    }

    @PostMapping(value = "/manage/upload/timetable", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void UploadLecture(@RequestParam("file") MultipartFile file, @RequestParam("univ") String univ) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getClass());
        System.out.println(file.getResource());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(univ);

        csvService.saveLectures(file);
    }
}