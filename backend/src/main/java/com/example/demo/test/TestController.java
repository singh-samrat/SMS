package com.example.demo.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.io.IOException;

@RestController
@RequestMapping(path = "/api")
public class TestController {

    @PostMapping(path = "/v1/test/post")
    public ResponseEntity<Test> login(@RequestBody Test test) throws IOException {
        System.out.println("Hello from client");
        String email = test.getEmail();
        String password = test.getPassword();

        System.out.println(email);
        return ResponseEntity.ok(new Test(email, password));
    }

    @PostMapping(path = "/v1/test/status")
    public String checkStatus(){
        System.out.println("OK");
        return "{'Testing status': 'OK'}";
    }





//
//    @PostMapping(path = "/post")
//    public ResponseEntity<TestResponse> showDetails(@RequestBody Test test){
//        System.out.println("Request got");
//        System.out.println(test.getEmail());
//        return ResponseEntity.ok(new TestResponse("Login Successful"));
//    }

//    @PostMapping(path = "/postTest")
//    @ResponseBody
//    public String testPost(){
//        return "{" +
//                    "'aa':'bb'" +
//                "}";
//    }
}
