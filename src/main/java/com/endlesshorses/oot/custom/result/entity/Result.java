package com.endlesshorses.oot.custom.result.entity;

import com.endlesshorses.oot.custom.accessory.enity.Accessory;
import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.font.entity.Font;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.KeyFactory;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Result {

	@Id
	@GeneratedValue(generator = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

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

}
