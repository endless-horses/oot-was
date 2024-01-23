package com.endlesshorses.oot.custom.font.controller;

import com.endlesshorses.oot.custom.font.dto.FontListResponseDto;
import com.endlesshorses.oot.custom.font.service.FontService;
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
@Tag(name = "Font", description = "폰트 관련 API")
@RequestMapping("/fonts")
public class FontController {
	private final FontService fontService;

	@GetMapping()
	@Operation(summary = "폰트 목록 조회 메서드", description = "클라이언트가 요청한 폰트 정보 목록을 조회하기 위한 메서드")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "폰트 목록 조회 성공"),
	})
	public List<FontListResponseDto> findAll() {
		return fontService.list();
	}

}
