package com.dojosAndNinjas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosAndNinjas.Models.Dojo;
import com.dojosAndNinjas.Models.Ninja;
import com.dojosAndNinjas.Repositories.dojoRepository;
import com.dojosAndNinjas.Repositories.ninjaRepository;

@Service
public class dojosAndNinjasService {

	@Autowired
	private dojoRepository dojoRepo;
	
	@Autowired
	private ninjaRepository ninjaRepo;
	
	// method to populate everysingle dojo
	public List<Dojo> allDojos() {
		return this.dojoRepo.findAll();
	}
	
	//create a dojo
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	//create a ninja
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	//retrieve a dojo
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
		//return id or nothing. need to put in this orElse
	}
}
