package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import gti310.tp3.entities.RawData;

public class ConcreteParser implements Parser<RawData> {

	private HashMap<Integer, Integer[]> noeuds = new HashMap<>();

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
	 * Returns 3 integers contained in the line currently read
	 */
	private void storeNodes(String strLine) {
		// Create an Integer array, size of 3 values
		Integer[] noeud = new Integer[3];

		// Store the source -- first Integer
		Integer firstTab = strLine.indexOf("\t");
		noeud[0] = Integer.parseInt(strLine.substring(0, firstTab));
		// Cut the string
		strLine = strLine.substring(firstTab + 1);
		// Store the destination -- second Integer
		Integer secondTab = strLine.indexOf("\t");
		noeud[1] = Integer.parseInt(strLine.substring(0, secondTab));
		// Cut the string
		strLine = strLine.substring(secondTab + 1);
		// Store the weight -- third Integer
		noeud[2] = Integer.parseInt(strLine);
		
		// Store the shipment in the shipments array
		noeuds.put(noeud[0], noeud);
	}

}