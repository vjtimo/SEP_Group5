package org.group5.server.service;

import org.group5.server.model.Kurssi;
import org.group5.server.model.Opettaja;
import org.group5.server.repository.KurssiRepository;
import org.group5.server.repository.OpettajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class KurssiService {

    private final KurssiRepository kurssiRepository;
    private final OpettajaRepository opettajaRepository;

    @Autowired
    public KurssiService(KurssiRepository kurssiRepository, OpettajaRepository opettajaRepository) {
        this.kurssiRepository = kurssiRepository;
        this.opettajaRepository = opettajaRepository;
    }

    // Create
    public Kurssi createKurssi(Kurssi kurssi) {
        if (kurssi.getOpettaja() != null && kurssi.getOpettaja().getOpettaja_id() != null) {
            Opettaja opettaja = opettajaRepository.findById(kurssi.getOpettaja().getOpettaja_id())
                    .orElseThrow(() -> new EntityNotFoundException("Opettaja not found with id: " + kurssi.getOpettaja().getOpettaja_id()));
            kurssi.setOpettaja(opettaja);
        }
        return kurssiRepository.save(kurssi);
    }

    // Read (Get all)
    public List<Kurssi> getAllKurssit() {
        return kurssiRepository.findAll();
    }

    // Read (Get by ID)
    public Optional<Kurssi> getKurssiById(Long id) {
        return kurssiRepository.findById(id);
    }

    // Update
    public Kurssi updateKurssi(Long id, Kurssi kurssiDetails) {
        Kurssi kurssi = kurssiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kurssi not found with id: " + id));

        updateKurssiFields(kurssi, kurssiDetails);

        if (kurssiDetails.getOpettaja() != null && kurssiDetails.getOpettaja().getOpettaja_id() != null) {
            Opettaja opettaja = opettajaRepository.findById(kurssiDetails.getOpettaja().getOpettaja_id())
                    .orElseThrow(() -> new EntityNotFoundException("Opettaja not found with id: " + kurssiDetails.getOpettaja().getOpettaja_id()));
            kurssi.setOpettaja(opettaja);
        } else {
            kurssi.setOpettaja(null);
        }

        return kurssiRepository.save(kurssi);
    }

    // Delete
    public void deleteKurssi(Long id) {
        if (!kurssiRepository.existsById(id)) {
            throw new EntityNotFoundException("Kurssi not found with id: " + id);
        }
        kurssiRepository.deleteById(id);
    }

    // Helper method
    private void updateKurssiFields(Kurssi kurssi, Kurssi kurssiDetails) {
        kurssi.setNimi(kurssiDetails.getNimi());
        kurssi.setKuvaus(kurssiDetails.getKuvaus());
        kurssi.setAlkupvm(kurssiDetails.getAlkupvm());
        kurssi.setLoppupvm(kurssiDetails.getLoppupvm());
    }
}