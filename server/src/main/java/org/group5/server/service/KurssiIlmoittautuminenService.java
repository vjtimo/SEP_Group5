package org.group5.server.service;

import org.group5.server.model.KurssiIlmoittautuminen;
import org.group5.server.repository.KurssiIlmoittautuminenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KurssiIlmoittautuminenService {

    private final KurssiIlmoittautuminenRepository kurssiIlmoittautuminenRepository;

    @Autowired
    public KurssiIlmoittautuminenService(KurssiIlmoittautuminenRepository kurssiIlmoittautuminenRepository) {
        this.kurssiIlmoittautuminenRepository = kurssiIlmoittautuminenRepository;
    }

    public KurssiIlmoittautuminen createKurssiIlmoittautuminen(KurssiIlmoittautuminen kurssiIlmoittautuminen) {
        return kurssiIlmoittautuminenRepository.save(kurssiIlmoittautuminen);
    }

    public List<KurssiIlmoittautuminen> getAllKurssiIlmoittautumiset() {
        return kurssiIlmoittautuminenRepository.findAll();
    }

    public Optional<KurssiIlmoittautuminen> getKurssiIlmoittautuminenById(Long id) {
        return kurssiIlmoittautuminenRepository.findById(id);
    }

    public KurssiIlmoittautuminen updateKurssiIlmoittautuminen(Long id, KurssiIlmoittautuminen kurssiIlmoittautuminenDetails) {
        KurssiIlmoittautuminen existingKurssiIlmoittautuminen = kurssiIlmoittautuminenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KurssiIlmoittautuminen not found with id: " + id));

        existingKurssiIlmoittautuminen.setOpiskelija(kurssiIlmoittautuminenDetails.getOpiskelija());
        existingKurssiIlmoittautuminen.setKurssi(kurssiIlmoittautuminenDetails.getKurssi());
        existingKurssiIlmoittautuminen.setIlmoittautuminen_pvm(kurssiIlmoittautuminenDetails.getIlmoittautuminen_pvm());

        return kurssiIlmoittautuminenRepository.save(existingKurssiIlmoittautuminen);
    }

    public void deleteKurssiIlmoittautuminen(Long id) {
        kurssiIlmoittautuminenRepository.deleteById(id);
    }
}