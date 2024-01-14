package com.endlesshorses.oot.custom.wheel.entity;

import com.endlesshorses.oot.custom.result.entity.Result;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Wheel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WHEEL_ID")
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private Long price;
	@Column(nullable = false)
	private String imageUrl;
	@Column(nullable = false)
	private String explanation;

	@OneToMany(mappedBy = "wheel")
	private List<Result> results = new ArrayList<>();

}
