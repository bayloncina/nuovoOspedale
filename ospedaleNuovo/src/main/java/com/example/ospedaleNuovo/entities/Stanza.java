package com.example.ospedaleNuovo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the stanza database table.
 * 
 */
@Entity
@NamedQuery(name="Stanza.findAll", query="SELECT s FROM Stanza s")
public class Stanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Integer numero;

	private String reparto;

	private String tipo;

	//bi-directional many-to-one association to Letto
	@OneToMany(mappedBy="stanzaBean")
	@JsonManagedReference
	private List<Letto> lettos;

	//bi-directional many-to-one association to Ospedale
	@ManyToOne
	@JoinColumn(name="ospedale")
	@JsonBackReference
	private Ospedale ospedaleBean;

	public Stanza() {
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

	public String getReparto() {
		return this.reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Letto> getLettos() {
		return this.lettos;
	}

	public void setLettos(List<Letto> lettos) {
		this.lettos = lettos;
	}

	public Letto addLetto(Letto letto) {
		getLettos().add(letto);
		letto.setStanzaBean(this);

		return letto;
	}

	public Letto removeLetto(Letto letto) {
		getLettos().remove(letto);
		letto.setStanzaBean(null);

		return letto;
	}

	public Ospedale getOspedaleBean() {
		return this.ospedaleBean;
	}

	public void setOspedaleBean(Ospedale ospedaleBean) {
		this.ospedaleBean = ospedaleBean;
	}

}