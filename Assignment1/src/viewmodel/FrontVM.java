package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import model.Model;
import model.ModelListener;
import model.Vinyl;

public class FrontVM implements ModelListener
{
  private Model model;
  private ViewState viewState;
  private List<Vinyl> vinylList;
  private StringProperty errorLabel;
  private PropertyChangeSupport support;

  public static final String VINYL_LIST_PROPERTY = "vinylList";

  public FrontVM(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    this.vinylList = new ArrayList<>();
    this.errorLabel = new SimpleStringProperty("");
    this.support = new PropertyChangeSupport(this);

    refreshVinylList();

    model.addListener(this);
  }

  private void refreshVinylList()
  {
    List<Vinyl> oldList = new ArrayList<>(vinylList);
    vinylList.clear();
    vinylList.addAll(model.getVinylList());
    support.firePropertyChange(VINYL_LIST_PROPERTY, oldList, vinylList);
  }

  @Override public void vinylAdded(Vinyl vinyl)
  {
    Platform.runLater(this::refreshVinylList);
  }

  @Override public void vinylRemoved(Vinyl vinyl)
  {
    Platform.runLater(this::refreshVinylList);
  }

  @Override public void vinylUpdated(Vinyl vinyl)
  {
    Platform.runLater(this::refreshVinylList);
  }

  @Override public void vinylMarkedForRemoval(Vinyl vinyl)
  {
    Platform.runLater(this::refreshVinylList);
  }

  public void addPropertyChangeListener(String propertyName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(propertyName, listener);
  }

  public void removePropertyChangeListener(String propertyName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(propertyName, listener);
  }

  public List<Vinyl> getVinylList()
  {
    return new ArrayList<>(vinylList);
  }

  public StringProperty errorLabelProperty()
  {
    return errorLabel;
  }

  public void reserveVinyl(Vinyl vinyl, String userName)
  {
    try
    {
      model.reserve(vinyl, userName);
      errorLabel.set("");
    }
    catch (IllegalStateException e)
    {
      errorLabel.set("Error: " + e.getMessage());
    }
  }

  public void borrowVinyl(Vinyl vinyl, String userName)
  {
    try
    {
      model.borrow(vinyl, userName);
      errorLabel.set("");
    }
    catch (IllegalStateException e)
    {
      errorLabel.set("Error: " + e.getMessage());
    }
  }

  public void returnVinyl(Vinyl vinyl)
  {
    try
    {
      model.returnVinyl(vinyl);
      errorLabel.set("");
    }
    catch (IllegalStateException e)
    {
      errorLabel.set("Error: " + e.getMessage());
    }
  }

  public void setSelectedVinyl(Vinyl vinyl)
  {
    viewState.setSelectedVinyl(vinyl);
  }

  public Vinyl getSelectedVinyl()
  {
    return viewState.getSelectedVinyl();
  }
}