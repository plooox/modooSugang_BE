package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.RegisterLecture;
import com.example.modoosugang_be.Repository.RegisterLectureRepository;
import com.example.modoosugang_be.Service.LectureService;
import com.example.modoosugang_be.Service.RegisterLectureService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class StudentEnrollController {

    private final LectureService lectureService;
    private final RegisterLectureService registerLectureService;

    @PostMapping("/student/enroll/lecture_list")
    public List LectureTable(@RequestBody Map<String, Object> param) {
        String semester = param.get("semester").toString();
        List<Lecture> logs = lectureService.findLectureList(semester);
        List list = new ArrayList();
        for (Lecture log : logs) {
            JSONObject data = new JSONObject();

            // Create Json Array
            data.put("index", log.getIdx());
            data.put("name", log.getName());
            data.put("major", log.getMajor());
            data.put("classify", log.getClassify());
            data.put("time", log.getTime());
            data.put("classes", log.getClasses());
            data.put("credit", log.getCredit());

            String remain = String.valueOf(log.getRemain());
            String limit = String.valueOf(log.getLimit());
            String remaining = remain + "/" + limit;
            data.put("remaining", remaining);

            list.add(data);
        }
        System.out.println("1번테이블 ==================");
        System.out.println(list);

        return list;
    }

    @PostMapping("/student/enroll/apply/lecture")
    public boolean ApplyLecture(@RequestBody Map<String, Object> param) {
        System.out.println((param)); //  {id=1, code=1010}

        String id = param.get("id").toString();
        String code = param.get("code").toString();
        String univ = param.get("univ").toString();
//        String semester = param.get("semester").toString();
String semester = "2022_1";
        // code 값으로 lecture 테이블 remain 잔여확인
        Optional<Lecture> OptionalLecture = lectureService.findRemain(Long.valueOf(code));
        int isRemain = OptionalLecture.get().getRemain();
        System.out.println((isRemain));

        String lecture_id = OptionalLecture.get().getId();
        int schedule = 1; // 스케쥴 부분 타입 확인 필요
        String student_id = "21611868"; // 일단 임의설정


        if (isRemain > 0) {
            int InputRemain = isRemain - 1; // 잔여인원 차감
            lectureService.setRemain(Long.valueOf(code), InputRemain); // 차감된 인원 DB update
            // Register_lecture에 학생정보 적용
            RegisterLecture regist = new RegisterLecture();

            regist.setId(OptionalLecture.get().getIdx()); // register_lecture_id : ??
            regist.setIdx(Long.valueOf(code)); // lecture_index : 강의code ?
            regist.setLecture(OptionalLecture.get().getRoom());
            regist.setStudent(student_id);
            regist.setSemester(semester);
            regist.setSchedule(String.valueOf(schedule));
            regist.setUniv(univ);

            registerLectureService.save(regist);

            return true;
        } else {
            return false;
        }
    }


    @PostMapping("/student/enroll/myenroll/")
    public List MyEnrollList(@RequestBody Map<String, Object> param) {
        System.out.println((param)); //  {id=1, code=1010}

//        String id = param.get("id").toString();
//        String code = param.get("code").toString();
        String student_id = param.get("id").toString();
        String univ = param.get("univ").toString();
        String semester = param.get("semester").toString();

        int code = 1010;

        List<RegisterLecture> logs = registerLectureService.findLectureList(semester, univ, student_id);
        List list = new ArrayList();
        for (RegisterLecture log : logs) {
            Optional<Lecture> OptionalLecture = lectureService.findRemain(log.getIdx());

            JSONObject data = new JSONObject();

            // Create Json Array
            data.put("index", log.getIdx());
            data.put("name", OptionalLecture.get().getName());
            data.put("major", OptionalLecture.get().getMajor());
            data.put("classify", OptionalLecture.get().getClassify());
            data.put("time", OptionalLecture.get().getTime());
            data.put("classes",OptionalLecture.get().getClasses());
            data.put("credit", OptionalLecture.get().getCredit());


            list.add(data);
        }

        return list;
    }


    @PostMapping("/student/enroll/drop/lecture")
    public boolean DropLecture(@RequestBody Map<String, Object> param) {
        System.out.println((param));

        long id = Long.parseLong(param.get("id").toString()); // g
        Long code = Long.valueOf(param.get("code").toString());
        String univ = param.get("univ").toString();
        String semester = param.get("semester").toString();
        String student = param.get("student").toString();


        registerLectureService.DeleteLecture(code, univ, semester, student);

        return true;

    }


    @PostMapping("/student/enroll/lecture_list/recommend")
    public List RecommendLectureTable(@RequestBody Map<String, Object> param) {
        String semester = param.get("semester").toString();
        List<Lecture> logs = lectureService.findLectureList(semester);
        List list = new ArrayList();
        for (Lecture log : logs) {
            JSONObject data = new JSONObject();

            // Create Json Array
            data.put("index", log.getIdx());
//            data.put("name", log.getName());
            data.put("name", "하이하이");
            data.put("major", log.getMajor());
            data.put("classify", log.getClassify());
            data.put("time", log.getTime());
            data.put("classes", log.getClasses());
            data.put("credit", log.getCredit());
            list.add(data);
        }
        System.out.println("1번테이블 ==================");
        System.out.println(list);

        return list;
    }
}
