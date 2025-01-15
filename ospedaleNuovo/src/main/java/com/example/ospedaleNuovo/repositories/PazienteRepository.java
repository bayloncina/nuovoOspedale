package com.example.ospedaleNuovo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ospedaleNuovo.entities.Paziente;

public interface PazienteRepository extends JpaRepository<Paziente, Long> {

}
