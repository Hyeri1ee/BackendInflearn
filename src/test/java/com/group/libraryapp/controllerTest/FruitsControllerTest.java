package com.group.libraryapp.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;


import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FruitsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("과일 새로 등록 테스트(성공)")
    public void saveFruitTest() throws  Exception{
        //given
        String name = "자두";
        LocalDate date = LocalDate.parse("2024-05-12");
        long price = 3000;

        FruitCreateRequest fruitCreateRequest = new FruitCreateRequest(name,date,price);
        String url = "http://localhost:8080" + "/api/v1/fruit";

        //when
        final ResultActions resultActions = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fruitCreateRequest))

        ).andDo(print());

        //then
        resultActions
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("과일 판매후 등록 테스트(성공)")
    public void saledFruit() throws Exception{
        //given
        String url = "http://localhost:8080" + "/api/v1/fruit";
        //when
        final ResultActions resultActions = mockMvc.perform(put(url)
                .queryParam("id","9")
        ).andDo(print());
        //then
        resultActions
                .andExpect(status().isOk());
    }
}
