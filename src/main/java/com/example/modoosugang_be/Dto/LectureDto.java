package com.example.modoosugang_be.Dto;
import lombok.*;
@Builder
@Data
@AllArgsConstructor

public class LectureDto {
    private int index;
    private String name;
    private int limit;
    private int credit;
    private String major;
    private String professor;
    private String start;
    private String end;
}