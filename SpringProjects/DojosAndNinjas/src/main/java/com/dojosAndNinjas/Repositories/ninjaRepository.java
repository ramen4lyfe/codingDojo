package com.dojosAndNinjas.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojosAndNinjas.Models.Ninja;

@Repository
public interface ninjaRepository extends CrudRepository<Ninja, Long>{
	
	
}
