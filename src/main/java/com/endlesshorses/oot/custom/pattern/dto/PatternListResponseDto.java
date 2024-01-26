package com.endlesshorses.oot.custom.pattern.dto;

import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PatternListResponseDto {
	private Long id;
	private String name;
	private Long price;
	private String imageUrl;
	private String explanation;

	@Builder
	public PatternListResponseDto(Pattern pattern) {
		this.id = pattern.getId();
		this.name = pattern.getName();
		this.price = pattern.getPrice();
		this.imageUrl = pattern.getImageUrl();
		this.explanation = pattern.getExplanation();
	}
}
