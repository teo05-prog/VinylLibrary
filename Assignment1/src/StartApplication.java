import model.Vinyl;

import java.util.ArrayList;

public class StartApplication
{
  public static void main(String[] args)
  {
    ArrayList<Vinyl> vinyls = new ArrayList<Vinyl>();

    String[] titles = new String[] {"Thriller", "Abbey - Road",
        "Greatest Hits - 2", "Purple Rain", "Master of Puppets",
        "Curtain Call: The Hits", "Back in Black", "Hotel California",
        "Led Zeppelin IV", "The Wall"};
    String[] artists = new String[] {"Michael Jackson", "Beatles", "Queen",
        "Prince", "Metallica", "Eminem", "AC/DC", "Eagles", "Led Zeppelin",
        "Pink Floyd"};
    String[] years = new String[] {"1982", "1969", "1981", "1984", "1986",
        "2005", "2003", "1976", "1971", "1979"};

    for (int i = 0; i < 10; i++)
    {
      Vinyl newVinyl = new Vinyl(titles[i], artists[i], years[i]);
      System.out.println(newVinyl);
      vinyls.add(newVinyl);
    }
  }
}
