package com.endlesshorses.oot.custom.color.controller;

import com.endlesshorses.oot.custom.color.dto.ColorListResponseDto;
import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.color.service.ColorService;
import com.endlesshorses.oot.custom.font.dto.FontListResponseDto;
import com.endlesshorses.oot.custom.font.entity.Font;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ColorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ColorService colorService;
	private List<ColorListResponseDto> colorList;

	@Test
	@DisplayName("색상 데이터 가져오기 테스트")
	void getFontResponse() throws Exception {
		Color color1 = new Color();
		color1.setId(1004L);
		color1.setName("색상 이름");
		color1.setRgb("FFFFFF");
		color1.setImageUrl("http://~");

		ColorListResponseDto colorDto = new ColorListResponseDto(color1);
		colorList = Arrays.asList(colorDto);
		Mockito.when(colorService.list()).thenReturn(colorList);


		mockMvc.perform(get("/api/colors")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value(colorList.get(0).getName()))
				.andExpect(status().isOk())
				.andDo(print());
	}

}