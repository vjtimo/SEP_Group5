package org.group5.server.service;

import org.group5.server.model.Huoltaja;
import org.group5.server.repository.HuoltajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class HuoltajaService {

    private final HuoltajaRepository huoltajaRepository;

    @Autowired
    public HuoltajaService(HuoltajaRepository huoltajaRepository) {
        this.huoltajaRepository = huoltajaRepository;
    }

    // Create
    public Huoltaja createHuoltaja(Huoltaja huoltaja) {
        return huoltajaRepository.save(huoltaja);
    }

    // Read
    public List<Huoltaja> getAllHuoltajat() {
        return huoltajaRepository.findAll();
    }

    // Read
    public Huoltaja getHuoltajaById(Long id) {
        return huoltajaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Huoltaja not found with id: " + id));
    }

    // Update
    public Huoltaja updateHuoltaja(Long id, Huoltaja huoltajaDetails) {
        Huoltaja huoltaja = huoltajaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Huoltaja not found with id: " + id));

        huoltaja.setEtunimi(huoltajaDetails.getEtunimi());
        huoltaja.setSukunimi(huoltajaDetails.getSukunimi());
        huoltaja.setSahkoposti(huoltajaDetails.getSahkoposti());
        huoltaja.setPuhelinnumero(huoltajaDetails.getPuhelinnumero());

        return huoltajaRepository.save(huoltaja);
    }

    // Delete
    public void deleteHuoltaja(Long id) {
        if (!huoltajaRepository.existsById(id)) {
            throw new EntityNotFoundException("Huoltaja not found with id: " + id);
        }
        huoltajaRepository.deleteById(id);
    }
}