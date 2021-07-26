package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqRecord.
//


public class FastqReader 
{
	
	// instance variable
	private BufferedReader theBufferedReader;
	
	// Constructor that initializes the instance variable.
	//
	// @param br to initialize the instance variable br.
	public FastqReader(BufferedReader br)
	{
		theBufferedReader = br;
	}
	
	// Used the lines in the pdf for javadoc.
	
	// This	method should read a line from the buffered	reader. If that	line is	null, the input	file is	
	// at the end, and the method should return	null. Otherwise the method should read 3	more	
	// lines and return	a FastqRecord.
	//
	// @return fastq the next record in the file.
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		String defline = theBufferedReader.readLine();
		if (defline == null)
		{
			return null;
		}
		
		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.
		String sequence = theBufferedReader.readLine();
		theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();
		FastqRecord rec = new FastqRecord(defline, sequence, quality);
		return rec;
	}
}
