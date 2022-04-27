package com.example.modoosugang_be.Repository;

import com.example.modoosugang_be.Domain.RegisterBasket;
import com.example.modoosugang_be.Domain.RegisterLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterBasketRepository extends JpaRepository<RegisterBasket, Long> {

    List<RegisterBasket> findAllByUnivAndStudent(String univ, String student);
}
