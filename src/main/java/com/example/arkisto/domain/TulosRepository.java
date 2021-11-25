package com.example.arkisto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface TulosRepository extends CrudRepository<Tulos, Long> {
	
	List<Tulos> findBySukuNimi(String sukuNimi);

}
