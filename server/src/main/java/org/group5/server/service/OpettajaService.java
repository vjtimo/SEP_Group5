package org.group5.server.service;

import org.group5.server.model.Opettaja;
import org.group5.server.repository.OpettajaRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OpettajaService {

    private final OpettajaRepository opettajaRepository;

    @Autowired
    public OpettajaService(OpettajaRepository opettajaRepository) {
        this.opettajaRepository = opettajaRepository;
    }

    // Create
    public Opettaja createOpettaja(Opettaja opettaja) {
        String hashedPassword = BCrypt.hashpw(opettaja.getSalasana(), BCrypt.gensalt());
        opettaja.setSalasana(hashedPassword);
        return opettajaRepository.save(opettaja);
    }

    // Read (Get all)
    public List<Opettaja> getAllOpettajat() {
        return opettajaRepository.findAll();
    }

    // Read (Get by ID)
    public Optional<Opettaja> getOpettajaById(Long id) {
        return opettajaRepository.findById(id);
    }

    // Update
    public Opettaja updateOpettaja(Long id, Opettaja opettajaDetails) {
        Opettaja opettaja = opettajaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Opettaja not found with id: " + id));

        opettaja.setEtunimi(opettajaDetails.getEtunimi());
        opettaja.setSukunimi(opettajaDetails.getSukunimi());
        opettaja.setSahkoposti(opettajaDetails.getSahkoposti());

        return opettajaRepository.save(opettaja);
    }

    // Delete
    public void deleteOpettaja(Long id) {
        if (!opettajaRepository.existsById(id)) {
            throw new EntityNotFoundException("Opettaja not found with id: " + id);
        }
        opettajaRepository.deleteById(id);
    }

}