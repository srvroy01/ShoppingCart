package SalesMessageProcessor;
/**
 * @author Sourav
 *
 * Class Name: SalesMessageProcessor
 * Contains the main program to run the application.
 * Requires a test data file containing sales message details.
 * And a sale object is initiated and called to process each
 * request. A report is made optional and is included in
 * this assessment to report the product logs to system console.
 *
 */

// include the package
// Required inbuilt packages
import java.io.BufferedReader;
import java.io.FileReader;

import SalesMessageProcessor.SalesProccessor;


public class SalesMessageProcessor {

	public static void main(String[] args) {
		// Initiate the sale object
		SalesProccessor sale = new SalesProccessor();

		// Read inputs from test file
		try {
			String line;
			BufferedReader inputFile = new BufferedReader(new FileReader("testInput/testdata.txt"));
			while((line = inputFile.readLine()) != null) {
				// process message for each sale notification
				sale.processNotification(line);

				
				//  report only generates after every 10th iteration and stops on 50th iteration 
				
				sale.log.report();
			}
			inputFile.close();

		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

}