package movies;

import java.util.ArrayList;
import java.util.HashSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive{
	//sorts the Array List and returns the sorted Array list.
	public ArrayList<Movie> getSorted()
	{
		HashSet<Movie> hashSet = new HashSet<Movie>(this);
		ArrayList<Movie> newArrayList = new ArrayList<Movie>(hashSet);
		return newArrayList;
	}
	
}
