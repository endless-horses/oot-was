package com.endlesshorses.oot.custom.accessory.service;

import com.endlesshorses.oot.custom.accessory.dto.AccessoryListResponseDto;
import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import com.endlesshorses.oot.custom.accessory.repository.AccessoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccessoryService {
	private final AccessoryRepository accessoryRepository;

	// 액세서리 전체 목록 조회
	@Transactional(readOnly = true)
	public List<AccessoryListResponseDto> list() {
		return accessoryRepository.findAll().stream()
				.map(AccessoryListResponseDto::new)
				.collect(Collectors.toList());
	}

	public Accessory read(Long id) {
		return accessoryRepository.findById(id).orElseThrow();
	}
}
