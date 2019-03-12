package com.mutants.detector;

public class Vertical implements Detector {

	@Override
	public int get(String[] dna, int linha, int coluna) {

		if (linha < dna[linha].length() - 3) {
			String vertical = "";
			char letra = dna[linha].charAt(coluna);

			vertical += letra;
			vertical += dna[linha + 1].charAt(coluna);
			vertical += dna[linha + 2].charAt(coluna);
			vertical += dna[linha + 3].charAt(coluna);

			String letras = vertical.replace(String.valueOf(letra), "");

			return letras.length() == 0 ? 1 : 0;
		}

		return 0;
	}

}
