package com.endlesshorses.oot.custom.accessory.controller;

import com.endlesshorses.oot.custom.accessory.dto.AccessoryListResponseDto;
import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import com.endlesshorses.oot.custom.accessory.service.AccessoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AccessoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccessoryService accessoryService;

    private List<AccessoryListResponseDto> accessoryList;

    @BeforeEach
    public void setUp() {

    }

    @Test
    @DisplayName("GET /accessories 테스트")
    public void list() throws Exception {
        // given
        Accessory accessory1 = new Accessory();
        accessory1.setId(1L);
        accessory1.setName("휠 프로텍터");
        accessory1.setPrice(10000L);
        accessory1.setImageUrl("imageUrl1");
        accessory1.setExplanation("설명1~");

        Accessory accessory2 = new Accessory();
        accessory2.setId(1L);
        accessory2.setName("휠 림 어댑터");
        accessory2.setPrice(10000L);
        accessory2.setImageUrl("imageUrl2");
        accessory2.setExplanation("설명2~");

        AccessoryListResponseDto accessoryDto1 = new AccessoryListResponseDto(accessory1);
        AccessoryListResponseDto accessoryDto2 = new AccessoryListResponseDto(accessory2);

        accessoryList = Arrays.asList(accessoryDto1, accessoryDto2);

        // when
        Mockito.when(accessoryService.list()).thenReturn(accessoryList);

        // then
        mockMvc.perform(get("/api/accessories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(accessoryList.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(accessoryList.get(0).getName()))
                .andExpect(jsonPath("$[0].price").value(accessoryList.get(0).getPrice()))
                .andExpect(jsonPath("$[0].imageUrl").value(accessoryList.get(0).getImageUrl()))
                .andExpect(jsonPath("$[0].explanation").value(accessoryList.get(0).getExplanation()))
                .andExpect(jsonPath("$[1].id").value(accessoryList.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(accessoryList.get(1).getName()))
                .andExpect(jsonPath("$[1].price").value(accessoryList.get(1).getPrice()))
                .andExpect(jsonPath("$[1].imageUrl").value(accessoryList.get(1).getImageUrl()))
                .andExpect(jsonPath("$[1].explanation").value(accessoryList.get(1).getExplanation()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}