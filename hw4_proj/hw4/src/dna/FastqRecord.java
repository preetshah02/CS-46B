package dna;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord 
{
	
	//instance variables
	private String defline;
	private String sequence;
	private String quality;
	
	//
	// Constructor of FastqRecord. Throws "RecordFormatException" if the 1st char of the defline is 
	// not '@' and gives a message to the user. Also initializes instance variables.
	//
	// @param defline to initialize the instance variable defline.
	// @param sequence to initialize the instance variable sequence.
	// @param quality to initialize the instance variable quality.
	//
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		if(defline.charAt(0) == '@')
		{
			this.defline = defline;
		}
		else
		{
			throw new RecordFormatException("Bad 1st char in defline in fastq record");
		}
		this.sequence = sequence;
		this.quality = quality;
	}
	
	
	// 
	// These two method satisfies the interface
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
	// This equals() method checks for deep equality of all 3 instance variables and also uses casting.
	// 
	// @param Ob to use for casting.
	// @return true or false
	public boolean equals(Object ob)
	{
		FastqRecord that = (FastqRecord)ob;
		if(this.defline.equals(that.defline) && this.sequence.equals(that.sequence) && this.quality.equals(that.quality))
		{
			return true;
		}
		return false;
	}
	
	//
	// method that returns true if the quality contains at least a "$" and a "#"
	//
	// @return true or false
	public boolean qualityIsLow()
	{
		if(quality.contains("$") && quality.contains("#"))
		{
			return true;
		}
		return false;
	}
	
	
	//
	// Returns the sum of the hash codes of Defline, sequence, and quality.
	//
	// @return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
