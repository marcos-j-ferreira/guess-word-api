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
import org.springframework.web.bind.annotation.RequestParam;
//RequestParam


import com.marcos.guessword.service.ServiceUser;
import com.marcos.guessword.model.Usuario;
//import com.marcos.guessword.model.Usuario;

import com.marcos.guessword.dto.request.UsuarioRequestDTO;
import com.marcos.guessword.dto.response.UsuarioResponseDTO;
import com.marcos.guessword.dto.response.HelloResponseDTO;
import com.marcos.guessword.dto.response.ResponseArray;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/words")
public class Controller {
    private ServiceUser service = new ServiceUser();

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

        return ResponseEntity
                .status(201)
                .body(response);
        //(response);
    }


    // Rota feita para trabalhar e estudar sobre DTO
    @GetMapping("/user")
    public ResponseEntity<UsuarioResponseDTO> adduser(@RequestParam (required=true) UsuarioRequestDTO user){
        //service.adduser(user.name());
        
        String nome = service.adduser(user);
        UsuarioResponseDTO response = new UsuarioResponseDTO(nome, "usuário adiconado com sucesso");
        System.out.println(user.name());

        return ResponseEntity
                .status(201)
                .body(response);
    }

    //Rota feita para o estudo de json com array
    @GetMapping("/array")
    public ResponseEntity<ResponseArray> array(){
        ArrayList nomes = new ArrayList<>();

        nomes.add("azul");
        nomes.add("blue");
        nomes.add("red");
        nomes.add("vermelho");
        nomes.add("green");
        ResponseArray response = new ResponseArray("disponivel", nomes);
        return ResponseEntity
                .status(201)
                .body(response);
    }
    

}