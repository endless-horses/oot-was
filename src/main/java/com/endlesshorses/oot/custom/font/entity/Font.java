package com.endlesshorses.oot.custom.font.entity;

import com.endlesshorses.oot.custom.result.entity.Result;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Font {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private Long price;
	@Column(nullable = false)
	private String imageUrl;

	@OneToMany(mappedBy = "font") //읽기만 가능
	private List<Result> results = new ArrayList<>();

}