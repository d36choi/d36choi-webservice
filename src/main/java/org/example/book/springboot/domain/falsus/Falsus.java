package org.example.book.springboot.domain.falsus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Falsus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String div;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(length = 500, nullable = false)
    private String protection;

    @Builder
    public Falsus(String div,String address,String protection) {
        this.div = div;
        this.address = address;
        this.protection = protection;
    }
}
