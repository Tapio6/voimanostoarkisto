package com.example.arkisto.domain;

import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
	 Kayttaja findByKayttaja(String kayttaja);
	}