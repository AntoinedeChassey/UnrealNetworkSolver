package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import gti310.tp3.entities.Node;
import gti310.tp3.entities.RawData;

public class ConcreteParser implements Parser<RawData> {

	private List<Node<Integer, Integer, Integer>> noeuds = new ArrayList<>();
	private Integer nbrSommets;

	@Override
	public RawData parse(String filename) {
		// TODO Auto-generated method stub

		// Open the file
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(filename);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			System.err.println("The file does not exist.");
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		int counterLine = 1;

		// Create a new RawData object
		nbrSommets = null;
		Integer valPourInfinie = null;
		Integer sommetDepart = null;
		RawData rawData = new RawData(nbrSommets, valPourInfinie, sommetDepart, noeuds);

		// Read the file line by line until "$" is encountered and valid
		try {
			while ((strLine = br.readLine()) != null && !strLine.equals("$") && isValid(strLine)) {
				if (counterLine == 1) {
					try {
						rawData.setNbrSommets(Integer.parseInt(strLine));
						nbrSommets = Integer.parseInt(strLine);
					} catch (NumberFormatException e) {
						// e.printStackTrace();
						System.err.println("Le nombre de sommets est incorrect.");
						System.exit(1);
					}

				}
				if (counterLine == 2) {
					try {
						rawData.setValPourInfinie(Integer.parseInt(strLine));
					} catch (NumberFormatException e) {
						// e.printStackTrace();
						System.err.println("La valeur pour l'infinie incorrecte.");
						System.exit(1);
					}
				}
				if (counterLine == 3) {
					try {
						// If no summit, set it to 1
						if (strLine.equals(""))
							rawData.setSommetDepart(1);
						else
							rawData.setSommetDepart(Integer.parseInt(strLine));
						if ((rawData.getSommetDepart() > 0 && rawData.getSommetDepart() <= nbrSommets) == false) {
							System.err.println("Le sommet de départ n'est pas correct.");
							System.exit(1);
						}
					} catch (NumberFormatException e) {
						// e.printStackTrace();
						System.err.println("Le sommet de départ est incorrect.");
						System.exit(1);
					}
				}
				if (counterLine > 3) {
					storeNodes(strLine);
				}
				counterLine++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (counterLine < 5) {
			System.err.println("Le fichier ne contient pas de noeuds.");
			System.exit(1);
		}
		return rawData;
	}

	private boolean isValid(String strLine) {
		if (strLine.matches(".*\\d+.*") || strLine.matches("") || strLine.matches(" "))
			return true;
		System.err.println("Le fichier n'a pas un bon format.");
		System.exit(1);
		return false;
	}

	/**
	 * Returns
	 */
	private void storeNodes(String strLine) {
		try {
			Node<Integer, Integer, Integer> noeud = new Node<Integer, Integer, Integer>();

			// Store the source -- first Integer
			Integer firstTab = strLine.indexOf("\t");
			try {
				noeud.source = Integer.parseInt(strLine.substring(0, firstTab));
			} catch (Exception e) {
				System.err.println("Un noeud est incorrect.");
				System.exit(1);
			}
			if ((noeud.source > 0 && noeud.source <= nbrSommets) == false) {
				System.err.println("La source d'un noeud est incorrecte.");
				System.exit(1);
			}
			// Cut the string
			strLine = strLine.substring(firstTab + 1);
			// Store the destination -- second Integer
			Integer secondTab = strLine.indexOf("\t");
			noeud.destination = Integer.parseInt(strLine.substring(0, secondTab));
			if ((noeud.destination > 0 && noeud.destination <= nbrSommets) == false) {
				System.err.println("La destination d'un noeud est incorrecte.");
				System.exit(1);
			}
			// Cut the string
			strLine = strLine.substring(secondTab + 1);
			// Store the weight -- third Integer
			noeud.poids = Integer.parseInt(strLine);

			noeuds.add(noeud);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println("Un noeud est incorrect.");
			System.exit(1);
		}
	}

}