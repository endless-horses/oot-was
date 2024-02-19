package com.endlesshorses.oot.custom.font.controller;

import com.endlesshorses.oot.custom.font.dto.FontListResponseDto;

import com.endlesshorses.oot.custom.font.entity.Font;
import com.endlesshorses.oot.custom.font.service.FontService;
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
class FontControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private FontService fontService;
	private List<FontListResponseDto> fontList;


	@Test
	@DisplayName("폰트 데이터 가져오기 테스트")
	void getFontResponse() throws Exception {

		Font font1 = new Font();
		font1.setId(1004L);
		font1.setName("폰트 색상");
		font1.setPrice(5000L);
		font1.setImageUrl("http://~");

		FontListResponseDto fontDto = new FontListResponseDto(font1);
		fontList = Arrays.asList(fontDto);
		Mockito.when(fontService.list()).thenReturn(fontList);


		mockMvc.perform(get("/api/fonts")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value(fontList.get(0).getName()))
				.andExpect(status().isOk())
				.andDo(print());
	}

}