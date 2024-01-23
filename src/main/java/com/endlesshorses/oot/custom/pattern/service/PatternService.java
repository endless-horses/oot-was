package com.endlesshorses.oot.custom.pattern.service;

import com.endlesshorses.oot.custom.pattern.dto.PatternListResponseDto;
import com.endlesshorses.oot.custom.pattern.repository.PatternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PatternService {

	private final PatternRepository patternRepository;

	public List<PatternListResponseDto> list() {
		return patternRepository.findAll().stream()
				.map(PatternListResponseDto::new)
				.collect(Collectors.toList());
	}


}
