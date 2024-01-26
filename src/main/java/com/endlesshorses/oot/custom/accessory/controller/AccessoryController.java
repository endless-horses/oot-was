package com.endlesshorses.oot.custom.accessory.controller;

import com.endlesshorses.oot.custom.accessory.dto.AccessoryListResponseDto;
import com.endlesshorses.oot.custom.accessory.service.AccessoryService;
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
@Tag(name = "Accessory", description = "액세서리 관련 API")
@RequestMapping("api/accessories")
public class AccessoryController {
	private final AccessoryService accessoryService;

	@GetMapping
	@Operation(summary = "Accessory 목록 조회 메서드", description = "클라이언트가 요청한 액세서리 목록 정보를 조회하기 위한 메서드")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "액세서리 목록 조회 성공")
	})
	public ResponseEntity<List<AccessoryListResponseDto>> list() {
		List<AccessoryListResponseDto> accessoryList = accessoryService.list();

		return ResponseEntity.ok().body(accessoryList);
	}
}
