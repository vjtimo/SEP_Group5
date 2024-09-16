package org.group5.server.repository;

import org.group5.server.model.KurssiIlmoittautuminen;
import org.group5.server.model.Opiskelija;
import org.group5.server.model.Kurssi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KurssiIlmoittautuminenRepository extends JpaRepository<KurssiIlmoittautuminen, Long> {

    // TODO

    // Find all registrations for a specific student
    List<KurssiIlmoittautuminen> findByOpiskelija(Opiskelija opiskelija);

    // Find all registrations for a specific course
    List<KurssiIlmoittautuminen> findByKurssi(Kurssi kurssi);
}