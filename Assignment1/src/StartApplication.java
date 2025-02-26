import javafx.application.Application;
import javafx.stage.Stage;
import model.Vinyl;
import model.VinylList;
import view.ViewHandler;
import viewmodel.FrontVM;

import java.io.IOException;

public class StartApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override public void start(Stage primaryStage) throws IOException
  {
    VinylList vinylList = createSampleVinylList();
    FrontVM frontVM = new FrontVM(vinylList);
    ViewHandler viewHandler = new ViewHandler(primaryStage, vinylList, frontVM);
    viewHandler.start();
  }

  private VinylList createSampleVinylList()
  {
    VinylList vinylList = new VinylList();

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
      vinylList.addVinyl(newVinyl);
    }

    return vinylList;
  }
}