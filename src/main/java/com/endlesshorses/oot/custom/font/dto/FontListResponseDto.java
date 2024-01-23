package com.endlesshorses.oot.custom.font.dto;

import com.endlesshorses.oot.custom.font.entity.Font;
import lombok.Builder;

public class FontListResponseDto {
	private String name;
	private Long price;
	private String imageUrl;

	@Builder
	public FontListResponseDto(Font font) {
		this.name = font.getName();
		this.price = font.getPrice();
		this.imageUrl = font.getImageUrl();
	}

}
