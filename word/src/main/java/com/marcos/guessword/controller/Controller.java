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
import com.marcos.guessword.dto.response.*;
// import com.marcos.guessword.dto.response.UsuarioResponseDTO;
// import com.marcos.guessword.dto.response.HelloResponseDTO;
// import com.marcos.guessword.dto.response.ResponseArray;
//import com.marcos.guessword.dto.reponse.ResponseObjeto;

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
    //retorna um json que possui uma array que tem objetos dentro
    @GetMapping("/array")
    public ResponseEntity<ResponseArray> array(){
        ArrayList<UsuarioResponseDTO> nomes = new ArrayList<>();

        nomes.add( new UsuarioResponseDTO("Ferrari", "sim"));
        nomes.add( new UsuarioResponseDTO("Celta", "não"));
        nomes.add( new UsuarioResponseDTO("Uno", "disponivel"));
        nomes.add( new UsuarioResponseDTO("BMW", "disponivel"));

        ResponseArray response = new ResponseArray("SC", nomes);
        return ResponseEntity
                .status(201)
                .body(response);
    }

    //retorna uma objeto dentro do json
    @GetMapping("/object/two")
    public ResponseEntity<ResponseObjeto> teste01(){
        UsuarioResponseDTO dados = new UsuarioResponseDTO("Marcos", "estudando");
        ResponseObjeto responseOb = new ResponseObjeto("alunos",dados);

        return ResponseEntity
                .status(200)
                .body(responseOb);
    }


    @GetMapping("/object")
    public ResponseEntity<ResponseObject> teste(){

        // define uma array com DTO de usuários, e adiciona dados
        ArrayList<UsuarioResponseDTO> nomes = new ArrayList<>();
        nomes.add( new UsuarioResponseDTO("Marcos", "senior"));
        nomes.add( new UsuarioResponseDTO("Maria", "Advogada"));

        // Adiciona a array dentro de uma resposta com Array
        ResponseArray cores = new ResponseArray("Estudando", nomes);

        // Adciona o objeto com array em uma resposta.
        ResponseObject response = new ResponseObject("Estudando", cores);

        return ResponseEntity
                .status(200)
                .body(response);
    }

    // retorna um json com regex, importante não esquecer o header
    @GetMapping("/json/regex")
    public ResponseEntity<String> regexx(){

        String body = "{\"Alunos\": {\"name\":\"Luiz\"},{\"name\":\"Marcos\"},{\"name\":\"Ana\"},{\"name\":\"Ferreira\"} }";

        return ResponseEntity
                .status(200)
                .header("Content-Type", "application/json") // importante 
                .body(body);
    }
}

