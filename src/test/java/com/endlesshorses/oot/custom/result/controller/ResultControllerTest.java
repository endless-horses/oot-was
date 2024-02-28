package com.endlesshorses.oot.custom.result.controller;

import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.font.entity.Font;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.result.dto.ResultResponseDTO;
import com.endlesshorses.oot.custom.result.entity.Result;
import com.endlesshorses.oot.custom.result.service.ResultService;
import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@AutoConfigureMockMvc
class ResultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResultService resultService;

    @Test
    @DisplayName("GET /api/result/{id} 테스트")
    public void read() throws Exception {
        // given
        String id = "b172456d-733d-4eed-9f15-c790e0cbc318";

        Pattern pattern = new Pattern();
        pattern.setId(1004L);
        pattern.setName("리브 패턴");
        pattern.setPrice(1004L);
        pattern.setImageUrl("http://~");
        pattern.setExplanation("테스트!");

        Wheel wheel = new Wheel();
        wheel.setId(1L);
        wheel.setName("스포크 휠");
        wheel.setPrice(10000L);
        wheel.setImageUrl("image_url_1");
        wheel.setExplanation("설명1~");

        Font font = new Font();
        font.setId(1004L);
        font.setName("폰트 색상");
        font.setPrice(5000L);
        font.setImageUrl("http://~");

        Color color = new Color();
        color.setId(1004L);
        color.setName("색상 이름");
        color.setRgb("FFFFFF");
        color.setImageUrl("http://~");

        Accessory accessory1 = new Accessory();
        accessory1.setId(1L);
        accessory1.setName("휠 프로텍터");
        accessory1.setPrice(10000L);
        accessory1.setImageUrl("imageUrl1");
        accessory1.setExplanation("설명1~");

        Result result = new Result();
        result.setId("b172456d-733d-4eed-9f15-c790e0cbc318");
        result.setPattern(pattern);
        result.setWheel(wheel);
        result.setFont(font);
        result.setColor(color);
        result.setAccessory(accessory1);
        result.setCreatedAt(LocalDateTime.now());

        ResultResponseDTO resultDto = new ResultResponseDTO(result);

        // when
        Mockito.when(resultService.read(result.getId())).thenReturn(resultDto);

        // then
        mockMvc.perform(get("/api/results/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(resultDto.getId()))
                .andExpect(jsonPath("$.pattern.id").value(resultDto.getPattern().getId()))
                .andExpect(jsonPath("$.pattern.name").value(resultDto.getPattern().getName()))
                .andExpect(jsonPath("$.pattern.price").value(resultDto.getPattern().getPrice()))
                .andExpect(jsonPath("$.pattern.imageUrl").value(resultDto.getPattern().getImageUrl()))
                .andExpect(jsonPath("$.pattern.explanation").value(resultDto.getPattern().getExplanation()))
                .andExpect(jsonPath("$.wheel.id").value(resultDto.getWheel().getId()))
                .andExpect(jsonPath("$.wheel.name").value(resultDto.getWheel().getName()))
                .andExpect(jsonPath("$.wheel.price").value(resultDto.getWheel().getPrice()))
                .andExpect(jsonPath("$.wheel.imageUrl").value(resultDto.getWheel().getImageUrl()))
                .andExpect(jsonPath("$.wheel.explanation").value(resultDto.getWheel().getExplanation()))
                .andExpect(jsonPath("$.font.id").value(resultDto.getFont().getId()))
                .andExpect(jsonPath("$.font.name").value(resultDto.getFont().getName()))
                .andExpect(jsonPath("$.font.price").value(resultDto.getFont().getPrice()))
                .andExpect(jsonPath("$.font.imageUrl").value(resultDto.getFont().getImageUrl()))
                .andExpect(jsonPath("$.color.id").value(resultDto.getColor().getId()))
                .andExpect(jsonPath("$.color.name").value(resultDto.getColor().getName()))
                .andExpect(jsonPath("$.color.rgb").value(resultDto.getColor().getRgb()))
                .andExpect(jsonPath("$.color.imageUrl").value(resultDto.getColor().getImageUrl()))
                .andExpect(jsonPath("$.accessory.id").value(resultDto.getAccessory().getId()))
                .andExpect(jsonPath("$.accessory.name").value(resultDto.getAccessory().getName()))
                .andExpect(jsonPath("$.accessory.price").value(resultDto.getAccessory().getPrice()))
                .andExpect(jsonPath("$.accessory.imageUrl").value(resultDto.getAccessory().getImageUrl()))
                .andExpect(jsonPath("$.accessory.explanation").value(resultDto.getAccessory().getExplanation()))
                .andExpect(jsonPath("$.createdAt").value(resultDto.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}