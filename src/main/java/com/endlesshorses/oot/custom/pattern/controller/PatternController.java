package com.endlesshorses.oot.custom.pattern.controller;

import com.endlesshorses.oot.custom.pattern.dto.PatternListResponseDto;
import com.endlesshorses.oot.custom.pattern.service.PatternService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Pattern", description = "패턴 관련 API")
@RequestMapping("/api/patterns")
public class PatternController {
	private final PatternService patternService;

	@Operation(summary = "패턴 목록 조회 메서드", description = "클라이언트가 요청한 패턴 정보 목록을 조회하기 위한 메서드")

	@GetMapping
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "패턴 목록 조회 성공"),
	})
	public List<PatternListResponseDto> findAll() {
		return patternService.list();
	}

}
