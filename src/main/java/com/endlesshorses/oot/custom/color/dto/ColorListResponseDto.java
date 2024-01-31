package com.endlesshorses.oot.custom.color.dto;

import com.endlesshorses.oot.custom.color.entity.Color;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ColorListResponseDto {
	private Long id;
	private String name;
	private String rgb;

	private String imageUrl;

	@Builder
	public ColorListResponseDto(Color color) {
		this.id = color.getId();
		this.name = color.getName();
		this.rgb = color.getRgb();
		this.imageUrl = color.getImageUrl();
	}
}
