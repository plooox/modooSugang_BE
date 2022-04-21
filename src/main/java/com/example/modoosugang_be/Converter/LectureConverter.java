package com.example.modoosugang_be.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Dto.LectureDto;
import java.util.*;

@Component

public class LectureConverter {

    public LectureDto DomainToDto(Lecture lecture) {
        ModelMapper modelMapper = new ModelMapper();
        LectureDto map = modelMapper.map(lecture, LectureDto.class);
        return map;
    }

    public Lecture dtoToDomain(LectureDto lectureTimeTableDto) {
        ModelMapper modelMapper = new ModelMapper();
        Lecture map = modelMapper.map(lectureTimeTableDto, Lecture.class);
        return map;
    }
   /* public List<Lecture> listsToLectureList(List<List<String>> list) {
        List<Lecture> lectureList = new ArrayList<>();
        for (int i = 1; i <= list.toArray().length - 1; i++) {
            List<String> temp = list.get(i);
            String id = temp.get(0);
            String professor = temp.get();
            String name = temp.get(1);
            String limit = temp.get(2);
            String credit = temp.get(3);
            String major = temp.get(4);
            String classes = temp.get(5);
            String room = temp.get(6);
            String semse = temp.get(7);

            Lecture lecture = new Lecture(id, professor, name, Integer.valueOf(limit).intValue(), Integer.valueOf(credit).intValue(),
                    major, professor, start, end);

            lectureList.add(lecture);
        }
        return lectureList;
    }*/
}


