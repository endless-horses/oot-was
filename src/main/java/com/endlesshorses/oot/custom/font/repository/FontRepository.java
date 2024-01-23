package com.endlesshorses.oot.custom.font.repository;

import com.endlesshorses.oot.custom.font.entity.Font;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FontRepository extends JpaRepository<Font, Long> {
	List<Font> findAll();

}