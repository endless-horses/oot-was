package com.endlesshorses.oot.custom.color.service;

import com.endlesshorses.oot.custom.color.dto.ColorListResponseDto;
import com.endlesshorses.oot.custom.color.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService {
	private final ColorRepository colorRepository;

	public List<ColorListResponseDto> list(){
		return colorRepository.findAll().stream()
				.map(ColorListResponseDto::new)
				.collect(Collectors.toList());
	}

}
