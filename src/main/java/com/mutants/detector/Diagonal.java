package com.mutants.detector;

public class Diagonal implements Detector {

	@Override
	public int get(String[] dna, int linha, int coluna) {

		if ((linha < dna[linha].length() - 3) && (coluna < dna[linha].length() - 3)) {
			String diagonal = "";
			char letra = dna[linha].charAt(coluna);

			diagonal += letra;
			diagonal += dna[linha + 1].charAt(coluna + 1);
			diagonal += dna[linha + 2].charAt(coluna + 2);
			diagonal += dna[linha + 3].charAt(coluna + 3);

			String letras = diagonal.replace(String.valueOf(letra), "");

			return letras.length() == 0 ? 1 : 0;
		}

		return 0;
	}

}
