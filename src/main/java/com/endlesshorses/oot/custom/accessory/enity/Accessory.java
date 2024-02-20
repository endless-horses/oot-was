package com.endlesshorses.oot.custom.accessory.enity;

import com.endlesshorses.oot.custom.result.entity.Result;
import com.endlesshorses.oot.custom.resultAccessory.entity.ResultAccessory;
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

    @OneToMany(mappedBy = "accessory")
    private List<ResultAccessory> resultAccessories = new ArrayList<>();
}
