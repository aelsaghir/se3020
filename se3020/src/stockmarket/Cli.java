package stockmarket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Cli { // NOPMD by tom on 7/26/10 9:26 PM
	public static int Instrument = 0;
	public static int Date = 1;
	public static int Time = 2;
	public static int RecordType = 3;
	public static int Price = 4;
	public static int Volume = 5;
	public static int Value = 6;
	public static int TransID = 7;
	public static int BidID = 8;
	public static int AskID = 9;
	public static int Bid_Ask = 10;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Cli();

	}

	private Cli() {

		Scanner scanner;
		String inputFile = null;
		try {
			scanner = new Scanner(new File("SystemVars.txt"));

			HashMap<String, String> settings = new HashMap<String, String>();

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] split = line.split(",");
				settings.put(split[0], split[1]);

			}

			inputFile = settings.get("input_file");
			String inputFileDir = settings.get("input_file_dir");
			String outputFileDir = settings.get("output_file_dir");

			//System.out.println(inputFile + inputFileDir + outputFileDir);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// verfiy

		// make output
		
		// Get order of input csv file headers
			// allows for dynamic columns within the CSV file
		File file = new File(inputFile);
		BufferedReader bufRdr = null;
		try {
			bufRdr = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line = bufRdr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] order = getOrder(line);
	}

	static int[] getOrder(String line) {
		int[] order = new int[11];
		String[] words = line.split(",");
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("#Instrument")) order[Instrument] = i;
			else if	(words[i].equals("Date")) order[Date] = i;
			else if	(words[i].equals("Time")) order[Time] = i;
			else if	(words[i].equals("Record Type")) order[RecordType] = i;
			else if	(words[i].equals("Price")) order[Price] = i;
			else if	(words[i].equals("Volume")) order[Volume] = i;
			else if	(words[i].equals("Value")) order[Value] = i;
			else if	(words[i].equals("Trans ID")) order[TransID] = i;
			else if	(words[i].equals("Bid ID")) order[BidID] = i;
			else if	(words[i].equals("Ask ID")) order[AskID] = i;
			else if	(words[i].equals("Bid/Ask")) order[Bid_Ask] = i;
		}
		return order;
	}

}
