package com.mutants.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.models.Humano;
import com.mutants.repositories.HumanoRepository;
import com.mutants.services.HumanoService;

@Service
public class HumanoServiceImpl implements HumanoService {

	@Autowired
	private HumanoRepository humanoRepository;

	@Override
	public Humano save(Humano humano) {
		Humano humanoSave = null;
		
		Optional<Humano> optionalHumano = humanoRepository.findByDna(humano.getDna());
		if (!optionalHumano.isPresent()) {
			humanoSave = humanoRepository.save(humano);
		}
		
		return humanoSave;
	}

	@Override
	public List<Humano> findAll() {
		return humanoRepository.findAll();
	}
}
