package com.srilankagem.gembackend.gem.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "gemstone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GemStone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    private String gemCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GemType type;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Double caratWeight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GemOrigin origin;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GemTreatment treatment;

    @Column(nullable = false)
    private Double priceCarat;

    @Column(nullable = false)
    private Integer stockQuantity;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    @Builder.Default
    private boolean certified = false;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @Builder.Default
    private boolean active =true;
    private  LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt =LocalDateTime.now();
    }
}
