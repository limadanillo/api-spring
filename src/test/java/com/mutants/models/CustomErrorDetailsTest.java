package com.mutants.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mutants.exceptions.handlers.CustomErrorDetails;

public class CustomErrorDetailsTest {

	@Test
	public void deve_retornar_to_string() {
		assertNotNull(CustomErrorDetails.builder().build().toString());
	}

	@Test
	public void deve_retornar_hash_code() {
		assertNotNull(CustomErrorDetails.builder().build().hashCode());
	}

	@Test
	public void deve_retornar_false() {
		assertFalse(CustomErrorDetails.builder().build().equals(null));
	}
}
