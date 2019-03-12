package com.mutants.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.models.Humano;
import com.mutants.models.Stats;
import com.mutants.services.HumanoService;
import com.mutants.services.StatsService;

@Service
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	private HumanoService humanoService;
	
	@Override
	public Stats getStats() {
		List<Humano> humanos = humanoService.findAll();
		
		Long countHumanDna = (long) humanos.size();
		Long countMutantDna = humanos.stream().filter(humano -> humano.isMutation()).count();
		BigDecimal ratio = BigDecimal.ZERO;
		
		if(countMutantDna != 0) {
			ratio = new BigDecimal(countMutantDna.doubleValue() / countHumanDna.doubleValue()).setScale(2, RoundingMode.HALF_UP);
		}
		
		return Stats.builder()
				.countMutantDna(countMutantDna)
				.countHumanDna(countHumanDna)
				.ratio(ratio)
				.build();
	}
}
