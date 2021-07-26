package movies;

public class Movie implements Comparable<Movie>
{
	private String title;
	private int year;
	public Movie(String title, int year)
	{
		this.title = title;
		this.year = year;
	}
	// gets the title of the movie.
	public String getTitle() {
		return title;
	}
	// gets the year that movie was released on.
	public int getYear() {
		return year;
	}
	//compares the title first then year.
	public int compareTo(Movie that)
	{
		int compareTitle = this.title.compareTo(that.title); //comparing titles
		if (compareTitle != 0)
		{
			return compareTitle;
		}
		return this.year - that.year;
	}
	// used reference from github.com
	public boolean equals(Object x)
	{
		Movie that = (Movie)x;
		return this.compareTo(that) == 0;
	}
	public String toString()
	{
		return "Movie " + title + " (" + year + ")";
	}
	//returns an array of 10 movies
	public static Movie[] getTestMovies()
	{
		Movie[] movies = new Movie[10];
		movies[0] = new Movie("Endgame", 2019);
		movies[1] = new Movie("Endgame", 2021);
		movies[2] = new Movie("Water", 2018);
		movies[3] = new Movie("Avengers", 2018);
		movies[4] = new Movie("Thor", 2014);
		movies[5] = new Movie("Thor", 2014);
		movies[6] = new Movie("Black Widow", 2021);
		movies[7] = new Movie("Hulk", 2010);
		movies[8] = new Movie("Iron Man", 2015);
		movies[9] = new Movie("Captain America", 2018);
		return movies;
	}
	public int hashCode()
	{
		return title.hashCode() + year;
	}
}
