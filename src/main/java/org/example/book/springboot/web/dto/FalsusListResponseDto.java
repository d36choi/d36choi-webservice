package org.example.book.springboot.web.dto;

import lombok.Getter;
import org.example.book.springboot.domain.falsus.Falsus;

import javax.persistence.Column;

@Getter
public class FalsusListResponseDto {

    private Long id;
    private String div;
    private String address;
    private String protection;

    public FalsusListResponseDto(Falsus entity) {
        this.id = entity.getId();
        this.div = entity.getDiv();
        this.address = entity.getAddress();
        this.protection = entity.getProtection();
    }
}
