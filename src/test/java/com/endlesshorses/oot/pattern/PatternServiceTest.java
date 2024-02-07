package com.endlesshorses.oot.pattern;

import com.endlesshorses.oot.custom.pattern.dto.PatternListResponseDto;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.pattern.repository.PatternRepository;
import com.endlesshorses.oot.custom.pattern.service.PatternService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PatternServiceTest {
	@Mock
	private PatternRepository patternRepository;

	@InjectMocks
	private PatternService patternService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testList() {

		Pattern pattern1 = new Pattern();
		Pattern pattern2 = new Pattern();


		List<Pattern> patternList = Arrays.asList(pattern1, pattern2);

		//패턴 레포지토리의 findAll() 메서드가 호출될 때 패턴 엔티티 목록 반환하도록 설정
		when(patternRepository.findAll()).thenReturn(patternList);

		// 패턴 서비스의 list() 메서드 호출
		List<PatternListResponseDto> result = patternService.list();

		// 결과
		if (!result.isEmpty()) {
			Assertions.assertEquals("리브패턴", result.get(0).getName());
			Assertions.assertEquals("리브러그패턴", result.get(1).getName());
		} else {
			// 패턴 목록이 비어있는 경우에 대한 예외 처리
			Assertions.fail("패턴 목록이 비어있습니다.");
		}
	}

}
