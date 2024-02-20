package com.endlesshorses.oot.custom.result.service;

import com.endlesshorses.oot.custom.result.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
}
