package com.endlesshorses.oot.custom.accessory.dto;

import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccessoryListResponseDto {
	private Long id;
	private String name;
	private Long price;
	private String imageUrl;
	private String explanation;

	@Builder
	public AccessoryListResponseDto(Accessory accessory) {
		this.id = accessory.getId();
		this.name = accessory.getName();
		this.price = accessory.getPrice();
		this.imageUrl = accessory.getImageUrl();
		this.explanation = accessory.getExplanation();
	}
}
