package org.group5.server.repository;


import org.group5.server.model.Huoltaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuoltajaRepository extends  JpaRepository<Huoltaja, Long> {}
