package com.endlesshorses.oot.custom.wheel.controller;

import com.endlesshorses.oot.custom.wheel.dto.WheelListResponseDto;
import com.endlesshorses.oot.custom.wheel.service.WheelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Wheel", description = "휠 모양 관련 API")
public class WheelController {
    private final WheelService wheelService;

    @GetMapping("/wheel")
    @Operation(summary = "Wheel 목록 조회 메서드", description = "클라이언트가 요청한 휠 모양 목록 정보를 조회하기 위한 메서드")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "휠 모양 목록 조회 성공"),
            @ApiResponse(responseCode = "400(403)", description = "휠 모양 목록 조회 실패"),
    })
    public List<WheelListResponseDto> findAll() {
        return wheelService.list();
    }

    /*
    public ResponseEntity<Message> listWheel(HttpServletRequest request) {
        WheelResponseDto wheelResponseDto = (WheelResponseDto) wheelService.list();

        return ResponseEntity.ok(
                SuccessMessage.builder()
                        .path(request.getRequestURI())
                        .data(wheelResponseDto)
                        .build());
    }
    */

}
