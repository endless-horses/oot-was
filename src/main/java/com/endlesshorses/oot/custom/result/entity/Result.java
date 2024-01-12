package com.endlesshorses.oot.custom.result.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "pattern_id", nullable = false)
	private Long patterId;
	@JoinColumn(name = "wheel_id", nullable = false)
	private Long wheelId;
	@JoinColumn(name = "font_id", nullable = false)
	private Long fontId;
	@JoinColumn(name = "color_id", nullable = false)
	private Long colorId;
	@JoinColumn(name = "accessory_id")
	private Long accessoryId;
	@Column(nullable = false)
	@CreatedDate
	private LocalDateTime createdDateTime;
}
