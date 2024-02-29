package com.endlesshorses.oot.custom.color.service;

import com.endlesshorses.oot.custom.color.dto.ColorListResponseDto;
import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.color.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService {
	private final ColorRepository colorRepository;

	@Transactional(readOnly = true)
	public List<ColorListResponseDto> list() {
		return colorRepository.findAll().stream()
				.map(ColorListResponseDto::new)
				.collect(Collectors.toList());
	}

	public Color read(Long id) {
		return colorRepository.findById(id).orElseThrow();
	}
}
