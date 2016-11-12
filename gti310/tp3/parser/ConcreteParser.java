package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import gti310.tp3.entities.InputNode;
import gti310.tp3.entities.RawData;

public class ConcreteParser implements Parser<RawData> {

	private List<InputNode<Integer, Integer, Integer>> noeuds = new ArrayList<>();

	@Override
	public RawData parse(String filename) throws IOException {
		// TODO Auto-generated method stub

		// Open the file
		FileInputStream fstream = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		int counterLine = 1;

		// Create a new RawData object
		Integer nbrSommets = null;
		Integer valPourInfinie = null;
		Integer sommetDepart = null;
		RawData rawData = new RawData(nbrSommets, valPourInfinie, sommetDepart, noeuds);

		// Read the file line by line until "$" is encounterLineed
		while ((strLine = br.readLine()) != null && !strLine.equals("$")) {
			if (counterLine == 1) {
				rawData.setNbrSommets(Integer.parseInt(strLine));
			}
			if (counterLine == 2) {
				rawData.setValPourInfinie(Integer.parseInt(strLine));
			}
			if (counterLine == 3) {
				// If no summit, set it to 1
				if (strLine.equals(""))
					rawData.setSommetDepart(1);
				else
					rawData.setSommetDepart(Integer.parseInt(strLine));
			}
			if (counterLine > 3) {
				storeNodes(strLine);
			}
			counterLine++;
		}

		// Close the input stream
		br.close();

		return rawData;
	}

	/**
	 * Returns
	 */
	private void storeNodes(String strLine) {
		InputNode<Integer, Integer, Integer> noeud = new InputNode<Integer, Integer, Integer>();

		// Store the source -- first Integer
		Integer firstTab = strLine.indexOf("\t");
		noeud.source = Integer.parseInt(strLine.substring(0, firstTab));
		// Cut the string
		strLine = strLine.substring(firstTab + 1);
		// Store the destination -- second Integer
		Integer secondTab = strLine.indexOf("\t");
		noeud.destination = Integer.parseInt(strLine.substring(0, secondTab));
		// Cut the string
		strLine = strLine.substring(secondTab + 1);
		// Store the weight -- third Integer
		noeud.poids = Integer.parseInt(strLine);

		noeuds.add(noeud);
	}

}