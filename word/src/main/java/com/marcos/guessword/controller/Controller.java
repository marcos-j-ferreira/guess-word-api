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


//import com.marcos.guessword.service.ServiceUser;
//import com.marcos.guessword.model.Usuario;
import com.marcos.guessword.dto.request.UsuarioRequestDTO;
import com.marcos.guessword.dto.response.UsuarioResponseDTO;

import com.marcos.guessword.dto.response.HelloResponseDTO;

@RestController
@RequestMapping("/api/v1/words")
public class Controller {
    //private ServiceUser serUser = new ServiceUser();

    // Esta foi feita com o objetivo de ser didática, servindo como material para estudo.
    @GetMapping
    public ResponseEntity<HelloResponseDTO> hello(){
        String hello = "Hello, World!!";

        return ResponseEntity
                .status(200)
                .body(new HelloResponseDTO(hello));

    }

    // Esta foi feita com o objetivo de ser didática, servindo como material para estudo.
    @PostMapping("/user")
    public ResponseEntity<UsuarioResponseDTO> user(@RequestBody (required=true) UsuarioRequestDTO name){
        String reponse = "adicionado";
        System.out.println(name.name());
        UsuarioResponseDTO response = new UsuarioResponseDTO(name.name(), reponse);

        return ResponseEntity.ok(response);
    }
}