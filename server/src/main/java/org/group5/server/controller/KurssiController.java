package org.group5.server.controller;

import org.group5.server.model.Kurssi;
import org.group5.server.service.KurssiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kurssit")
public class KurssiController {

    private final KurssiService kurssiService;

    @Autowired
    public KurssiController(KurssiService kurssiService) {
        this.kurssiService = kurssiService;
    }

    @PostMapping
    public ResponseEntity<Kurssi> createKurssi(@RequestBody Kurssi kurssi) {
        return ResponseEntity.ok(kurssiService.createKurssi(kurssi));
    }

    @GetMapping
    public ResponseEntity<List<Kurssi>> getAllKurssit() {
        return ResponseEntity.ok(kurssiService.getAllKurssit());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kurssi> getKurssiById(@PathVariable Long id) {
        return kurssiService.getKurssiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kurssi> updateKurssi(@PathVariable Long id, @RequestBody Kurssi kurssiDetails) {
        return ResponseEntity.ok(kurssiService.updateKurssi(id, kurssiDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKurssi(@PathVariable Long id) {
        kurssiService.deleteKurssi(id);
        return ResponseEntity.ok().build();
    }
}