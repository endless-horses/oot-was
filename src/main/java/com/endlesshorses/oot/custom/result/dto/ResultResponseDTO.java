package com.endlesshorses.oot.custom.result.dto;

import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.font.entity.Font;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.result.entity.Result;
import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ResultResponseDTO {
    private String id;

    private Pattern pattern;

    private Wheel wheel;

    private Font font;

    private Color color;

    private Accessory accessory;

    private LocalDateTime createdAt;

    @Builder
    public ResultResponseDTO(Result result) {
        this.id = result.getId();
        this.pattern = result.getPattern();
        this.wheel = result.getWheel();
        this.font = result.getFont();
        this.color = result.getColor();
        this.accessory = result.getAccessory();
        this.createdAt = result.getCreatedAt();
    }
}