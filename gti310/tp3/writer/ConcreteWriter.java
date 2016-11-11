package gti310.tp3.writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import gti310.tp3.entities.TreatedData;

public class ConcreteWriter implements Writer<TreatedData> {

	@Override
	public void write(String filename, TreatedData output) throws IOException {
		// TODO Auto-generated method stub

		/**
		 * TODO: Check "throws FileNotFoundException" for ConcreteWriter and
		 * ConcreteParser
		 */

		// Create the file stream and buffered writer
		FileOutputStream fstream = new FileOutputStream(filename);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));

		// Write in the file
		bw.write(output.getSommetDepart() + "\n");
		List<Integer[]> chemins = output.getchemins();
		for (Integer[] chemin : chemins) {
			bw.write(output.getCheminParent(chemin) + "\t" + output.getCheminPoids(chemin) + "\n");
		}

		// Close the file
		bw.close();
	}

}
