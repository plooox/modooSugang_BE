package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Manager;
import com.example.modoosugang_be.Repository.ManagerRepository;
import com.example.modoosugang_be.Service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private final ManagerRepository managerRepository;

    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, Object> param) {
        System.out.println((param));

        Object univ = param.get("univ");
        Object id = param.get("id");
        System.out.println(univ+" & "+id);
        List<Manager> manager = managerRepository.findByUniversityNameAndManagerId(univ, id);
        System.out.println(manager);
        if (manager == null){
            // Cannot find account
            return false;
        }
        else{
            if (manager.get(0).getManagerPw().equals(param.get("password").toString())){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
