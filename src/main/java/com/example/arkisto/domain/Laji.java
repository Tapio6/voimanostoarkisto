package com.example.arkisto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Laji {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long lajiId;
	private String type;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "laji")
	private List<Tulos> tulokset;
	
	public Laji() {}
	
	public Laji(String type) {
		super();
		this.type = type;
	}

	public Long getLajiId() {
		return lajiId;
	}

	public void setLajiId(Long lajiId) {
		this.lajiId = lajiId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Tulos> getTulokset() {
		return tulokset;
	}

	public void setTulokset(List<Tulos> tulokset) {
		this.tulokset = tulokset;
	}

	@Override
	public String toString() {
		return "Laji [lajiId=" + lajiId + ", type=" + type +  "]";
	}


	
}
