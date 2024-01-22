package com.endlesshorses.oot.custom.pattern.service;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.pattern.repository.PatternRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class PatternService {

	private final PatternRepository patternRepository;

	public List<Pattern> findPatterns(){
		return patternRepository.findAll();
	}

}
