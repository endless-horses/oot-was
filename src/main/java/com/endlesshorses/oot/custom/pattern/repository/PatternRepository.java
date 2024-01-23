package com.endlesshorses.oot.custom.pattern.repository;


import com.endlesshorses.oot.custom.pattern.entity.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatternRepository extends JpaRepository<Pattern, Long> {
	List<Pattern> findAll();

}
