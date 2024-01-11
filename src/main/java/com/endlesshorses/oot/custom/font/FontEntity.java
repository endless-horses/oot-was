package com.endlesshorses.oot.custom.font;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class FontEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private String imageUrl;
}
