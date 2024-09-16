package org.group5.server.repository;


import org.group5.server.model.Opiskelija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository antaa valmiiksi CRUD-operaatiot tietokantaan
@Repository
public interface OpiskelijaRepository extends JpaRepository<Opiskelija, Long> {}


