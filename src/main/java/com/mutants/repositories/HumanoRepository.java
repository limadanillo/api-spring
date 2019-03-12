package com.mutants.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mutants.models.Humano;

public interface HumanoRepository extends JpaRepository<Humano, Long> {

	Optional<Humano> findByDna(String[] dna);

}
