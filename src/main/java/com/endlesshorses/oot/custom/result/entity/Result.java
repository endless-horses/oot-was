package com.endlesshorses.oot.custom.result.entity;

import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.font.entity.Font;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Result {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "PATTERN_ID", nullable = false)
    private Pattern pattern;

    @ManyToOne
    @JoinColumn(name = "WHEEL_ID", nullable = false)
    private Wheel wheel;

    @ManyToOne
    @JoinColumn(name = "FONT_ID", nullable = false)
    private Font font;

    @ManyToOne
    @JoinColumn(name = "FONT_COLOR_ID", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "ACCESSORY_ID")
    private Accessory accessory;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Result(String id, Pattern pattern, Wheel wheel, Font font, Color color, Accessory accessory) {
        this.id = id;
        this.pattern = pattern;
        this.wheel = wheel;
        this.font = font;
        this.color = color;
        this.accessory = accessory;
        this.createdAt = LocalDateTime.now();
    }
}