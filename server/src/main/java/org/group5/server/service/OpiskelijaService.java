package org.group5.server.service;

import jakarta.persistence.EntityNotFoundException;
import org.group5.server.model.Huoltaja;
import org.group5.server.model.Opiskelija;
import org.group5.server.repository.HuoltajaRepository;
import org.group5.server.repository.OpiskelijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpiskelijaService {

    private final OpiskelijaRepository opiskelijaRepository;
    private final HuoltajaRepository huoltajaRepository;

    @Autowired
    public OpiskelijaService(OpiskelijaRepository opiskelijaRepository, HuoltajaRepository huoltajaRepository) {
        this.opiskelijaRepository = opiskelijaRepository;
        this.huoltajaRepository = huoltajaRepository;
    }

    // Create
    public Opiskelija createOpiskelija(Opiskelija opiskelija) {
        Huoltaja vanhaHuoltaja = opiskelija.getHuoltaja();
        if (vanhaHuoltaja != null && vanhaHuoltaja.getHuoltaja_id() != null) {
            Long huoltajaId = vanhaHuoltaja.getHuoltaja_id();
            Huoltaja huoltaja = huoltajaRepository.findById(huoltajaId)
                    .orElseThrow(() -> new EntityNotFoundException("Huoltaja not found with id: " + huoltajaId));
            opiskelija.setHuoltaja(huoltaja);
        } else {
            opiskelija.setHuoltaja(null);
        }
        return opiskelijaRepository.save(opiskelija);
    }

    // Read
    public List<Opiskelija> getAllOpiskelijat() {
        return opiskelijaRepository.findAll();
    }

    public Optional<Opiskelija> getOpiskelijaById(Long id) {
        return opiskelijaRepository.findById(id);
    }

    // Update
    public Opiskelija updateOpiskelija(Long id, Opiskelija opiskelijaDetails) {
        Opiskelija opiskelija = opiskelijaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Opiskelija not found with id: " + id));

        opiskelija.setEtunimi(opiskelijaDetails.getEtunimi());
        opiskelija.setSukunimi(opiskelijaDetails.getSukunimi());
        opiskelija.setSahkoposti(opiskelijaDetails.getSahkoposti());
        opiskelija.setPuhelinnumero(opiskelijaDetails.getPuhelinnumero());

        if (opiskelijaDetails.getHuoltaja() != null && opiskelijaDetails.getHuoltaja().getHuoltaja_id() != null) {
            Long huoltajaId = opiskelijaDetails.getHuoltaja().getHuoltaja_id();
            Huoltaja huoltaja = huoltajaRepository.findById(huoltajaId)
                    .orElseThrow(() -> new EntityNotFoundException("Huoltaja not found with id: " + huoltajaId));
            opiskelija.setHuoltaja(huoltaja);
        } else {
            opiskelija.setHuoltaja(null);
        }

        return opiskelijaRepository.save(opiskelija);
    }

    // Delete
    public void deleteOpiskelija(Long id) {
        opiskelijaRepository.deleteById(id);
    }
}