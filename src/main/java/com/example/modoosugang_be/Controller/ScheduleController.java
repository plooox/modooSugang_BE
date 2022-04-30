package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;


@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleservice;

    @PostMapping("/manager/FormPeriod/basket")
    public int PeriodBasket(@RequestBody Map<String, Object> param) {
        String univ = param.get("univ").toString();
        String manager = univ+"@"+param.get("id").toString();
        String semester = param.get("semester").toString();

        // Schedule 표 있는지 체크하고, 없으면 초기화
        scheduleservice.checkSchedule(univ, manager, semester);

        String start = param.get("start").toString();
        start = start.replace("T", " ") + ":00.0";
        Timestamp startTs = Timestamp.valueOf(start);
        String end = param.get("end").toString();
        end = end.replace("T", " ") + ":00.0";
        Timestamp endTs = Timestamp.valueOf(end);

        return scheduleservice.setPeriodBasket(startTs,endTs,univ,semester);
    }

    @PostMapping("/manager/FormPeriod/register")
    public int PeriodRegister(@RequestBody Map<String, Object> param) {

        String univ = param.get("univ").toString();
        String manager = univ+"@"+param.get("id").toString();
        String semester = param.get("semester").toString();

        // Schedule 표 있는지 체크하고, 없으면 초기화
        scheduleservice.checkSchedule(univ, manager, semester);

        String start = param.get("start").toString();
        start = start.replace("T", " ") + ":00.0";
        Timestamp startTs = Timestamp.valueOf(start);
        String end = param.get("end").toString();
        end = end.replace("T", " ") + ":00.0";
        Timestamp endTs = Timestamp.valueOf(end);

        return scheduleservice.setPeriodRegister(startTs,endTs,univ,semester);

    }

    @PostMapping("/manager/FormPeriod/modify")
    public int PeriodModify(@RequestBody Map<String, Object> param) {

        String univ = param.get("univ").toString();
        String manager = univ+"@"+param.get("id").toString();
        String semester = param.get("semester").toString();

        // Schedule 표 있는지 체크하고, 없으면 초기화
        scheduleservice.checkSchedule(univ, manager, semester);

        String start = param.get("start").toString();
        start = start.replace("T", " ") + ":00.0";
        Timestamp startTs = Timestamp.valueOf(start);
        String end = param.get("end").toString();
        end = end.replace("T", " ") + ":00.0";
        Timestamp endTs = Timestamp.valueOf(end);

        return scheduleservice.setPeriodModify(startTs,endTs,univ,semester);

    }

    @PostMapping("/manager/FormPeriod/cancel")
    public int PeriodCancle(@RequestBody Map<String, Object> param) {

        String univ = param.get("univ").toString();
        String manager = univ+"@"+param.get("id").toString();
        String semester = param.get("semester").toString();

        // Schedule 표 있는지 체크하고, 없으면 초기화
        scheduleservice.checkSchedule(univ, manager, semester);

        String start = param.get("start").toString();
        start = start.replace("T", " ") + ":00.0";
        Timestamp startTs = Timestamp.valueOf(start);
        String end = param.get("end").toString();
        end = end.replace("T", " ") + ":00.0";
        Timestamp endTs = Timestamp.valueOf(end);

        return scheduleservice.setPeriodCancel(startTs,endTs,univ,semester);

    }

}
