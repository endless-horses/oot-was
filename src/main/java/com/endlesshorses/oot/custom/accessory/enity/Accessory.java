package com.endlesshorses.oot.custom.accessory.enity;

import com.endlesshorses.oot.custom.result.entity.Result;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Accessory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private Long price;
	@Column(nullable = false)
	private String imageUrl;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String explanation;

	@ManyToMany(mappedBy = "accessory")
	private List<Result> results = new ArrayList<>();

}
