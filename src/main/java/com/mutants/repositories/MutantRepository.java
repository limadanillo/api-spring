package com.mutants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mutants.models.Humano;

public interface MutantRepository extends JpaRepository<Humano, Long> {

}
