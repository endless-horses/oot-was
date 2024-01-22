package com.endlesshorses.oot.custom.pattern.controller;

import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.pattern.service.PatternService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
public class PatternController {
	private final PatternService patternService;

	@RequestMapping("/patterns")
	public String list(Model model){
		List<Pattern> patterns = patternService.findPatterns();
		model.addAttribute("patterns",patterns);
		return "patterns/patternList";
	}
}
