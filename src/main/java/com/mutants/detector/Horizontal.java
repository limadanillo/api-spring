package com.mutants.detector;

public class Horizontal implements Detector {

	@Override
	public int get(String[] dna, int linha, int coluna) {
		if (coluna < dna[linha].length() - 3) {
	        
			String horizontal = "";
	        char letra = dna[linha].charAt(coluna);
	        
	        horizontal += letra;
	        horizontal += dna[linha].charAt(coluna + 1);
	        horizontal += dna[linha].charAt(coluna + 2);
	        horizontal += dna[linha].charAt(coluna + 3);
	        
	        String letras = horizontal.replace(String.valueOf(letra), "");

	        return letras.length() == 0 ? 1 : 0;
    	}
    	
    	return 0;
	}

}
