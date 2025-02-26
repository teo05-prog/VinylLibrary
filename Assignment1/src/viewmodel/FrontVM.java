package viewmodel;

import javafx.collections.FXCollections;
import model.Vinyl;
import model.VinylList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class FrontVM implements PropertyChangeListener
{
  private VinylList model;
  private List<Vinyl> vinylList;
  private PropertyChangeSupport support;
  private ViewState viewState;

  public FrontVM(VinylList model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    this.support = new PropertyChangeSupport(this);

    vinylList = new ArrayList<>();
    updateVinylList();

    model.addListener(this);
  }

  private void updateVinylList()
  {
    vinylList.clear();
    for (int i = 0; i < model.size(); i++)
    {
      vinylList.add(model.get(i));
    }
    support.firePropertyChange("vinylList", null, vinylList);
  }

  public List<Vinyl> getVinylList()
  {
    return new ArrayList<>(vinylList);
  }

  public void setSelectedVinyl(Vinyl vinyl)
  {
    viewState.setSelectedVinyl(vinyl);
    support.firePropertyChange("selectedVinyl", null, vinyl);
  }

  public void addVinyl(Vinyl vinyl)
  {
    model.add(vinyl);
  }

  public void removeVinyl(Vinyl vinyl)
  {
    model.markForRemoval(vinyl);
  }

  public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    updateVinylList();
  }
}
