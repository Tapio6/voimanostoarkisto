package com.example.arkisto.domain;

import javax.persistence.*;


@Entity
@Table(name = "unsertable")
public class Kayttaja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	
	private Long Id;
	
	@Column(name = "kayttaja", nullable = false, unique = true)
	private String kayttaja;
	
	@Column(name = "salasana", nullable = false)
	private String salasanaHash;
	
	@Column(name = "rooli", nullable = false)
	private String rooli;
	
	public Kayttaja() {}
	
	public Kayttaja(String kayttaja, String salasanaHash, String rooli) {
		super();
		this.kayttaja = kayttaja;
		this.salasanaHash = salasanaHash;
		this.rooli = rooli;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(String kayttaja) {
		this.kayttaja = kayttaja;
	}

	public String getSalasanaHash() {
		return salasanaHash;
	}

	public void setSalasanaHash(String salasanaHash) {
		this.salasanaHash = salasanaHash;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}
	
}
