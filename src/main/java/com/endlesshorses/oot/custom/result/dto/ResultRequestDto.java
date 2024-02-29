package com.endlesshorses.oot.custom.result.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public
class ResultRequestDto { //요청 DTO
	private Long patternId;
	private Long wheelId;
	private Long fontId;
	private Long colorId;
	private Long accessoryId;

	@Builder
	public ResultRequestDto(Long patternId, Long wheelId, Long fontId, Long colorId, Long accessoryId) {
		this.patternId = patternId;
		this.wheelId = wheelId;
		this.fontId = fontId;
		this.colorId = colorId;
		this.accessoryId = accessoryId;
	}

}