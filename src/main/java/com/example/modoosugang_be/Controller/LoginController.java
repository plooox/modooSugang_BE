package com.example.modoosugang_be.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
public class LoginController {

    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, Object> param) {
        System.out.println((param));


        return (Boolean)param.get("isManager");
    }
}
