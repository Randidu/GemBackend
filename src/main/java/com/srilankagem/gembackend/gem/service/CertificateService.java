package com.srilankagem.gembackend.gem.service;

import com.srilankagem.gembackend.common.exception.DuplicateResourceException;
import com.srilankagem.gembackend.common.exception.ResourceNotFoundException;
import com.srilankagem.gembackend.gem.dto.CertificateRequest;
import com.srilankagem.gembackend.gem.dto.CertificateResponse;
import com.srilankagem.gembackend.gem.models.Certificate;
import com.srilankagem.gembackend.gem.models.GemStone;
import com.srilankagem.gembackend.gem.repository.CertificateRepository;
import com.srilankagem.gembackend.gem.repository.GemStoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;
    private final GemStoneRepository gemStoneRepository;

    public CertificateResponse createCertificate(CertificateRequest request) throws ResourceNotFoundException {
        if (certificateRepository.existsByCertificateNumber(request.getCertificateNumber())) {
            throw new DuplicateResourceException("Certificate with number " + request.getCertificateNumber() + " already exists");
        }
        if (certificateRepository.existsByGemStone_Id(request.getGemId())) {
            throw new DuplicateResourceException("Certificate for gemstone ID " + request.getGemId() + " already exists");
        }

        GemStone stone = gemStoneRepository.findById(request.getGemId())
                .orElseThrow(() -> new ResourceNotFoundException("Gem", request.getGemId().toString()));

        Certificate certificate = Certificate.
                builder()
                .certificateNumber(request.getCertificateNumber())
                .gemStone(stone)
                .issuedBy(request.getIssuedBy())
                .issueDate(request.getIssuedDate())
                .expireDate(request.getExpireDate())
                .remark(request.getRemark())
                .build();

        Certificate saved = certificateRepository.save(certificate);
        return toResponse(saved);
    }

    public CertificateResponse getCertificateById(Long id) throws ResourceNotFoundException {
        Certificate certificate = certificateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate", id.toString()));
        return toResponse(certificate);
    }

    private CertificateResponse toResponse(Certificate certificate) {
        return CertificateResponse.builder()
                .id(certificate.getId())
                .certificateNumber(certificate.getCertificateNumber())
                .gemId(certificate.getGemStone().getId())
                .issuedBy(certificate.getIssuedBy())
                .issuedDate(certificate.getIssueDate())
                .expireDate(certificate.getExpireDate())
                .remark(certificate.getRemark())
                .createAt(certificate.getCreatedAt())
                .build();
    }

}
