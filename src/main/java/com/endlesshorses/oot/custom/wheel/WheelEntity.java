package com.endlesshorses.oot.custom.wheel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "wheel")
public class WheelEntity {
	@Id
	@Column(nullable = false)
	@GeneratedValue
	private Long id;
	@Column(unique=true, nullable = false)
	private String name;
	@Column(nullable = false)
	private int price;
	@Column( nullable = false)
	private String image_url;
	@Column(nullable = false)
	private String explanation;
}
