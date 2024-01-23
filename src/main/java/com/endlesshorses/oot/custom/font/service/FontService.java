package com.endlesshorses.oot.custom.font.service;

import com.endlesshorses.oot.custom.font.dto.FontListResponseDto;
import com.endlesshorses.oot.custom.font.repository.FontRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FontService {
	private final FontRepository fontRepository;

	public List<FontListResponseDto> list() {
		return fontRepository.findAll().stream()
				.map(FontListResponseDto::new)
				.collect(Collectors.toList());
	}
}
