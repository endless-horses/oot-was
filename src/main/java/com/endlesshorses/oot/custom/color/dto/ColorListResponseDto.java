package com.endlesshorses.oot.custom.color.dto;

import com.endlesshorses.oot.custom.color.entity.Color;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ColorListResponseDto {
	private String name;
	private String rgb;

	@Builder
	public ColorListResponseDto(Color color) {
		this.name = color.getName();
		this.rgb = color.getRgb();
	}
}
