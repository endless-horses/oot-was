package com.endlesshorses.oot.custom.font.dto;

import com.endlesshorses.oot.custom.font.entity.Font;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FontListResponseDto {
	private Long id;
	private String name;
	private Long price;
	private String imageUrl;

	@Builder
	public FontListResponseDto(Font font) {
		this.id = font.getId();
		this.name = font.getName();
		this.price = font.getPrice();
		this.imageUrl = font.getImageUrl();
	}

}
