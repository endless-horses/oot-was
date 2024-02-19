package com.endlesshorses.oot.custom.wheel.dto;

import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WheelListResponseDto {
    private Long id;
    private String name;
    private Long price;
    private String imageUrl;
    private String explanation;

    @Builder
    public WheelListResponseDto(Wheel wheel) {
        this.id = wheel.getId();
        this.name = wheel.getName();
        this.price = wheel.getPrice();
        this.imageUrl = wheel.getImageUrl();
        this.explanation = wheel.getExplanation();
    }
}
