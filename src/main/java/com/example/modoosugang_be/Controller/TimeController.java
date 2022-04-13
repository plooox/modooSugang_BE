package com.example.modoosugang_be.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.TimeZone;

@RestController
@RequestMapping("/api")
public class TimeController {

    @PostConstruct
    void SetTimezone(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }


    @PostMapping("/timer")
    public String timer (HttpServletRequest request){

//        System.out.println("Hello");
        return (new Date()).toString();
    }
}
