package com.endlesshorses.oot.custom.result.dto;

import com.endlesshorses.oot.custom.result.entity.Result;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ResultResponseDTO {
    private String id;

    private Long patternId;
    private String patternName;
    private Long patternPrice;

    private Long wheelId;
    private String wheelName;
    private Long wheelPrice;

    private Long fontId;
    private String fontName;
    private Long fontPrice;

    private Long colorId;
    private String colorName;

    private Long accessoryId;
    private String accessoryName;
    private Long accessoryPrice;

    private LocalDateTime createdAt;

    @Builder
    public ResultResponseDTO(Result result) {
        this.id = result.getId();
        this.patternId = result.getPattern().getId();
        this.patternName = result.getPattern().getName();
        this.patternPrice = result.getPattern().getPrice();
        this.wheelId = result.getWheel().getId();
        this.wheelName = result.getWheel().getName();
        this.wheelPrice = result.getWheel().getPrice();
        this.fontId = result.getFont().getId();
        this.fontName = result.getFont().getName();
        this.fontPrice = result.getFont().getPrice();
        this.colorId = result.getColor().getId();
        this.colorName = result.getColor().getName();
        this.accessoryId = result.getAccessory().getId();
        this.accessoryName = result.getAccessory().getName();
        this.accessoryPrice = result.getAccessory().getPrice();
        this.createdAt = result.getCreatedAt();
    }
}