package com.example.ospedaleNuovo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ospedaleNuovo.entities.Paziente;
import com.example.ospedaleNuovo.repositories.PazienteRepository;

@Service
public class PazienteService {

	@Autowired
	private PazienteRepository repoPaziente;

	public PazienteService(PazienteRepository repoPaziente) {
		this.repoPaziente = repoPaziente;
	}
	
	
	// aggiungi Paziente

		public Paziente addPaziente(Paziente paziente) {
			return repoPaziente.save(paziente);
		}

		// Visualizza letto per id

		public Paziente getPazienteById(Long id) {
			return repoPaziente.findById(id).orElseThrow(() -> new RuntimeException("Letto non trovato"));
		}

		// visualizza lista letti

		public List<Paziente> getAllPazienti() {
			return repoPaziente.findAll();
		}

		// elimina letto per id

		public void deletePaziente(Long id) {
			repoPaziente.deleteById(id);
		}
	
	
}
