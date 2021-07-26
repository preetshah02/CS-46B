package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive
{
	// adds a movie to the Array List.
	public boolean add(Movie that)
	{
		for (Movie m: this)
		{
			if (m.getTitle().equals(that.getTitle()) && m.getYear() == that.getYear())
			{
				return false;
			}
		}
	
		boolean reallyAdded = super.add(that);
		return reallyAdded;
	}
	//sorts the Array List and returns the sorted Array list.
	public ArrayList<Movie> getSorted()
	{
		TreeSet<Movie> sortTree = new TreeSet<Movie>(this);
        ArrayList<Movie> sorted = new ArrayList<Movie> (sortTree);
        return sorted;
	}
	// main method
	public static void main(String[] args)
	{
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m: Movie.getTestMovies())
			archive.add(m);
		for (Movie m: archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m: archive.getSorted())
			System.out.println(m);
	 }
}
