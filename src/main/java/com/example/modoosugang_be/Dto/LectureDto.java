package com.example.modoosugang_be.Dto;
import lombok.*;
@Builder
@Data
@AllArgsConstructor

public class LectureDto {
    private int index;
    private String lecture_id;
    private String professor_id;
    private String lecture_name;
    private int  lecture_limit;
    private int  lecture_credit;
    private String  lecture_major;
    private String  lecture_classes;
    private String  lecture_room;
    private String  lecture_semester;
    private String  lecture_professor;
    private String  lecture_time;
    private String  lecture_classify;
    private String  univ_name;
}