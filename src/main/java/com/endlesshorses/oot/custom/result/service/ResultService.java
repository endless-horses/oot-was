package com.endlesshorses.oot.custom.result.service;

import com.endlesshorses.oot.custom.result.dto.ResultResponseDTO;
import com.endlesshorses.oot.custom.result.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;

    public ResultResponseDTO read(String id) {
        return resultRepository.findById(id)
                .map(ResultResponseDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 결과가 없습니다. id: " + id));
    }

    public List<ResultResponseDTO> list() {
        return resultRepository.findAll().stream()
                .map(ResultResponseDTO::new)
                .collect(Collectors.toList());
    }
}
