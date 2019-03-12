package com.mutants.services;

import com.mutants.models.Humano;

public interface MutantService {

	boolean isMutant(String[] dnas);

	Humano obterPorId(Long id);
}
