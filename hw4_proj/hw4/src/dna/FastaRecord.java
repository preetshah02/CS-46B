package dna;


public class FastaRecord implements DNARecord 
{	
	
	//instance variables
	private String defline;
	private String sequence;
	
	//
	// Constructor of class FastaRecord. checks to make	sure the defline starts	with	
	// the	correct	character or else throws an exception. Also initializes the instance variables.
	//
	// @param defline to initialize defline.
	// @param sequence to initialize sequence.
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if (defline.charAt(0) == '>')
		{
			this.defline = defline;
		}
		else
		{
			throw new RecordFormatException ("Bad 1st char in defline in fasta record");
		}
		this.sequence = sequence;
	}
	
	
	// Another constructor that initializes the instance variables with values from the FastqRecord. Also
	// we will change the first character of the defline.
	//
	// @param fastqRec to initialize the instance variables with values from the FastqRecord.
	public FastaRecord(FastqRecord fastqRec)
	{
		this.defline = fastqRec.getDefline().replace(fastqRec.getDefline().substring(0, 1), ">");
		this.sequence = fastqRec.getSequence();
	}

	// 
	// These 2 methods satisfies the interface.
	//
	public String getDefline()
	{
		return defline;
	}
	
	public String getSequence()
	{
		return sequence;
	}
	
	
	//
	// This equals() method checks for deep equality of all 2 instance variables and also uses casting.
	// 
	// @param Ob to use for casting.
	// @return true or false 
	//
	public boolean equals(Object ob)
	{
		FastaRecord that = (FastaRecord)ob;
		if(this.defline.equals(that.defline) && this.sequence.equals(that.sequence))
		{
			return true;
		}
		return false;
	}

	//
	//  Returns the sum of the hash codes of defline and sequence.
	//
	// @return defline.hashCode() + sequence.hashCode()
	//
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode();
	}
}
