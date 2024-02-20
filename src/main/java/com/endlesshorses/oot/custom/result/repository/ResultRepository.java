package com.endlesshorses.oot.custom.result.repository;

import com.endlesshorses.oot.custom.result.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResultRepository extends JpaRepository<Result, UUID> {
}
