package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gti310.tp3.entities.InputNode;
import gti310.tp3.entities.OutputNode;
import gti310.tp3.entities.RawData;
import gti310.tp3.entities.TreatedData;

public class ConcreteSolver implements Solver<RawData, TreatedData> {

	private List<InputNode<Integer, Integer[]>> noeuds_entree;
	private List<OutputNode<Integer, Integer>> noeuds_sortie = new ArrayList<>();
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
		noeuds_entree = input.getNoeuds();
		sommetDepart = input.getSommetDepart();
	}

	@Override
	public TreatedData solve(RawData input) {
		// TODO Auto-generated method stub
		init(input);

		// for (InputNode<Integer, Integer[]> noeud : noeuds_entree) {
		// System.out.println(noeud.source);
		// }

		for (Iterator<InputNode<Integer, Integer[]>> i = noeuds_entree.iterator(); i.hasNext();) {
			InputNode<Integer, Integer[]> noeud = i.next();
			Integer source = noeud.source;
			Integer tmpSource = source;
			Integer poidsMini = input.getValPourInfinie();

			// Best InputNode object
			OutputNode<Integer, Integer> noeudRetenu = new OutputNode<>();

			while (tmpSource == noeud.source) {
				Integer destination = noeud.destinationEtPoids[0];
				Integer poids = noeud.destinationEtPoids[1];
				noeudRetenu.parent = source;
				noeudRetenu.poids = poids;
				if (poids < poidsMini)
					poidsMini = poids;
				System.out.println(source + "\t" + destination + "\t" + poids);
				if (i.hasNext()) {
					noeud = i.next();
				} else
					break;
			}
			noeuds_sortie.add(noeudRetenu);
			System.out.println("Poids mini pour le noeud " + source + ": " + poidsMini + "\n");
		}

		TreatedData treatedData = new TreatedData(sommetDepart, noeuds_sortie);
		return treatedData;
	}

}
