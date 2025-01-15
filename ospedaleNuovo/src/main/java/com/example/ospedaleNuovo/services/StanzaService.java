package com.example.ospedaleNuovo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ospedaleNuovo.entities.Stanza;
import com.example.ospedaleNuovo.repositories.StanzaRepository;

@Service
public class StanzaService {

	@Autowired
	private StanzaRepository repoStanza;

	public StanzaService(StanzaRepository repoStanza) {
		this.repoStanza = repoStanza;
	}

	// aggiungi Stanza

	public Stanza addStanza(Stanza stanza) {
		return repoStanza.save(stanza);
	}

	// Visualizza stanza per id

	public Stanza getStanzaById(Long id) {
		return repoStanza.findById(id).orElseThrow(() -> new RuntimeException("Stanza non trovata"));
	}

	// visualizza lista stanze

	public List<Stanza> getAllStanze() {
		return repoStanza.findAll();
	}


	// elimina stanza per id

	public void deleteStanza(Long id) {
		repoStanza.deleteById(id);
	}
}
