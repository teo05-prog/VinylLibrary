package viewmodel;

import javafx.collections.FXCollections;
import model.Vinyl;
import model.VinylList;

import java.util.List;

public class FrontVM
{
  private VinylList vinylList;
  private List<Vinyl> vinyls;

  public FrontVM(VinylList vinylList)
  {
    this.vinylList = vinylList;
  }

  public List<Vinyl> getVinyls()
  {
    List<Vinyl> result = vinylList.getVinyls();
    System.out.println("FrontVM.getVinyls() returning " + result.size() + " vinyls");
    return result;
  }
}