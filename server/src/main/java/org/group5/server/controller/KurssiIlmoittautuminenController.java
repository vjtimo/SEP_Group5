package org.group5.server.controller;

import org.group5.server.model.KurssiIlmoittautuminen;
import org.group5.server.service.KurssiIlmoittautuminenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kurssi-ilmoittautumiset")
public class KurssiIlmoittautuminenController {

    private final KurssiIlmoittautuminenService kurssiIlmoittautuminenService;

    @Autowired
    public KurssiIlmoittautuminenController(KurssiIlmoittautuminenService kurssiIlmoittautuminenService) {
        this.kurssiIlmoittautuminenService = kurssiIlmoittautuminenService;
    }

    @PostMapping
    public ResponseEntity<KurssiIlmoittautuminen> createKurssiIlmoittautuminen(@RequestBody KurssiIlmoittautuminen kurssiIlmoittautuminen) {
        return ResponseEntity.ok(kurssiIlmoittautuminenService.createKurssiIlmoittautuminen(kurssiIlmoittautuminen));
    }

    @GetMapping
    public ResponseEntity<List<KurssiIlmoittautuminen>> getAllKurssiIlmoittautumiset() {
        return ResponseEntity.ok(kurssiIlmoittautuminenService.getAllKurssiIlmoittautumiset());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KurssiIlmoittautuminen> getKurssiIlmoittautuminenById(@PathVariable Long id) {
        return kurssiIlmoittautuminenService.getKurssiIlmoittautuminenById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KurssiIlmoittautuminen> updateKurssiIlmoittautuminen(@PathVariable Long id, @RequestBody KurssiIlmoittautuminen kurssiIlmoittautuminenDetails) {
        return ResponseEntity.ok(kurssiIlmoittautuminenService.updateKurssiIlmoittautuminen(id, kurssiIlmoittautuminenDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKurssiIlmoittautuminen(@PathVariable Long id) {
        kurssiIlmoittautuminenService.deleteKurssiIlmoittautuminen(id);
        return ResponseEntity.ok().build();
    }
}