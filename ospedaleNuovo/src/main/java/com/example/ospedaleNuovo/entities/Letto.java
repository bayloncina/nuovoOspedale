package com.example.ospedaleNuovo.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


/**
 * The persistent class for the letto database table.
 * 
 */
@Entity
@NamedQuery(name="Letto.findAll", query="SELECT l FROM Letto l")
public class Letto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Integer numero;

	private Boolean occupato;

	//bi-directional many-to-one association to Paziente
	@ManyToOne
	@JsonBackReference
	private Paziente paziente;

	//bi-directional many-to-one association to Stanza
	@ManyToOne
	@JoinColumn(name="stanza")
	@JsonBackReference
	private Stanza stanzaBean;

	public Letto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getOccupato() {
		return this.occupato;
	}

	public void setOccupato(Boolean occupato) {
		this.occupato = occupato;
	}

	public Paziente getPaziente() {
		return this.paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Stanza getStanzaBean() {
		return this.stanzaBean;
	}

	public void setStanzaBean(Stanza stanzaBean) {
		this.stanzaBean = stanzaBean;
	}

}