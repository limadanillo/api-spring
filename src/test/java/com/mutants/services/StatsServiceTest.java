package com.mutants.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutants.models.Humano;
import com.mutants.models.Stats;
import com.mutants.services.HumanoService;
import com.mutants.services.StatsService;
import com.mutants.services.impl.HumanoServiceImpl;
import com.mutants.services.impl.StatsServiceImpl;

@RunWith(SpringRunner.class)
public class StatsServiceTest {

	@TestConfiguration
	static class BeneficiariosConfigurationTest {

		@Bean
		public StatsService statsService() {
			return new StatsServiceImpl();
		}

		@Bean
		public HumanoService humanoService() {
			return new HumanoServiceImpl();
		}
	}

	@Autowired
	private StatsService statsService;

	@MockBean
	private HumanoService humanoService;

	@Test
	public void deve_retornar_status() {

		Long countMutantDnaEsperado = 1L;
		Long countHumanDnaEsperado = 2L;
		BigDecimal ratioEsperado = new BigDecimal(0.5).setScale(2);

		List<Humano> listaHumanos = new ArrayList<>();
		listaHumanos.add(new Humano(null, true, null));
		listaHumanos.add(new Humano(null, false, null));

		when(humanoService.findAll()).thenReturn(listaHumanos);
		Stats stats = statsService.getStats();

		assertEquals(countMutantDnaEsperado, stats.getCountMutantDna());
		assertEquals(countHumanDnaEsperado, stats.getCountHumanDna());
		assertEquals(ratioEsperado, stats.getRatio());
	}

}
