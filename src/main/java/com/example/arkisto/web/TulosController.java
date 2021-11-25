package com.example.arkisto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.arkisto.domain.LajiRepository;
import com.example.arkisto.domain.Tulos;
import com.example.arkisto.domain.TulosRepository;


@Controller
public class TulosController {
	
	@Autowired
	private TulosRepository trepository;
	
	@Autowired
	private LajiRepository lrepository;
	
	//LISTAA
	
	@RequestMapping(value= {"/", "/tuloslista"})
	public String nostoArkisto(Model model) {
		model.addAttribute("tulokset", trepository.findAll());
		return "tuloslista";
	}
	
	//LISÄÄ
	@RequestMapping(value = "/lisää")
	
	public String lisaaTulos(Model model) {
		model.addAttribute("tulos", new Tulos());
		model.addAttribute("lajit", lrepository.findAll());
		return "lisaatulos";
	}
	
	//TALLENNA
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	public String save(Tulos tulos) {
		trepository.save(tulos);
		return "redirect:tuloslista";
	}
	
	//MUOKKAA
	@RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
	
	public String modiftBook(@PathVariable("id") Long tulosId, Model model) {
		java.util.Optional<Tulos> tulos = trepository.findById(tulosId);
		model.addAttribute("tulos", tulos);
		model.addAttribute("lajit", lrepository.findAll());
		return "muokkaatulos";
	}
	
	//POISTA
	@RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String poistaTulos(@PathVariable("id") Long tulosId, Model model) {
		trepository.deleteById(tulosId);
		return "redirect:../tuloslista";
	}
	
	//REST TULOS ID:llä
	@RequestMapping(value="/tulos/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Tulos> etsiTulosRest(@PathVariable("id") Long tulosId) {
		return trepository.findById(tulosId);
	
	}
	
	//REST KAIKKI TULOKSET
	@RequestMapping(value="/tulokset", method = RequestMethod.GET)
	public @ResponseBody List<Tulos> tuloslistaRest() {
		return (List<Tulos>) trepository.findAll();
		
	}
	
	//KIRJAUTUMINEN
	
	@RequestMapping(value="/kirjaudu")
	public String kirjaudu() {
		return "kirjaudu";
	
	}
}
