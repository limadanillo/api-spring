package com.mutants.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.detector.Detector;
import com.mutants.detector.Detectors;
import com.mutants.models.Humano;
import com.mutants.repositories.MutantRepository;
import com.mutants.services.MutantService;

@Service
public class MutantServiceImpl implements MutantService {

	@Autowired
	private MutantRepository mutantRepository;

	@Override
	public boolean isMutant(String[] dna) {
		int senquenciaEncontrada = 0;

		for (int linha = 0; linha < dna.length; linha++) {
			for (int coluna = 0; coluna < dna[linha].length(); coluna++) {
				for (Detector detectors : Detectors.getAll()) {
					senquenciaEncontrada += detectors.get(dna, linha, coluna);
					if (senquenciaEncontrada > 1)
						return true;
				}
			}
		}

		return false;
	}

	@Override
	public Humano obterPorId(Long id) {
		Optional<Humano> optional = mutantRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}
}
