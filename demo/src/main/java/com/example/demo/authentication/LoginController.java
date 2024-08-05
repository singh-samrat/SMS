package com.example.demo.authentication;

import com.example.demo.student.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/authenticate")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        String status = loginService.register(user);
        if(status.equals("Email already taken!!")){
            return "{'Testing status': 'NOT OK'";
        }else{
            return "{'Testing status' : 'OK'";
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Student student){
        loginService.authenticate(student);
        return "{'Testing status': 'OK'}";
    }
}
