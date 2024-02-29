package com.endlesshorses.oot.custom.result.controller;

import com.endlesshorses.oot.custom.result.dto.ResultGetResponseDto;
import com.endlesshorses.oot.custom.result.dto.ResultPostResponseDto;
import com.endlesshorses.oot.custom.result.dto.ResultRequestDto;
import com.endlesshorses.oot.custom.result.service.ResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Result", description = "타이어 커스텀 결과물 관련 API")
@RequestMapping("/api/results")
public class ResultController {
	private final ResultService resultService;

	@Operation(summary = "타이어 커스텀 결과물 조회 메서드", description = "클라이언트가 요청한 타이어 결과물 정보를 조회하기 위한 메서드")
	@GetMapping("/{id}")
	@ResponseBody
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "결과물 조회 성공"),
			@ApiResponse(responseCode = "400", description = "잘못된 요청, UUID 형식이 아닌 id가 입력된 경우"),
			@ApiResponse(responseCode = "404", description = "결과물을 찾을 수 없음, 주어진 id에 해당하는 결과물이 없는 경우"),
			@ApiResponse(responseCode = "500", description = "서버 내부 오류"),
	})

	public ResponseEntity<ResultGetResponseDto> read(@PathVariable String id) {
		return ResponseEntity.ok(resultService.read(id));
	}

	@PostMapping
	@Operation(summary = "타이어 커스텀 결과물 저장", description = "타이어 커스텀 결과물을 저장합니다.")
	@ApiResponses({
			@ApiResponse(responseCode = "200(202)", description = "정보 등록 요청"),
	}) //ResultResponseDto를 프론트에게 ResponseEntity를 통해서 전달하겠다!
	public ResponseEntity<ResultPostResponseDto> create(@RequestBody ResultRequestDto resultRequestDto) throws
			IOException {
		return ResponseEntity.ok(
				resultService.create(resultRequestDto)
		);
	}


}