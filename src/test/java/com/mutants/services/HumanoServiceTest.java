package com.mutants.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutants.models.Humano;
import com.mutants.repositories.HumanoRepository;
import com.mutants.services.HumanoService;
import com.mutants.services.impl.HumanoServiceImpl;

@RunWith(SpringRunner.class)
public class HumanoServiceTest {
	
	@TestConfiguration
	static class BeneficiariosConfigurationTest {
		
		@Bean
		public HumanoService humanoService() {
			return new HumanoServiceImpl();
		}
	}
	
	@Autowired
	private HumanoService humanoService;
	
	@MockBean
	private HumanoRepository humanoRepository;	
	
	@Test
	public void deve_salvar_humano() {
		humanoService.save(Humano.builder().build());
	}
	
	@Test
	public void deve_retornar_lista_de_humanos() {
		when(humanoRepository.findAll()).thenReturn(new ArrayList<>());
		assertThat(humanoService.findAll()).isNotNull();
	}
	
}

