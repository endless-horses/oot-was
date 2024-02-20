package com.endlesshorses.oot.custom.result.entity;

import com.endlesshorses.oot.custom.color.entity.Color;
import com.endlesshorses.oot.custom.font.entity.Font;
import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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


	@Column(nullable = false)
	@CreatedDate
	private LocalDateTime createdAt;


}
