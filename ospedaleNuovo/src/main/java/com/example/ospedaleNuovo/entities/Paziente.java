package com.example.ospedaleNuovo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the paziente database table.
 * 
 */
@Entity
@NamedQuery(name="Paziente.findAll", query="SELECT p FROM Paziente p")
public class Paziente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="cod_fiscale")
	private String codFiscale;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to Letto
	@OneToMany(mappedBy="paziente")
	private List<Letto> lettos;

	public Paziente() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodFiscale() {
		return this.codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Letto> getLettos() {
		return this.lettos;
	}

	public void setLettos(List<Letto> lettos) {
		this.lettos = lettos;
	}

	public Letto addLetto(Letto letto) {
		getLettos().add(letto);
		letto.setPaziente(this);

		return letto;
	}

	public Letto removeLetto(Letto letto) {
		getLettos().remove(letto);
		letto.setPaziente(null);

		return letto;
	}

}