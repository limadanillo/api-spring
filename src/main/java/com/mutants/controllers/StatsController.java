package com.mutants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.services.StatsService;

@RestController
@RequestMapping("/stats")
public class StatsController {

	@Autowired
	private StatsService statsService;

	@Cacheable("stats")
	@GetMapping
	public ResponseEntity<?> getStatus() {
		return ResponseEntity.ok(statsService.getStats());
	}

}
