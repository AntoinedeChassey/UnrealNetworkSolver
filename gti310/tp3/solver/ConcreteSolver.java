package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.List;

import gti310.tp3.entities.InputNode;
import gti310.tp3.entities.OutputNode;
import gti310.tp3.entities.RawData;
import gti310.tp3.entities.TreatedData;

public class ConcreteSolver implements Solver<RawData, TreatedData> {

	private List<InputNode<Integer, Integer, Integer>> noeuds_entree;
	private List<OutputNode<Integer, Integer>> noeuds_sortie = new ArrayList<>();
	private static Integer SOMMET_DEPART;
	private static Integer INFINIE;

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
		INFINIE = input.getValPourInfinie();
		SOMMET_DEPART = input.getSommetDepart();
	}

	@Override
	public TreatedData solve(RawData input) {
		// TODO Auto-generated method stub
		init(input);

		// for (InputNode<Integer, Integer[]> noeud : noeuds_entree) {
		// System.out.println(noeud.source);
		// }

		// for (Iterator<InputNode<Integer, Integer[]>> i =
		// noeuds_entree.iterator(); i.hasNext();) {
		// InputNode<Integer, Integer[]> noeud = i.next();
		// Integer source = noeud.source;
		// Integer tmpSource = source;
		// Integer poidsMini = input.getValPourInfinie();
		//
		// // OutputNode object
		// OutputNode<Integer, Integer> noeudRetenu = new OutputNode<>();
		// Integer poids = 0;
		// while (tmpSource == noeud.source) {
		// Integer destination = noeud.destinationEtPoids[0];
		// poids = noeud.destinationEtPoids[1];
		// noeudRetenu.parent = source;
		// noeudRetenu.poids = poids;
		// if (poids < poidsMini)
		// poidsMini = poids;
		// System.out.println(source + "\t" + destination + "\t" + poids);
		// if (i.hasNext()) {
		// noeud = i.next();
		// } else
		// break;
		// }
		// poidsTotal += poids;
		// noeuds_sortie.add(noeudRetenu);
		// System.out.println("Poids mini pour le noeud " + source + ": " +
		// poidsMini);
		// }
		// System.out.println("Poids total du trajet: " + poidsTotal);
		// TreatedData treatedData = new TreatedData(sommetDepart,
		// noeuds_sortie);
		// return treatedData;
		// }

		int size = input.getNbrSommets();
		int[][] matrix = new int[size][size];
		int[] distance = new int[size];
		int[] visited = new int[size];
		int[] preD = new int[size];
		int min = INFINIE;
		int nextNode = 0;

		// Build the matrix
		int k = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				InputNode<Integer, Integer, Integer> noeud = noeuds_entree.get(k);
				Integer source = noeud.source;
				Integer destination = noeud.destination;
				Integer poids = noeud.poids;
				// Set index to avoid ArrayIndexOutOfBoundsException
				source += -1;
				destination += -1;
				matrix[source][destination] = poids;
				if (matrix[i][j] == 0)
					matrix[i][j] = INFINIE;
				System.out.print(matrix[i][j] + " ");
				// Check index
				if (k < noeuds_entree.size() - 1)
					k++;
			}
			System.out.println();
		}

		// for (Iterator<InputNode<Integer, Integer, Integer>> k =
		// noeuds_entree.iterator(); k.hasNext();) {
		// InputNode<Integer, Integer, Integer> noeud = k.next();
		// Integer source = noeud.source;
		// Integer destination = noeud.destination;
		// Integer poids = noeud.poids;
		//
		// // Set the index of the matrix to begining
		// source += -1;
		// destination += -1;
		// matrix[source][destination] = poids;
		// if (matrix[source][destination] == 0)
		// matrix[source][destination] = INFINIE;
		// // OutputNode object
		// OutputNode<Integer, Integer> noeudRetenu = new OutputNode<>();
		// }

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < size; i++) {
			visited[i] = 0;
			preD[i] = 0;
		}

		// Set the starting node
		distance = matrix[SOMMET_DEPART];
		distance[SOMMET_DEPART] = 0;
		visited[SOMMET_DEPART] = 1;

		for (int i = 0; i < size; i++) {
			min = INFINIE;
			for (int j = 0; j < size; j++) {
				if (min > distance[j] && visited[j] != 1) {
					min = distance[j];
					nextNode = j;
				}
			}

			visited[nextNode] = 1;

			// Start the algorithm
			for (int c = 0; c < size; c++) {
				if (visited[c] != 1) {
					if (min + matrix[nextNode][c] < distance[c]) {
						distance[c] = min + matrix[nextNode][c];
						preD[c] = nextNode;
					}
				}
			}
		}
		
		System.out.print("\nBest distance: ");
		for (int i = 0; i < size; i++) {
			System.out.print("|" + distance[i]);
		}
		System.out.print("|" + "\n");

		// Printing the paths
		for (int i = 0; i < size; i++) {
			int j;
			System.out.println("Path = " + i);
			j = i;
			do {
				j = preD[j];
				System.out.println(" <- " + j);
			} while (j != 0);
			System.out.println();
		}

		//
		// for (Iterator<InputNode<Integer, Integer[]>> i =
		// noeuds_entree.iterator(); i.hasNext();) {
		// InputNode<Integer, Integer[]> noeud = i.next();
		// System.out.println(noeud.source);
		// }
		TreatedData treatedData = new TreatedData(SOMMET_DEPART, noeuds_sortie);
		return treatedData;
	}
}
