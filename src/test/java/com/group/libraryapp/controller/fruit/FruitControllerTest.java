package com.group.libraryapp.controller.fruit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.libraryapp.dto.fruit.request.SaveFruitInfoRequestDto;
import com.group.libraryapp.dto.fruit.request.UpdateFruitRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FruitControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("문제 1번 통합 테스트 - 실패 (가격이 음수거나 과일 이름이 공란)")
    void question1_test_fail_caused_by_price_is_minus_or_fruit_name_is_empty() throws Exception {
        SaveFruitInfoRequestDto requestDto = new SaveFruitInfoRequestDto("", LocalDate.of(2024, 1, 1), -1000);

        this.mockMvc.perform(post("/api/v1/fruit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("문제 1번 통합 테스트 - 성공")
    void question1_test_success() throws Exception {
        SaveFruitInfoRequestDto requestDto = new SaveFruitInfoRequestDto("파인애플", LocalDate.of(2024, 2, 2), 20000);

        this.mockMvc.perform(post("/api/v1/fruit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("문제 2번 통합 테스트 - 성공")
    void question2_test_fail_casued_by_not_exists_fruit_id() throws Exception{
        UpdateFruitRequestDto requestDto = new UpdateFruitRequestDto(3);

        this.mockMvc.perform(put("/api/v1/fruit")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
