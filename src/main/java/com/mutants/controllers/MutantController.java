package com.mutants.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mutants.models.Humano;
import com.mutants.services.HumanoService;
import com.mutants.services.MutantService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/mutants")
public class MutantController {

	@Autowired
	private MutantService mutantService;

	@Autowired
	private HumanoService humanoService;

	@PostMapping
	public ResponseEntity<?> isMutant(@RequestBody String[] dna) throws Exception {

		boolean mutation = mutantService.isMutant(dna);
		Humano humano = humanoService.save(Humano.builder().mutation(mutation).dna(dna).build());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(humano.getId()).toUri();

		return ResponseEntity.created(uri).body(mutation);
	}
	
	@ApiIgnore
	@GetMapping("/{id}")
	public ResponseEntity<Humano> obterPorId(@PathVariable Long id) {
		return ResponseEntity.ok(mutantService.obterPorId(id));
	}

}
