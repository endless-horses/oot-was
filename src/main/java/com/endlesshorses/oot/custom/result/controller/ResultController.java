package com.endlesshorses.oot.custom.result.controller;

import com.endlesshorses.oot.custom.result.service.ResultService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Result", description = "타이어 커스텀 결과물 관련 API")
@RequestMapping("/api/results")
public class ResultController {
    private final ResultService resultService;
}
