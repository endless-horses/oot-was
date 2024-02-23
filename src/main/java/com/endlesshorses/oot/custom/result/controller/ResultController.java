package com.endlesshorses.oot.custom.result.controller;

import com.endlesshorses.oot.custom.pattern.dto.PatternListResponseDto;
import com.endlesshorses.oot.custom.result.dto.ResultResponseDTO;
import com.endlesshorses.oot.custom.result.entity.Result;
import com.endlesshorses.oot.custom.result.service.ResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    public ResponseEntity<ResultResponseDTO> findResult(@PathVariable String id) {
        return ResponseEntity.ok(resultService.findById(id));
    }

    @GetMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "결과물 목록 조회 성공"),
    })
    public List<ResultResponseDTO> findAll() {
        return resultService.list();
    }
}
