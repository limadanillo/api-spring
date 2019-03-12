package com.mutants.detector;

public class DiagonalReverse implements Detector {

	@Override
	public int get(String[] dna, int linha, int coluna) {

		if ((linha < dna[linha].length() - 3) && (coluna > 3)) {
			String diagonalReversa = "";
			char letra = dna[linha].charAt(coluna);

			diagonalReversa += letra;
			diagonalReversa += dna[linha + 1].charAt(coluna - 1);
			diagonalReversa += dna[linha + 2].charAt(coluna - 2);
			diagonalReversa += dna[linha + 3].charAt(coluna - 3);

			String letras = diagonalReversa.replace(String.valueOf(letra), "");

			return letras.length() == 0 ? 1 : 0;
		}

		return 0;
	}

}
