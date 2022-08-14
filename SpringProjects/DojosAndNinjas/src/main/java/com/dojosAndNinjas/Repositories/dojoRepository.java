package com.dojosAndNinjas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojosAndNinjas.Models.Dojo;

@Repository
public interface dojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
