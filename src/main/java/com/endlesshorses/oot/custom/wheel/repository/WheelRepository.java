package com.endlesshorses.oot.custom.wheel.repository;

import com.endlesshorses.oot.custom.wheel.entity.Wheel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WheelRepository extends JpaRepository<Wheel, Long> {
    @Override
    List<Wheel> findAll();
}