package com.example.arkisto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LajiRepository extends CrudRepository<Laji, Long> {
	
	List<Laji> findByType(String type);

}
