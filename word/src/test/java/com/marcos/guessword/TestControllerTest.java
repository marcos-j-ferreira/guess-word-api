package com.marcos.guessword.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class TestControllerTest {

    private String URL_TESTE = "/api/v1/words";
    // endpoit: http://localhost:8080/api/v1/words

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/words"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!!"));
    }
}
