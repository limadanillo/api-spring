package com.mutants.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutants.repositories.MutantRepository;
import com.mutants.services.MutantService;
import com.mutants.services.impl.MutantServiceImpl;

@RunWith(SpringRunner.class)
public class MutantServiceTest {

	private static final boolean NAO_MUTANT = false;

	private static final boolean MUTANT = true;

	@TestConfiguration
	static class MutantConfigurationTest {

		@Bean
		public MutantService mutationService() {
			return new MutantServiceImpl();
		}
	}

	@Autowired
	private MutantService mutationService;
	
	@MockBean
	private MutantRepository mutantRepository;	

	@Before
	public void setUp() {
		when(mutantRepository.findAll()).thenReturn(new ArrayList<>());
	}

	@Test
	public void deve_retornar_nao_mutant() {
		String[] dnas = { "ACTGAG", "CAATGT", "ACTGAG", "CATAGT", "ACTGAG", "CAAAGT" };
		assertThat(mutationService.isMutant(dnas)).isEqualTo(NAO_MUTANT);
	}

	@Test
	public void deve_retornar_nao_mutant_para_apenas_um_segmento_mutado() {
		String[] dnas = { "AAAATT", "CAATGT", "ACTGAG", "CATAGT", "ACTGAG", "CAAAGT" };
		assertThat(mutationService.isMutant(dnas)).isEqualTo(NAO_MUTANT);
	}

	@Test
	public void deve_retornar_mutant_para_seuencia_dna_horizontal() {
		String[] dnas = { "AAAATT", "TTTTAA", "AAAATT", "TTTTAA", "AAAATT", "TTTTAA" };
		assertThat(mutationService.isMutant(dnas)).isEqualTo(MUTANT);
	}

	@Test
	public void deve_retornar_mutant_para_sequencia_dna_vertical() {
		String[] dnas = { "ACCTGG", "ACTCAG", "ACTCAC", "ACTGGA" };
		assertThat(mutationService.isMutant(dnas)).isEqualTo(MUTANT);
	}

	@Test
	public void deve_retornar_mutant_para_sequencia_dna_diagonal_reversa() {
		String[] dnas = { "GCCCAT", "CCCATC", "GCATCC", "GATCCG", "CATCCC", "CATCGG" };
		assertThat(mutationService.isMutant(dnas)).isEqualTo(MUTANT);
	}

	@Test
	public void deve_retornar_mutant_para_sequencia_dna_diagonal() {
		String[] dnas = { "ACCTGG", "AATCAG", "ACACAC", "ACTAGA" };
		assertThat(mutationService.isMutant(dnas)).isEqualTo(MUTANT);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deve_retornar_exception_quando_dna_nao_obedecer_nxn() {
		String[] dnas = { "GATCCG", "GATCCG" };
		mutationService.isMutant(dnas);
	}

}
