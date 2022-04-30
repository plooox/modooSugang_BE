package com.example.modoosugang_be.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.modoosugang_be.Service.StudentInfoService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class StudentInfoController {
    private final StudentInfoService studentInfoService;

    @PostMapping(value = "/manage/upload/studentInfo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void UploadStudentInfo(@RequestParam("file") MultipartFile file, @RequestParam("univ") String univ) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getClass());
        System.out.println(file.getResource());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(univ);
    }
}