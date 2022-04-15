package com.example.modoosugang_be.Controller;

import com.example.modoosugang_be.Domain.Manager;
import com.example.modoosugang_be.Repository.ManagerRepository;
import com.example.modoosugang_be.Service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/api")
@RequiredArgsConstructor
public class LoginController {

    private final ManagerService managerService;

    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, Object> param) {
        System.out.println((param));

        String univ = param.get("univ").toString();
        String id = param.get("id").toString();
        String pw = param.get("password").toString();

        System.out.println(univ+" & "+id);

        Manager manager = managerService.findManager(id, univ);
//        System.out.println(manager);
//        System.out.println(manager.getUniv());
//        System.out.println(manager.getId());
//        System.out.println(manager.getPw());

        if (manager == null){
            return false;   // No manager data in DB
        }else{
            // Manager's DB password == Input password
            // Manager's DB password =/= Input password
            return pw.equals(manager.getPw());
        }
    }
}
