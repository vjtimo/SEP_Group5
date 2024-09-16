package org.group5.server.repository;

import org.group5.server.model.Kurssi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KurssiRepository extends JpaRepository<Kurssi, Long> {}