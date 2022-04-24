package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Dto.LectureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.modoosugang_be.Service.LectureService;
import com.example.modoosugang_be.Utils.CsvUtils;

import java.util.*;
@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class LectureController {
    private final LectureService LectureService;

    @PostMapping("/manage/upload/timetable")
    public int UploadLecture() throws NumberFormatException {
        List<Lecture> lectureList = new ArrayList<>();
        String path = "C:\\Users\\min\\Desktop\\csvFile\\doc.txt";
        List<List<String>> list = CsvUtils.readToList(path);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                String id = list.get(i).get(1);
                String proid = list.get(i).get(2);
                String name = list.get(i).get(3);
                String major = list.get(i).get(6);
                String classes = list.get(i).get(7);
                String room = list.get(i).get(8);
                String semester = list.get(i).get(9);
                String proname = list.get(i).get(10);
                String time = list.get(i).get(11);
                String classify = list.get(i).get(12);
                String univ = "카카오대학교";
                int idx = Integer.parseInt(list.get(i).get(0));
                System.out.println(Integer.parseInt(list.get(i).get(0).getClass().getName()));
                int limit = Integer.parseInt(list.get(i).get(4));
                int credit = Integer.parseInt(list.get(i).get(5));
                LectureDto lectureDto = LectureDto.builder().name(name).credit(credit).limit(limit).classes(classes).major(major).room(room).semester(semester)
                        .index(idx).univ(univ).time(time).professorId(proid).lectureId(id).classify(classify).professor(proname).build();
                lectureList.add(lectureDto.toLecture());
                /*}catch(NumberFormatException e){
                    e.printStackTrace();
                }*/

            }
        }

        return LectureService.setUpdateLecture(lectureList);
    }
}

    /*public int UploadLecture( @ModelAttribute Map<String, Object> param) {
        //ArrayList<String> lectureData = new ArrayList<String>();
        String path = "C:\\Users\\min\\Desktop\\csvFile\\doc.txt";
        List<List<String>> list = CsvUtils.readToList(path);
        ArrayList<String> miniList = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        for(int i=0; i<list.size(); i++) {
            line = list.get(i);
            for(int j=0; j<line.size(); j++) {
                System.out.print(line.get(j)+",");
                miniList.add(line.get(j));
                System.out.println(miniList);

            }

//line.get(j)
            System.out.println();
        }
          //return lectureService.setUpdateLecture(id, proid, name, limit, credit, major, classes, room, semester, proname, time, classify, univ);

       return ;


   /* public int UploadLecture( @ModelAttribute Map<String, Object> param) {
        String id = param.get("id").toString();
        String proid = param.get("proid").toString();
        String name = param.get("name").toString();
        int limit = (int) param.get("limit");
        int credit = (int)param.get("credit");
        String major = param.get("major").toString();
        String classes = param.get("classes").toString();
        String room = param.get("room").toString();
        String semester = param.get("semester").toString();
        String proname = param.get("proname").toString();
        String time = param.get("time").toString();
        String classify = param.get("classify").toString();
        String univ = param.get("univ").toString();

        return lectureService.setUpdateLecture(id, proid, name, limit, credit, major, classes, room, semester, proname, time, classify, univ);
    }

    /*public List searchLectures(@PathVariable(name = "univ") String univ){

        List<Lecture> lectures = lectureService.callUnivLecture(univ);
        List list = new ArrayList();

        for (Lecture lecture : lectures) {
            JSONObject data = new JSONObject();

            data.put("lecture_id", lecture.getId());
            data.put("professor_id", lecture.getProid());
            data.put("lecture_name", lecture.getName());
            data.put("lecture_limit", lecture.getLimit());
            data.put("lecture_credit", lecture.getCredit());
            data.put("lecture_major", lecture.getMajor());
            data.put("lecture_class", lecture.getClasses());
            data.put("lecture_room", lecture.getRoom());
            data.put("lecture_semester", lecture.getSemester());
            data.put("lecture_professor", lecture.getProname());
            data.put("lecture_time", lecture.getTime());
            data.put("lecture_classify", lecture.getClassify());
            data.put("university_name", lecture.getUniv());


            list.add(data);
        }
        System.out.println(list);
        return list;
    }*/
        /*public ArrayList<HashMap<String, Object>> UploadLecture(HttpServletRequest req) throws Exception{

        //response Data
        ArrayList<HashMap<String, Object>> lectureList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> lectureMap = new HashMap<String, Object>();

        lectureMap.put("lecture_id", req.getParameter("id"));
        lectureMap.put("professor_id", req.getParameter("fileName"));
        lectureMap.put("lecture_name", req.getParameter("name"));
        lectureMap.put("lecture_limit", req.getParameter("limit"));
        lectureMap.put("lecture_credit", req.getParameter("credit"));
        lectureMap.put("lecture_major", req.getParameter("major"));
        lectureMap.put("lecture_classes", req.getParameter("classes"));
        lectureMap.put("lecture_room", req.getParameter("room"));
        lectureMap.put("lecture_semester", req.getParameter("semester"));
        lectureMap.put("lecture_professor", req.getParameter("proname"));
        lectureMap.put("lecture_time", req.getParameter("time"));
        lectureMap.put("lecture_classify", req.getParameter("classfiy"));
        lectureMap.put("university_name", req.getParameter("univ"));
        lectureList.add(lectureMap);
        return lectureList;
        //return lectureService.setUpdateLecture(id, proid, name, limit, credit, major, classes, room, semester, proname, time, classify, univ);

    }*/


