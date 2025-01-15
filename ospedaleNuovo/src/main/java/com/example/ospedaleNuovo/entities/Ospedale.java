package com.example.ospedaleNuovo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the ospedale database table.
 * 
 */

@Entity
@NamedQuery(name="Ospedale.findAll", query="SELECT o FROM Ospedale o")
public class Ospedale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String nome;

	//bi-directional many-to-one association to Stanza
	@OneToMany(mappedBy="ospedaleBean")
	@JsonManagedReference
	private List<Stanza> stanzas;

	public Ospedale() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Stanza> getStanzas() {
		return this.stanzas;
	}

	public void setStanzas(List<Stanza> stanzas) {
		this.stanzas = stanzas;
	}

	public Stanza addStanza(Stanza stanza) {
		getStanzas().add(stanza);
		stanza.setOspedaleBean(this);

		return stanza;
	}

	public Stanza removeStanza(Stanza stanza) {
		getStanzas().remove(stanza);
		stanza.setOspedaleBean(null);

		return stanza;
	}

}