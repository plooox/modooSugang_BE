package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.RegisterLecture;
import com.example.modoosugang_be.Repository.RegisterLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterBasketService {

    private final RegisterLectureRepository registerLectureRepository;


    public RegisterLecture save(RegisterLecture regist) {
        return registerLectureRepository.save(regist);
    }
}
