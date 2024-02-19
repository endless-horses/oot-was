package com.endlesshorses.oot.custom.pattern.controller;

import com.endlesshorses.oot.custom.pattern.dto.PatternListResponseDto;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.pattern.service.PatternService;
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
public class PatternControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PatternService patternService;
	private List<PatternListResponseDto> patternList;


	@Test
	@DisplayName("패턴 데이터 가져오기 테스트")
	void getPatternResponse() throws Exception {

		//given
		Pattern pattern1 = new Pattern();
		pattern1.setId(1004L);
		pattern1.setName("리브 패턴");
		pattern1.setPrice(1004L);
		pattern1.setImageUrl("http://~");
		pattern1.setExplanation("테스트!");


		PatternListResponseDto patternDto = new PatternListResponseDto(pattern1);
		patternList = Arrays.asList(patternDto);
		Mockito.when(patternService.list()).thenReturn(patternList);


		mockMvc.perform(get("/api/patterns")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value(patternList.get(0).getName()))
				.andExpect(status().isOk())
				.andDo(print());

	}

}
