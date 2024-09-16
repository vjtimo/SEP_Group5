package org.group5.server.repository;

import org.group5.server.model.Kurssi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KurssiRepository extends JpaRepository<Kurssi, Long> {
    // TODO
    List<Kurssi> findByOpettajaOpettajaId(Long opettajaId);
}