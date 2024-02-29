package com.endlesshorses.oot.custom.result.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultPostResponseDto { //주는 DTO
	private String id;

	public ResultPostResponseDto(String id) {
		this.id = id;
	}

}