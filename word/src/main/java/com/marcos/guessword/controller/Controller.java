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

@RestController
@RequestMapping("/api/v1/words")
public class Controller {
    //private ServiceUser serUser = new ServiceUser();

    @GetMapping
    public ResponseEntity<String> hello(){
        String hello = "Hello, World!!";

        return ResponseEntity
                .status(200)
                .body(hello);

    }

    @PostMapping("/user")
    public ResponseEntity<UsuarioResponseDTO> user(@RequestBody (required=true) UsuarioRequestDTO name){
        String reponse = "adicionado";
        UsuarioResponseDTO response = new UsuarioResponseDTO("marcos", "foi");

        return ResponseEntity.ok(response);
    }
}