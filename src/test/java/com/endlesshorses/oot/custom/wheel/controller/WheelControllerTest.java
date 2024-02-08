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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
        Wheel wheel = new Wheel();
        WheelListResponseDto wheelDto = new WheelListResponseDto(wheel);

        wheelList = Arrays.asList(wheelDto);

        Mockito.when(wheelService.list()).thenReturn(wheelList);
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/wheels")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(wheelList)));
    }
}
