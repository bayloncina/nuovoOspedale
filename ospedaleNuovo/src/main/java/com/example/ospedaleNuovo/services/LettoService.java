package com.example.ospedaleNuovo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ospedaleNuovo.entities.Letto;
import com.example.ospedaleNuovo.repositories.LettoRepository;

@Service
public class LettoService {

	@Autowired
	private LettoRepository repoLetto;

	public LettoService(LettoRepository repoLetto) {
		this.repoLetto = repoLetto;
	}

	// aggiungi Letto

	public Letto addLetto(Letto letto) {
		return repoLetto.save(letto);
	}

	// Visualizza letto per id

	public Letto getLettoById(Long id) {
		return repoLetto.findById(id).orElseThrow(() -> new RuntimeException("Letto non trovato"));
	}

	// visualizza lista letti

	public List<Letto> getAllLetti() {
		return repoLetto.findAll();
	}

	// elimina letto per id

	public void deleteLetto(Long id) {
		repoLetto.deleteById(id);
	}
}
