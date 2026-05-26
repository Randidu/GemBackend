package com.srilankagem.gembackend.gem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateRequest {
    @NotBlank(message = "Certificate number is required")
    private String certificateNumber;

    @NotNull(message = "Gemstone Id is required")
    private Long gemId;

    @NotBlank(message = "Issued By is required")
    private String issuedBy;

    @NotNull(message = "Issue Date is required")
    private LocalDate issuedDate;

    @NotNull(message = "Expire Date is required")
    private LocalDate expireDate;

    private String remark;
}

