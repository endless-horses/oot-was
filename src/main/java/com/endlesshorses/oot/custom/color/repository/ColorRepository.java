package com.endlesshorses.oot.custom.color.repository;

import java.util.List;
import com.endlesshorses.oot.custom.color.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
    List<Color> findAll();

}
