package com.marcos.guessword.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.http.MediaType;

@WebMvcTest(Controller.class)
public class TestControllerTest {

    private String URL_TESTE = "/api/v1/words";
    // endpoit: http://localhost:8080/api/v1/words

    @Autowired
    private MockMvc mockMvc;

    // Teste para verificar se API está rodando
    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/words"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"mensagem\":\"Hello, World!!\"}"));
                //.andExpect(content().string("Hello, World!!"));
    }

    //Envia uma requisição POST, e valida o json recebido.
    @Test
    void testeNome() throws Exception{
        String body = "{\"name\":\"Luiz\"}";

        mockMvc.perform(post("/api/v1/words/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists())//valida se o campo existe
                .andExpect(jsonPath("$.response").value("adicionado"));//valida os dois campos da mensagem.
    }
}

//"mensagem":"Hello, World!!"