package com.example.modoosugang_be.Service;


import com.example.modoosugang_be.Domain.Schedule;
import com.example.modoosugang_be.Repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public Schedule FindCol(String semester) {
        Optional<Schedule> schedule = scheduleRepository.findBySemester(semester);
        return schedule.orElse(null); // 조회 성공하면 Manager값, 실패시 null
    }

    public void checkSchedule(String univ, String manager, String semester){
        if (scheduleRepository.findByUnivAndSemester(univ, semester).isPresent()){

        } else {
            Schedule schedule = new Schedule();
            schedule.setUniv(univ);
            schedule.setManager(manager);
            schedule.setSemester(semester);

            schedule.setBasketEnd(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            schedule.setBasketStart(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            schedule.setRegisterEnd(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            schedule.setRegisterStart(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            schedule.setModifyEnd(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            schedule.setModifyStart(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            schedule.setCancelEnd(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            schedule.setCancelStart(Timestamp.valueOf("1990-01-01 00:00:00.0"));
            scheduleRepository.save(schedule);
        }
    }

    public int setPeriodBasket(Timestamp start, Timestamp end, String univ, String semester) {
        int schedule = scheduleRepository.updateBasket(start, end, univ, semester);

        return schedule;
    }

    public int setPeriodRegister(Timestamp start, Timestamp end, String univ, String semester) {
        int schedule = scheduleRepository.updateRegister(start, end, univ, semester);

        return schedule;
    }

    public int setPeriodModify(Timestamp start, Timestamp end, String univ, String semester) {
        int schedule = scheduleRepository.updateModify(start, end, univ, semester);

        return schedule;
    }

    public int setPeriodCancel(Timestamp start, Timestamp end, String univ, String semester) {
        int schedule = scheduleRepository.updateCancel(start, end, univ, semester);

        return schedule;
    }


}
