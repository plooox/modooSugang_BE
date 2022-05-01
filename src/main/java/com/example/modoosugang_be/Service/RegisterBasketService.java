package com.example.modoosugang_be.Service;

import com.example.modoosugang_be.Domain.Lecture;
import com.example.modoosugang_be.Domain.RegisterBasket;
import com.example.modoosugang_be.Domain.RegisterLecture;
import com.example.modoosugang_be.Repository.RegisterBasketRepository;
import com.example.modoosugang_be.Repository.RegisterLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterBasketService {

    private final RegisterLectureRepository registerLectureRepository;
    private final RegisterBasketRepository registerBasketRepository;


    public RegisterBasket save(RegisterBasket regist)  {
        return registerBasketRepository.save(regist);
    }

    public List<RegisterLecture> findBasketList(String student) {
        List<RegisterLecture> logs = registerLectureRepository.findAllByStudent(student);
        return logs;
    }

    // 장바구니 리스트 반환
    public List<RegisterBasket> findLectureList(String univ, String student) {
        return registerBasketRepository.findAllByUnivAndStudent(univ,student);
    }

    public List<RegisterBasket> DeleteBasket(int code, String univ, String student) {
        return registerBasketRepository.deleteRegisterLectureByIdxAndUnivAndStudent(code,univ,student);
    }

}
