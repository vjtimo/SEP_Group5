package org.group5.server.service;

import org.group5.server.model.Oppitunti;
import org.group5.server.repository.OppituntiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OppituntiService {

    private final OppituntiRepository oppituntiRepository;

    @Autowired
    public OppituntiService(OppituntiRepository oppituntiRepository) {
        this.oppituntiRepository = oppituntiRepository;
    }

    public Oppitunti createOppitunti(Oppitunti oppitunti) {
        return oppituntiRepository.save(oppitunti);
    }

    public List<Oppitunti> getAllOppitunnit() {
        return oppituntiRepository.findAll();
    }

    public Optional<Oppitunti> getOppituntiById(Long id) {
        return oppituntiRepository.findById(id);
    }

    public Oppitunti updateOppitunti(Long id, Oppitunti oppituntiDetails) {
        Oppitunti oppitunti = oppituntiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oppitunti not found with id: " + id));

        oppitunti.setKurssi(oppituntiDetails.getKurssi());
        oppitunti.setAlkuaika(oppituntiDetails.getAlkuaika());
        oppitunti.setLoppuaika(oppituntiDetails.getLoppuaika());

        return oppituntiRepository.save(oppitunti);
    }

    public List<Oppitunti> getOppitunnitByKurssiId(Long kurssi_id) {
        return oppituntiRepository.findByKurssiId(kurssi_id);
    }

    public void deleteOppitunti(Long id) {
        oppituntiRepository.deleteById(id);
    }
}