package com.mutants.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mutants.models.Stats;

public class StatsTest {

	@Test
	public void deve_retornar_to_string() {
		assertNotNull(Stats.builder().build().toString());
	}

	@Test
	public void deve_retornar_hash_code() {
		assertNotNull(Stats.builder().build().hashCode());
	}
	
	@Test
	public void deve_retornar_false() {
		assertFalse(Stats.builder().build().equals(null));
	}

}
