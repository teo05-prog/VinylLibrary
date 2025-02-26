import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import model.Vinyl;
import model.VinylList;
import view.ViewHandler;
import viewmodel.FrontVM;
import viewmodel.ViewState;

import java.io.IOException;

public class StartApplication extends Application
{
  private Model model;
  private VinylList vinylList;
  private ViewState viewState;
  private UserSimulator userSimulator1;
  private UserSimulator userSimulator2;
  private FrontVM frontVM;

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override public void start(Stage primaryStage) throws IOException
  {
    model = new ModelManager();
    vinylList = new VinylList();
    viewState = new ViewState();

    initializeVinylCollection();

    frontVM = new FrontVM(model, viewState);
    userSimulator1 = new UserSimulator("Bob", model);
    userSimulator2 = new UserSimulator("Wendy", model);

    ViewHandler viewHandler = new ViewHandler(primaryStage, vinylList, frontVM);
    viewHandler.start();

    userSimulator1.start();
    userSimulator2.start();
  }

  @Override public void stop()
  {
    if (userSimulator1 != null)
    {
      userSimulator1.stop();
    }
    if (userSimulator2 != null)
    {
      userSimulator2.stop();
    }
  }

  private void initializeVinylCollection()
  {
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
      this.vinylList.addVinyl(newVinyl);
      model.addVinyl(titles[i], artists[i], years[i]);
    }
  }
}