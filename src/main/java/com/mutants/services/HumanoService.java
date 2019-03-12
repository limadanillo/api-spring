package com.mutants.services;

import java.util.List;

import com.mutants.models.Humano;

public interface HumanoService {

	Humano save(Humano humano);

	List<Humano> findAll();
}
