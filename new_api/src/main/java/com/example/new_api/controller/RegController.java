package com.example.new_api.controller;

import com.example.new_api.bean.Registration;
import com.example.new_api.respository.RegRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping("/register")
public class RegController {

    @Autowired
    RegRespository regRespository;

    @GetMapping("/test")
    public String show(){
        return "nikul kakadiya";
    }

    //*****************insert record********************

    @PostMapping
    public ResponseEntity createUser(@RequestBody Registration registration) throws SQLIntegrityConstraintViolationException {
//        if (regRespository.findById(registration.getId()) != null) {
//            return new ResponseEntity<String>("Duplicate Entry " + registration.getId(), HttpStatus.IM_USED);
//        }
//        regRespository.saveUser(registration);
//        return ResponseEntity.status(HttpStatus.CREATED).build();

        Map<String, Boolean> enrolled = new HashMap<String, Boolean>();
        enrolled.put("success",true);
        if (regRespository.findById(registration.getId()) != null) {
            enrolled.replace("success",false);
            return new ResponseEntity<Map>(enrolled, HttpStatus.IM_USED);
        }
        regRespository.saveUser(registration);
        return new ResponseEntity<Map>(enrolled, HttpStatus.IM_USED);
    }
}
