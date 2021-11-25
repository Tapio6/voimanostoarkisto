package com.example.arkisto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.arkisto.domain.Laji;
import com.example.arkisto.domain.LajiRepository;
import com.example.arkisto.domain.Tulos;
import com.example.arkisto.domain.TulosRepository;
import com.example.arkisto.ArkistoApplication;

@SpringBootApplication
public class ArkistoApplication {
	private static final Logger log = LoggerFactory.getLogger(ArkistoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ArkistoApplication.class, args);
	}

	@Bean
	public CommandLineRunner nostoArkisto(TulosRepository trepository, LajiRepository lrepository) {
		return (args) -> {
			log.info("tallenna nostotulokset");

			lrepository.save(new Laji("Penkkipunnerrus"));
			lrepository.save(new Laji("Maastaveto"));
			lrepository.save(new Laji("Jalkakyykky"));

			trepository.save(new Tulos("Matti", "Meikäläinen", "86", lrepository.findByType("Penkkipunnerrus").get(0), "180"));
			trepository.save(new Tulos("Matti", "Meikäläinen", "86", lrepository.findByType("Maastaveto").get(0), "340"));
			trepository.save(new Tulos("Pekka", "Pouta", "75", lrepository.findByType("Maastaveto").get(0), "300"));
			trepository.save(new Tulos("Mika", "Malmi", "120", lrepository.findByType("Jalkakyykky").get(0), "450"));

			log.info("näytä kaikki tulokset");
			for (Tulos tulos : trepository.findAll()) {
				log.info(tulos.toString());
			}
		};
	}
}
