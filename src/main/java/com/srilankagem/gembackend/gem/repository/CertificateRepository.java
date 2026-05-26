package com.srilankagem.gembackend.gem.repository;

import com.srilankagem.gembackend.gem.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {


    Optional<Certificate> findByGemStone_Id(Long gemStoneId);

    boolean existsByGemStone_Id(Long gemStoneId);

    boolean existsByCertificateNumber(String certificateNumber);
}
