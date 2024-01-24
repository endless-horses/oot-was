package com.endlesshorses.oot.custom.color.controller;

import com.endlesshorses.oot.custom.color.dto.ColorListResponseDto;
import com.endlesshorses.oot.custom.color.service.ColorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Color", description = "색상 관련 API")
@RequestMapping("/colors")
public class ColorController {
	private final ColorService colorService;

	@GetMapping
	@Operation(summary = "색상 목록 조회 메서드", description = "클라이언트가 요청한 색상 정보 목록을 조회하기 위한 메서드")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "색상 목록 조회 성공"),
	})
	public ResponseEntity<List<ColorListResponseDto>> list() {
		List<ColorListResponseDto> colorList = colorService.list();

		return ResponseEntity.ok().body(colorList);
	}
}
