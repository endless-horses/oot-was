package com.endlesshorses.oot.custom.result.service;

import com.endlesshorses.oot.custom.accessory.service.AccessoryService;
import com.endlesshorses.oot.custom.color.service.ColorService;
import com.endlesshorses.oot.custom.font.service.FontService;
import com.endlesshorses.oot.custom.pattern.service.PatternService;
import com.endlesshorses.oot.custom.result.dto.ResultGetResponseDto;
import com.endlesshorses.oot.custom.result.dto.ResultPostResponseDto;
import com.endlesshorses.oot.custom.result.dto.ResultRequestDto;
import com.endlesshorses.oot.custom.result.entity.Result;
import com.endlesshorses.oot.custom.result.repository.ResultRepository;
import com.endlesshorses.oot.custom.wheel.service.WheelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResultService {
	private final ResultRepository resultRepository;
	private final PatternService patternService;
	private final WheelService wheelService;
	private final ColorService colorService;
	private final FontService fontService;
	private final AccessoryService accessoryService;

	public ResultGetResponseDto read(String id) {
		return resultRepository.findById(id)
				.map(ResultGetResponseDto::new)
				.orElseThrow(() -> new IllegalArgumentException("해당 id의 결과가 없습니다. id: " + id));
	}

	public ResultPostResponseDto create(ResultRequestDto resultRequestDto) {

		//새로운 result record 생성 (행)
		Result result = Result.builder()
				.id(generateUUID())
				.pattern(patternService.read(resultRequestDto.getPatternId()))
				.wheel(wheelService.read(resultRequestDto.getWheelId()))
				.color(colorService.read(resultRequestDto.getWheelId()))
				.font(fontService.read(resultRequestDto.getFontId()))
				.accessory(accessoryService.read(resultRequestDto.getAccessoryId()))
				.build();
		resultRepository.save(result);

		return new ResultPostResponseDto(result.getId());

	}

	public String generateUUID() {
		return UUID.randomUUID().toString();
	}

}