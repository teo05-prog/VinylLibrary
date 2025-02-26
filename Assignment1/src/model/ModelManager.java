package model;

import java.util.ArrayList;
import java.util.List;

public class ModelManager implements Model
{
  private List<Vinyl> vinylList;
  private List<ModelListener> listeners;

  public ModelManager()
  {
    this.vinylList = new ArrayList<>();
    this.listeners = new ArrayList<>();
  }

  @Override public void addListener(ModelListener listener)
  {
    listeners.add(listener);
  }

  @Override public void removeListener(ModelListener listener)
  {
    listeners.remove(listener);
  }

  private void notifyListenersVinylAdded(Vinyl vinyl)
  {
    for (ModelListener listener : listeners)
    {
      listener.vinylAdded(vinyl);
    }
  }

  private void notifyListenersVinylRemoved(Vinyl vinyl)
  {
    for (ModelListener listener : listeners)
    {
      listener.vinylRemoved(vinyl);
    }
  }

  private void notifyListenersVinylUpdated(Vinyl vinyl)
  {
    for (ModelListener listener : listeners)
    {
      listener.vinylUpdated(vinyl);
    }
  }

  private void notifyListenersVinylMarkedForRemoval(Vinyl vinyl)
  {
    for (ModelListener listener : listeners)
    {
      listener.vinylMarkedForRemoval(vinyl);
    }
  }

  @Override public void addVinyl(String title, String artist, String year)
  {
    Vinyl vinyl = new Vinyl(title, artist, year);
    synchronized (vinylList)
    {
      vinylList.add(vinyl);
    }
    notifyListenersVinylAdded(vinyl);
  }

  @Override public void removeVinyl(Vinyl vinyl)
  {
    synchronized (vinylList)
    {
      if (vinyl.getState() instanceof Available)
      {
        vinylList.remove(vinyl);
        notifyListenersVinylRemoved(vinyl);
      }
      else
      {
        vinyl.markForRemoval();
        notifyListenersVinylMarkedForRemoval(vinyl);
      }
    }
  }

  @Override public List<Vinyl> getVinylList()
  {
    synchronized (vinylList)
    {
      return new ArrayList<>(vinylList);
    }
  }

  @Override public void reserve(Vinyl vinyl, String userName)
      throws IllegalStateException
  {
    synchronized (vinyl)
    {
      vinyl.reserveVinyl();
      notifyListenersVinylUpdated(vinyl);
    }
  }

  @Override public void borrow(Vinyl vinyl, String userName)
      throws IllegalStateException
  {
    synchronized (vinyl)
    {
      vinyl.borrowVinyl();
      notifyListenersVinylUpdated(vinyl);
    }
  }

  @Override public void returnVinyl(Vinyl vinyl) throws IllegalStateException
  {
    synchronized (vinyl)
    {
      vinyl.returnVinyl();

      if (vinyl.isMarkedForRemoval() && (vinyl.getState() instanceof Available))
      {
        vinylList.remove(vinyl);
        notifyListenersVinylRemoved(vinyl);
      }
      else
      {
        notifyListenersVinylUpdated(vinyl);
      }
    }
  }

  @Override public Vinyl getVinylByIndex(int index)
  {
    synchronized (vinylList)
    {
      if (index >= 0 && index < vinylList.size())
      {
        return vinylList.get(index);
      }
      return null;
    }
  }
}
