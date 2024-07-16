package com.betek.cd_and_ci.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("ping controller test")
    @Test
    void pingOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ping"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("pong"));
    }


    @DisplayName("calculator controller test")
    @Test
    void controllerOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator")
                        .param("numA", String.valueOf(2))
                        .param("numB",String.valueOf(3)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5"));
    }
}
