package org.group5.server.repository;

import org.group5.server.model.Opintosuoritus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface OpintosuoritusRepository extends JpaRepository<Opintosuoritus, Long> {
    // TODO
    List<Opintosuoritus> findByOpiskelijaOpiskelijaId(Long opiskelijaId);
    List<Opintosuoritus> findByKurssiKurssiId(Long kurssiId);
}