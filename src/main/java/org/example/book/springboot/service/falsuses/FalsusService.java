package org.example.book.springboot.service.falsuses;

import lombok.RequiredArgsConstructor;
import org.example.book.springboot.domain.falsus.FalsusRepository;
import org.example.book.springboot.web.dto.FalsusListResponseDto;
import org.example.book.springboot.web.dto.PostsListResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FalsusService {

    private final FalsusRepository falsusRepository;


    @Transactional(readOnly = true)
    public List<FalsusListResponseDto> findAllDesc() {
        return falsusRepository.findAllDesc().stream()
                .map(FalsusListResponseDto::new)
                .collect(Collectors.toList());
    }
}
