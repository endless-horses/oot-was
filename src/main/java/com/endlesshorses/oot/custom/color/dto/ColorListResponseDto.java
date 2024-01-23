package com.endlesshorses.oot.custom.color.dto;

import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import lombok.Builder;

public class ColorListResponseDto {
	private String name;
	private String rgb;

	@Builder
	public ColorListResponseDto(Color color) {
		this.name = color.getName();
		this.rgb = color.getRgb();
	}
}
