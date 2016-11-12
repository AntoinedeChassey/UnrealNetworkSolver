package gti310.tp3;

import java.io.IOException;

import gti310.tp3.entities.RawData;
import gti310.tp3.entities.TreatedData;
import gti310.tp3.parser.ConcreteParser;
import gti310.tp3.parser.Parser;
import gti310.tp3.solver.ConcreteSolver;
import gti310.tp3.solver.Solver;
import gti310.tp3.writer.ConcreteWriter;
import gti310.tp3.writer.Writer;

/**
 * The Application class defines a template method to call the elements to solve
 * the problem Unreal-Networks is façing.
 * 
 * @author François Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the input
	 * file, and the complete path to the output file.
	 * 
	 * @param args
	 *            The array containing the arguments to the files.
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		System.out.println("Unreal Networks Solver !\n");

		// Read the file and parse the contained data in an accessible format
		Parser<RawData> myParser = new ConcreteParser();
		RawData rawData = myParser.parse(args[0]);

		// Process the read data and solve it
		Solver<RawData, TreatedData> mySolver = new ConcreteSolver();
		TreatedData treatedData = mySolver.solve(rawData);

		// Write this to an output file
		Writer<TreatedData> myWriter = new ConcreteWriter();
		myWriter.write(args[1], treatedData);
	}
}
