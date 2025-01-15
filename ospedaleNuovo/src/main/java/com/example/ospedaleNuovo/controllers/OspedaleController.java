package com.example.ospedaleNuovo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ospedaleNuovo.entities.Letto;
import com.example.ospedaleNuovo.entities.Ospedale;
import com.example.ospedaleNuovo.entities.Paziente;
import com.example.ospedaleNuovo.entities.Stanza;
import com.example.ospedaleNuovo.services.LettoService;
import com.example.ospedaleNuovo.services.OspedaleService;
import com.example.ospedaleNuovo.services.PazienteService;
import com.example.ospedaleNuovo.services.StanzaService;

@RestController
@RequestMapping("")
public class OspedaleController {

	
	private OspedaleService ospedaleService;
    private StanzaService stanzaService;
    private LettoService lettoService;
    private PazienteService pazienteService;

    public OspedaleController(OspedaleService ospedaleService, StanzaService stanzaService, LettoService lettoService, PazienteService pazienteService) {
        this.ospedaleService = ospedaleService;
        this.stanzaService = stanzaService;
        this.lettoService = lettoService;
        this.pazienteService = pazienteService;
    }

    // ----- GESTIONE OSPEDALE -----

    @PostMapping("/ospedale")
    public ResponseEntity<Ospedale> createOspedale(@RequestBody Ospedale ospedale) {
        return ResponseEntity.ok(ospedaleService.addOspedale(ospedale));
    }

    @GetMapping("/ospedali")
    public ResponseEntity<List<Ospedale>> getAllOspedali() {
        return ResponseEntity.ok(ospedaleService.getAllOspedali());
    }

    @GetMapping("/ospedale/{id}")
    public ResponseEntity<Ospedale> getOspedaleById(@PathVariable Long id) {
        return ResponseEntity.ok(ospedaleService.getOspedaleById(id));
    }

    @DeleteMapping("/ospedale/{id}")
    public ResponseEntity<Void> deleteOspedale(@PathVariable Long id) {
        ospedaleService.deleteOspedale(id);
        return ResponseEntity.noContent().build();
    }

    // ----- GESTIONE STANZA -----

    @PostMapping("/stanza")
    public ResponseEntity<Stanza> createStanza(@RequestBody Stanza stanza) {
        return ResponseEntity.ok(stanzaService.addStanza(stanza));
    }

    @GetMapping("/stanze")
    public ResponseEntity<List<Stanza>> getAllStanze() {
        return ResponseEntity.ok(stanzaService.getAllStanze());
    }

    @GetMapping("/stanza/{id}")
    public ResponseEntity<Stanza> getStanzaById(@PathVariable Long id) {
        return ResponseEntity.ok(stanzaService.getStanzaById(id));
    }

    @DeleteMapping("/stanza/{id}")
    public ResponseEntity<Void> deleteStanza(@PathVariable Long id) {
        stanzaService.deleteStanza(id);
        return ResponseEntity.noContent().build();
    }

    // ----- GESTIONE LETTO -----

    @PostMapping("/letti")
    public ResponseEntity<Letto> createLetto(@RequestBody Letto letto) {
        return ResponseEntity.ok(lettoService.addLetto(letto));
    }

    @GetMapping("/letto")
    public ResponseEntity<List<Letto>> getAllLetti() {
        return ResponseEntity.ok(lettoService.getAllLetti());
    }

    @GetMapping("/letto/{id}")
    public ResponseEntity<Letto> getLettoById(@PathVariable Long id) {
        return ResponseEntity.ok(lettoService.getLettoById(id));
    }

    @DeleteMapping("/letto/{id}")
    public ResponseEntity<Void> deleteLetto(@PathVariable Long id) {
        lettoService.deleteLetto(id);
        return ResponseEntity.noContent().build();
    }

    // ----- GESTIONE PAZIENTE -----

    @PostMapping("/paziente")
    public ResponseEntity<Paziente> createPaziente(@RequestBody Paziente paziente) {
        return ResponseEntity.ok(pazienteService.addPaziente(paziente));
    }

    @GetMapping("/pazienti")
    public ResponseEntity<List<Paziente>> getAllPazienti() {
        return ResponseEntity.ok(pazienteService.getAllPazienti());
    }

    @GetMapping("/paziente/{id}")
    public ResponseEntity<Paziente> getPazienteById(@PathVariable Long id) {
        return ResponseEntity.ok(pazienteService.getPazienteById(id));
    }

    @DeleteMapping("/paziente/{id}")
    public ResponseEntity<Void> deletePaziente(@PathVariable Long id) {
        pazienteService.deletePaziente(id);
        return ResponseEntity.noContent().build();
    }
}
