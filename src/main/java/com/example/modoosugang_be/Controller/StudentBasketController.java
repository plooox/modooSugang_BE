package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.RegisterLecture;
import com.example.modoosugang_be.Service.LectureService;
import com.example.modoosugang_be.Service.RegisterBasketService;
import com.example.modoosugang_be.Service.RegisterLectureService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class StudentBasketController {

    private final RegisterBasketService registerBasketService;
    private final LectureService lectureService;
//
//    @PostMapping("/student/entroll/basket_list/'")
//    public List BasketTable(@RequestBody Map<String, Object> param) {
//        String student = param.get("id").toString();
//
//        List<RegisterLecture> baskets = registerBasketService.findBasketList(student);
//        //List<Lecture> lectures
//        List list = new ArrayList();
//        for (RegisterLecture basket : baskets){
//            JSONObject data = new JSONObject();
//            // Create Json Array
//            data.put("code", basket.getIdx());
//            data.put("lecture", basket.getIdx());
//            data.put("catrgory", basket.getIdx());
//            data.put("time", basket.getIdx());
//            data.put("professor", basket.getIdx());
//            data.put("classroom", basket.getIdx());
//            data.put("score", basket.getIdx());
//
//            list.add(data);
//        }
//        System.out.println("==================");
//        System.out.println(list);
//
//
//        return list;
//
//    }

    // 장바구니 신청 구현할때 오픈
//    @PostMapping("")
//    public boolean Applybasket(@RequestBody Map<String, Object> param) {
//
//    }
}
