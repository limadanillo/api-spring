package com.mutants.detector;

import java.util.ArrayList;
import java.util.List;

public class Detectors {

	public static List<Detector> getAll(){
		List<Detector> detectors = new ArrayList<>();
		detectors.add(new Diagonal());
		detectors.add(new DiagonalReverse());
		detectors.add(new Horizontal());
		detectors.add(new Vertical());
		return detectors;
	}
}
