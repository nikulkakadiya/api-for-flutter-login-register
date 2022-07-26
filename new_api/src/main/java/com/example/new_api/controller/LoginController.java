package com.example.new_api.controller;

import com.example.new_api.bean.Registration;
import com.example.new_api.respository.RegRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    RegRespository regRespository;

    @GetMapping("/test")
    public String show(){
        return "nikul kakadiya by login page";
    }


    @GetMapping(value = "/{email}/{pass}")
//    @RequestMapping(value = "/{email,pass}", method= RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("email") String email,@PathVariable("pass") String pass) {
//        User user = userRepository.findById(id);
        Map<String, Boolean> enrolled = new HashMap<String, Boolean>();

        Registration registration=regRespository.login(email,pass);
        enrolled.put("success",true);
        if (registration == null) {
            enrolled.replace("success",false);
            return new ResponseEntity<Map>(enrolled, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map>(enrolled, HttpStatus.OK);
    }



}
