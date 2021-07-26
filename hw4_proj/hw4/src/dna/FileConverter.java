package dna;

import java.io.*;
import java.util.*;


public class FileConverter 
{
	//instance variables
	private File fastq;
	private File fasta;
	
	//constructor that has 2 file arguments and initializes the instance variables.
	//
	// @param fastq to initialize the instance variable fastq.
	// @param fasta to initialize the instance variable fasta.
	public FileConverter(File fastq, File fasta)
	{
		this.fastq = fastq;
		this.fasta = fasta;
	}
	//
	// Writes a fasta file that converts all records from the fastq with
	// sufficient quality and unique defline.
	//
	public void convert() throws IOException
	{
		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		// Read, translate, write.
		// referred from the lecture.
		boolean done = false;
		while(!done)
		{
			try {

				FastqRecord fastQ = fqr.readRecord();
				if (fastQ == null)
				{
					break;
				}
				System.out.println(fastQ.getDefline());
				if (!fastQ.qualityIsLow())
				{
					FastaRecord fastA = new FastaRecord(fastQ);
					faw.writeRecord(fastA);
				}
			} 
			catch (RecordFormatException a)
			{
				System.out.println(a.getMessage());
			}
		}
		// Close fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}
	
		
	
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
