package com.example.modoosugang_be.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentSearchController {

    @GetMapping("/student/search")
    public void searchLectures(@RequestParam(value = "univ")String univ){
        System.out.println(univ);

    }

}
