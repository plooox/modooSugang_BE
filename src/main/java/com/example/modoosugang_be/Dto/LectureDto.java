package com.example.modoosugang_be.Dto;
import com.example.modoosugang_be.Domain.Lecture;
import lombok.*;

@Builder
@Data
@AllArgsConstructor

public class LectureDto {
    private int index;
    private String lectureId;
    private String professorId;
    private String name;
    private int  limit;
    private int  credit;
    private String  major;
    private String  classes;
    private String  room;
    private String  semester;
    private String  professor;
    private String  time;
    private String  classify;
    private String  univ;
    public Lecture toLecture (){
        return Lecture.builder().index(index).id(lectureId).proid(professorId).name(name).limit(limit).credit(credit).major(major)
                .classes(classes).room(room).semester(semester).proname(professor).time(time).classify(classify).univ(univ).build();
    }
}