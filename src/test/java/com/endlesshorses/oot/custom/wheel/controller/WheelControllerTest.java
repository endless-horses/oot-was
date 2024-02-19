package com.endlesshorses.oot.custom.wheel.controller;

import com.endlesshorses.oot.custom.wheel.dto.WheelListResponseDto;
import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import com.endlesshorses.oot.custom.wheel.service.WheelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class WheelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WheelService wheelService;

    private List<WheelListResponseDto> wheelList;

    // 테스트를 위한 초기 설정
    @BeforeEach
    public void setUp() {
        Wheel wheel1 = new Wheel();
        wheel1.setId(1L);
        wheel1.setName("스포크 휠");
        wheel1.setPrice(10000L);
        wheel1.setImageUrl("image_url_1");
        wheel1.setExplanation("설명1~");

        Wheel wheel2 = new Wheel();
        wheel2.setId(2L);
        wheel2.setName("알루미늄 휠");
        wheel2.setPrice(20000L);
        wheel2.setImageUrl("image_url_2");
        wheel2.setExplanation("설명2~");

        WheelListResponseDto wheelDto1 = new WheelListResponseDto(wheel1);
        WheelListResponseDto wheelDto2 = new WheelListResponseDto(wheel2);

        wheelList = Arrays.asList(wheelDto1, wheelDto2);

        Mockito.when(wheelService.list()).thenReturn(wheelList);
    }


    @Test
    public void list() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/wheels")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(wheelList)))
                .andExpect(jsonPath("$[0].id").value(wheelList.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(wheelList.get(0).getName()))
                .andExpect(jsonPath("$[0].price").value(wheelList.get(0).getPrice()))
                .andExpect(jsonPath("$[0].imageUrl").value(wheelList.get(0).getImageUrl()))
                .andExpect(jsonPath("$[0].explanation").value(wheelList.get(0).getExplanation()))
                .andExpect(jsonPath("$[1].id").value(wheelList.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(wheelList.get(1).getName()))
                .andExpect(jsonPath("$[1].price").value(wheelList.get(1).getPrice()))
                .andExpect(jsonPath("$[1].imageUrl").value(wheelList.get(1).getImageUrl()))
                .andExpect(jsonPath("$[1].explanation").value(wheelList.get(1).getExplanation()))
                .andReturn();
    }
}
