package org.group5.server.repository;

import org.group5.server.model.Oppitunti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OppituntiRepository extends JpaRepository<Oppitunti, Long> {
    @Query("SELECT o FROM Oppitunti o WHERE o.kurssi.kurssi_id = :kurssi_id")
    List<Oppitunti> findByKurssiId(Long kurssi_id);

    // TODO
    List<Oppitunti> findByAlkuaikaBetween(Date start, Date end);
}