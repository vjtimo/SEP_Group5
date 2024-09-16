package org.group5.server.repository;

import org.group5.server.model.Opettaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpettajaRepository extends JpaRepository<Opettaja, Long> {}