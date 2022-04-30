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

    @PostMapping(value = "/manage/upload/timetable", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void UploadLecture(@RequestParam("file") MultipartFile file, @RequestParam("univ") String univ) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getClass());
        System.out.println(file.getResource());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(univ);

        csvService.saveLectures(file, univ);
    }
}