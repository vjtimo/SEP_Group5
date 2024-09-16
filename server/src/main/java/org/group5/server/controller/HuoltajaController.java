package org.group5.server.controller;

import org.group5.server.model.Huoltaja;
import org.group5.server.service.HuoltajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/huoltajat")
public class HuoltajaController {

    private final HuoltajaService huoltajaService;

    @Autowired
    public HuoltajaController(HuoltajaService huoltajaService) {
        this.huoltajaService = huoltajaService;
    }

    @PostMapping
    public ResponseEntity<Huoltaja> createHuoltaja(@RequestBody Huoltaja huoltaja) {
        return ResponseEntity.ok(huoltajaService.createHuoltaja(huoltaja));
    }

    @GetMapping
    public ResponseEntity<List<Huoltaja>> getAllHuoltajat() {
        return ResponseEntity.ok(huoltajaService.getAllHuoltajat());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Huoltaja> getHuoltajaById(@PathVariable Long id) {
        return ResponseEntity.ok(huoltajaService.getHuoltajaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Huoltaja> updateHuoltaja(@PathVariable Long id, @RequestBody Huoltaja paivitettyHuoltaja) {
        return ResponseEntity.ok(huoltajaService.updateHuoltaja(id, paivitettyHuoltaja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHuoltaja(@PathVariable Long id) {
        huoltajaService.deleteHuoltaja(id);
        return ResponseEntity.ok().build();
    }
}