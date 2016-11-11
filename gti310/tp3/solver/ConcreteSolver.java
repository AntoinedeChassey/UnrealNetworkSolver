package gti310.tp3.solver;

import java.util.List;

import gti310.tp3.entities.RawData;
import gti310.tp3.entities.TreatedData;

public class ConcreteSolver implements Solver<RawData, TreatedData> {

	@Override
	public TreatedData solve(RawData input) {
		// TODO Auto-generated method stub

		List<Integer[]> livraisons = input.getLivraisons();
		for (Integer[] livraison : livraisons)
			System.out.println(input.getLivraisonPoids(livraison));

		// TreatedData treatedData = new TreatedData(nbrSommets, valPourInfinie,
		// sommetDepart, livraisons);

		// Create a 2 dimension matrix
		Integer[][] graph = new Integer[input.getLivraisons().size()][2];

		// return treatedData;
		return null;
	}

}
