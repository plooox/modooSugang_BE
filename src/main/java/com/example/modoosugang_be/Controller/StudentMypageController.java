package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.RegisterBasket;
import com.example.modoosugang_be.Domain.RegisterLecture;
import com.example.modoosugang_be.Service.LectureService;
import com.example.modoosugang_be.Service.RegisterBasketService;
import com.example.modoosugang_be.Service.RegisterLectureService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentMypageController {

    private final RegisterLectureService registerLectureService;
    private final RegisterBasketService registerBasketService;
    private final LectureService lectureService;

    @PostMapping("/student/Mypage")
    public List searchRegisterdLecture(@RequestBody Map<String, Object> param) {
        String univ = param.get("univ").toString();
        String id = param.get("id").toString();
        String semester = param.get("semester").toString();
//        String id = univ + "@" + param.get("id").toString();
        List<RegisterLecture> logs = registerLectureService.findLectureList(semester, univ, id);

        List list = new ArrayList();

        for (RegisterLecture log : logs) {
            Optional<Lecture> OptionalLecture = lectureService.findRemain(log.getIdx());

            JSONObject data = new JSONObject();

            data.put("lecture_id", OptionalLecture.get().getId());
            data.put("lecture_name", OptionalLecture.get().getName());
            data.put("lecture_professor", OptionalLecture.get().getProname());
            data.put("lecture_class", OptionalLecture.get().getClasses());
            data.put("lecture_major", OptionalLecture.get().getMajor());
            data.put("lecture_classify", OptionalLecture.get().getClassify());
            data.put("lecture_time", OptionalLecture.get().getTime());
            data.put("lecture_room", OptionalLecture.get().getRoom());
            data.put("lecture_classroom", OptionalLecture.get().getClasses());
            data.put("lecture_credit", OptionalLecture.get().getCredit());
            data.put("lecture_first_sch", OptionalLecture.get().getFirstsch());
            data.put("lecture_second_sch", OptionalLecture.get().getSecondsch());
            data.put("lecture_idx", log.getIdx());


            list.add(data);
        }

        System.out.println((list));
        return list;
    }



    @PostMapping("/student/Mypage/Basket")
    public List searchRegisterdBasket(@RequestBody Map<String, Object> param) {
        String univ = param.get("univ").toString();
        String id = param.get("id").toString();
        String semester = param.get("semester").toString();
//        String id = univ + "@" + param.get("id").toString();
        List<RegisterBasket> logs = registerBasketService.findLectureList(univ, id);

        List list = new ArrayList();

        for (RegisterBasket log : logs) {
            Optional<Lecture> OptionalLecture = lectureService.findRemain(log.getIdx());

            JSONObject data = new JSONObject();

            data.put("lecture_id", OptionalLecture.get().getId());
            data.put("lecture_name", OptionalLecture.get().getName());
            data.put("lecture_professor", OptionalLecture.get().getProname());
            data.put("lecture_class", OptionalLecture.get().getClasses());
            data.put("lecture_major", OptionalLecture.get().getMajor());
            data.put("lecture_classify", OptionalLecture.get().getClassify());
            data.put("lecture_time", OptionalLecture.get().getTime());
            data.put("lecture_room", OptionalLecture.get().getRoom());
            data.put("lecture_classroom", OptionalLecture.get().getClasses());
            data.put("lecture_credit", OptionalLecture.get().getCredit());
            data.put("lecture_first_sch", OptionalLecture.get().getFirstsch());
            data.put("lecture_second_sch", OptionalLecture.get().getSecondsch());
            data.put("lecture_idx", log.getIdx());


            list.add(data);
        }

        System.out.println((list));
        return list;
    }



}

//
//
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//public class StudentMypageController {
//
//    private final RegisterLectureService registerLectureService;
//    private final LectureService lectureService;
//
//    @PostMapping("/student/Mypage")
//    public List searchRegisterdLecture(@RequestBody Map<String, Object> param) {
//        String univ = param.get("univ").toString();
//        String id = param.get("id").toString();
////        String id = univ + "@" + param.get("id").toString();
//        List<RegisterLecture> registerLectures = registerLectureService.findRegisterLecture(univ, id);
//
//        List list = new ArrayList();
//
//        for (RegisterLecture registerLecture : registerLectures) {
//            Lecture lecture = lectureService.callLecutureByUnivAndId(univ, registerLecture.getLecture());
//
//            JSONObject data = new JSONObject();
////
////            data.put("lecture_id", lecture.getId());
//            data.put("lecture_name", lecture.getName());
////            data.put("lecture_professor", lecture.getProname());
////            data.put("lecture_class", lecture.getClasses());
////            data.put("lecture_major", lecture.getMajor());
////            data.put("lecture_classify", lecture.getClassify());
////            data.put("lecture_time", lecture.getTime());
////            data.put("lecture_room", lecture.getRoom());
////            data.put("lecture_classroom", lecture.getClasses());
////            data.put("lecture_credit", lecture.getCredit());
////            data.put("lecture_first_sch", lecture.getFirstsch());
////            data.put("lecture_second_sch", lecture.getSecondsch());
////            data.put("lecture_idx", lecture.getIdx());
////
////            list.add(data);
//        }
//
//        System.out.println((list));
//        return list;
//    }
//
//}
