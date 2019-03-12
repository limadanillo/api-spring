package com.mutants.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mutants.models.Humano;

public class HumanoTest {

	@Test
	public void deve_retornar_to_string() {
		assertNotNull(Humano.builder().build().toString());
	}

	@Test
	public void deve_retornar_hash_code() {
		assertNotNull(Humano.builder().build().hashCode());
	}

	@Test
	public void deve_retornar_false() {
		assertFalse(Humano.builder().build().equals(null));
	}

}
