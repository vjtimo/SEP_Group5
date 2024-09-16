package org.group5.server.controller;

import org.group5.server.model.Oppitunti;
import org.group5.server.service.OppituntiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oppitunnit")
public class OppituntiController {

    private final OppituntiService oppituntiService;

    @Autowired
    public OppituntiController(OppituntiService oppituntiService) {
        this.oppituntiService = oppituntiService;
    }

    @PostMapping
    public ResponseEntity<Oppitunti> createOppitunti(@RequestBody Oppitunti oppitunti) {
        return ResponseEntity.ok(oppituntiService.createOppitunti(oppitunti));
    }

    @GetMapping
    public ResponseEntity<List<Oppitunti>> getAllOppitunnit() {
        return ResponseEntity.ok(oppituntiService.getAllOppitunnit());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oppitunti> getOppituntiById(@PathVariable Long id) {
        return oppituntiService.getOppituntiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oppitunti> updateOppitunti(@PathVariable Long id, @RequestBody Oppitunti oppituntiDetails) {
        return ResponseEntity.ok(oppituntiService.updateOppitunti(id, oppituntiDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOppitunti(@PathVariable Long id) {
        oppituntiService.deleteOppitunti(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/kurssi/{kurssi_id}")
    public ResponseEntity<List<Oppitunti>> getOppitunnitByKurssiId(@PathVariable Long kurssi_id) {
        List<Oppitunti> oppitunnit = oppituntiService.getOppitunnitByKurssiId(kurssi_id);
        return ResponseEntity.ok(oppitunnit);
    }
}