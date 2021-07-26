package dna;

import java.io.*;


//
// Writes a fasta record to a print writer.
//


public class FastaWriter 
{
	//instance variable
	private PrintWriter thePrintWriter;
	
	//Constructor that initializes the instance variable
	//
	// @param pr to initialize the instance variable
	public FastaWriter(PrintWriter pr)
	{
		thePrintWriter = pr;
	}
	
	// Write the rec as 2 separate lines: first the defline, then the sequence.
	// To write something on a separate line, use the println() method of PrintWriter.
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
}
