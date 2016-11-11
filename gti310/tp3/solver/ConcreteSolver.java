package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gti310.tp3.entities.RawData;
import gti310.tp3.entities.TreatedData;

public class ConcreteSolver implements Solver<RawData, TreatedData> {

	private HashMap<Integer, Integer[]> noeuds;
	private List<Integer[]> chemins = new ArrayList<Integer[]>();
	private Integer sommetDepart;

	/**
	 * 
	 * Par exemple, avec l'exemple de solution de l'énoncé, on lit que pour se
	 * rendre au sommet 7, il faut emprunter le sommet 6 ET pour emprunter le
	 * sommet 6, il faut emprunter le sommet 3 ET pour emprunter le sommet 3, il
	 * faut emprunter le sommet ET le sommet 1 est le sommet de départ. On
	 * conclut donc que pour un vendeur situé au sommet 1, il devra d'abord se
	 * rendre directement au sommet 3, puis directement au sommet 6 et enfin
	 * directement au sommet 7 s'il veut emprunter la route la plus courte.
	 * C'est donc dire que votre programme utilise l'algorithme de Dijkstra pour
	 * évaluer les trajets les plus courts d'un point du graphe sans construire
	 * une réelle table de Dijkstra où on spécifierait le nœud suivant au lieu
	 * du nœud parent.
	 * 
	 * @param input
	 */
	public void init(RawData input) {
		noeuds = input.getNoeuds();
		sommetDepart = input.getSommetDepart();
	}

	@Override
	public TreatedData solve(RawData input) {
		// TODO Auto-generated method stub
		init(input);

		Integer[] noeud = noeuds.get(1);
		for (Integer value : noeud)
			System.out.println(value + "\t");

		// Create a 2 dimension matrix
		// Integer[][] graph = new Integer[input.getLivraisons().size()][2];
		/*
		 * for (Iterator<Integer, Integer[]> i = noeuds.iterator();
		 * i.hasNext();) { Integer[] livraison = i.next(); Integer source =
		 * livraison[0]; Integer destination = livraison[1]; Integer poids =
		 * livraison[2]; Integer tmpSource = source; while (tmpSource == source)
		 * { source = livraison[0]; destination = livraison[1]; poids =
		 * livraison[2]; System.out.println(source + "\t" + destination + "\t" +
		 * poids); if (i.hasNext()) livraison = i.next(); else break; } } /* for
		 * (Integer[] livraison : livraisons) { // Create an Integer array, size
		 * of 2 values (parent & weight) Integer[] chemin = new Integer[2]; if
		 * (sommetDepart == input.getLivraisonSource(livraison)) { // Set parent
		 * to -1 chemin[0] = -1; // Set weight to 0 chemin[1] = 0; // Add the
		 * path in paths chemins.add(chemin); } else { chemin[0] =
		 * getBestPath(); } }
		 */

		TreatedData treatedData = new TreatedData(sommetDepart, chemins);
		return treatedData;
	}

}
