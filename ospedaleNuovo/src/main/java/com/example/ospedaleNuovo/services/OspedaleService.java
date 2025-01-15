package com.example.ospedaleNuovo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ospedaleNuovo.entities.Ospedale;
import com.example.ospedaleNuovo.repositories.OspedaleRepository;

@Service
public class OspedaleService {
	
	@Autowired
	private OspedaleRepository repoOspedale;
	
	public OspedaleService(OspedaleRepository repoOspedale) {
		this.repoOspedale = repoOspedale;
	}
	
	
	//aggiungi ospedale
	
	public Ospedale addOspedale(Ospedale ospedale) {
        return repoOspedale.save(ospedale);
    }
	
	
	//visualizza ospedale tramite ID
	
	public Ospedale getOspedaleById(Long idOspedale) {
        return repoOspedale.findById(idOspedale)
                          .orElseThrow(() -> new RuntimeException("Ospedale non trovato"));
    }

	//visualizza tutti gli ospedali
	
	public List<Ospedale> getAllOspedali(){
		return repoOspedale.findAll();
	}
	
	//elimina Ospedale
	
	public void deleteOspedale(Long id) {
		repoOspedale.deleteById(id);
	}
}
