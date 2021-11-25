package com.example.arkisto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tulos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String etuNimi;
	private String sukuNimi;
	private String paino;
	private String tulos;
	
	@ManyToOne
	@JoinColumn(name = "lajiId")
	private Laji laji;
	
	public Tulos() {
	}
	
	public Tulos(String etuNimi, String sukuNimi, String paino, Laji laji, String tulos) {
		super();
		this.etuNimi = etuNimi;
		this.sukuNimi = sukuNimi;
		this.paino = paino;
		this.laji = laji;
		this.tulos = tulos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtuNimi() {
		return etuNimi;
	}

	public void setEtuNimi(String etuNimi) {
		this.etuNimi = etuNimi;
	}

	public String getSukuNimi() {
		return sukuNimi;
	}

	public void setSukuNimi(String sukuNimi) {
		this.sukuNimi = sukuNimi;
	}

	public String getPaino() {
		return paino;
	}

	public void setPaino(String paino) {
		this.paino = paino;
	}

	public String getTulos() {
		return tulos;
	}

	public void setTulos(String tulos) {
		this.tulos = tulos;
	}

	public Laji getLaji() {
		return laji;
	}

	public void setLaji(Laji laji) {
		this.laji = laji;
	}

	@Override
	public String toString() {
		return "Tulos [id=" + id + ", etuNimi=" + etuNimi + ", sukuNimi=" + sukuNimi + ", paino=" + paino + ", tulos="
				+ tulos + ", laji=" + laji + "]";
	}



	
}
	
	
