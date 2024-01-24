package com.endlesshorses.oot.custom.wheel.service;

import com.endlesshorses.oot.custom.wheel.dto.WheelListResponseDto;
import com.endlesshorses.oot.custom.wheel.repository.WheelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WheelService {
    private final WheelRepository wheelRepository;

    // 휠 모양 전체 목록 조회
    @Transactional(readOnly = true)
    public List<WheelListResponseDto> list() {
        return wheelRepository.findAll().stream()
                .map(WheelListResponseDto::new)
                .collect(Collectors.toList());
    }
}
