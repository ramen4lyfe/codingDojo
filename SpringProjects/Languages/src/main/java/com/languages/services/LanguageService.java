package com.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository repo;
	
	public LanguageService(LanguageRepository repo) {
		this.repo = repo;
	}
	
	public List<Language>all() {
		return repo.findAll();
	}
	
	public Language create(Language b) {
		return repo.save(b);
	}
	
	public Language update(Language b) {
		return repo.save(b);
	}
	
	public Language find(Long id) {
        Optional<Language> optional = repo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    public void delete(Long id) {
    	repo.deleteById(id);
    }

}
