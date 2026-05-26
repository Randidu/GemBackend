package com.srilankagem.gembackend.gem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateResponse {

    private Long id;
    private String certificateNumber;
    private Long gemId;
    private String issuedBy;
    private LocalDate issuedDate;
    private LocalDate expireDate;
    private String remark;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;


}
