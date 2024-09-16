package org.group5.server.controller;

import org.group5.server.model.Opettaja;
import org.group5.server.service.OpettajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opettajat")
public class OpettajaController {

    private final OpettajaService opettajaService;

    @Autowired
    public OpettajaController(OpettajaService opettajaService) {
        this.opettajaService = opettajaService;
    }

    @PostMapping
    public ResponseEntity<Opettaja> createOpettaja(@RequestBody Opettaja opettaja) {
        return ResponseEntity.ok(opettajaService.createOpettaja(opettaja));
    }

    @GetMapping
    public ResponseEntity<List<Opettaja>> getAllOpettajat() {
        return ResponseEntity.ok(opettajaService.getAllOpettajat());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opettaja> getOpettajaById(@PathVariable Long id) {
        return opettajaService.getOpettajaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opettaja> updateOpettaja(@PathVariable Long id, @RequestBody Opettaja opettajaDetails) {
        return ResponseEntity.ok(opettajaService.updateOpettaja(id, opettajaDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpettaja(@PathVariable Long id) {
        opettajaService.deleteOpettaja(id);
        return ResponseEntity.ok().build();
    }
}