package com.marcos.guessword.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/words")

public class TestController {


    @GetMapping
    public ResponseEntity<String> hello(){

        String hello = "Hello, World!!";

        return ResponseEntity
                .status(200)
                .body(hello);

    }
}