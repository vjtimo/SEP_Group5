package org.group5.server.controller;

import org.group5.server.model.Opiskelija;
import org.group5.server.service.OpiskelijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opiskelijat")
public class OpiskelijaController {

    private final OpiskelijaService opiskelijaService;

    @Autowired
    public OpiskelijaController(OpiskelijaService opiskelijaService) {
        this.opiskelijaService = opiskelijaService;
    }

    @PostMapping
    public ResponseEntity<Opiskelija> createOpiskelija(@RequestBody Opiskelija opiskelija) {
        return ResponseEntity.ok(opiskelijaService.createOpiskelija(opiskelija));
    }

    @GetMapping
    public ResponseEntity<List<Opiskelija>> getAllOpiskelijat() {
        return ResponseEntity.ok(opiskelijaService.getAllOpiskelijat());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opiskelija> getOpiskelijaById(@PathVariable Long id) {
        return opiskelijaService.getOpiskelijaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opiskelija> updateOpiskelija(
            @PathVariable Long id,
            @RequestBody Opiskelija paivitettyOpiskelija) {
        Opiskelija updatedOpiskelija = opiskelijaService.updateOpiskelija(id, paivitettyOpiskelija);
        return ResponseEntity.ok(updatedOpiskelija);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpiskelija(@PathVariable Long id) {
        opiskelijaService.deleteOpiskelija(id);
        return ResponseEntity.ok().build();
    }
}