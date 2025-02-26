package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;

public class VinylList implements Serializable
{
  private ArrayList<Vinyl> vinyls;
  private PropertyChangeSupport support;

  public VinylList()
  {
    vinyls = new ArrayList<Vinyl>();
    support = new PropertyChangeSupport(this);
  }

  public synchronized Vinyl get(int index)
  {
    if (index < vinyls.size())
    {
      return vinyls.get(index);
    }
    else
    {
      return null;
    }
  }

  public ArrayList<Vinyl> getVinyls()
  {
    return vinyls;
  }

  public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  public int size()
  {
    return vinyls.size();
  }

  public synchronized void add(Vinyl vinyl)
  {
    vinyls.add(vinyl);
    support.firePropertyChange("vinylAdded", null, vinyl);
  }

  public synchronized void remove(Vinyl vinyl)
  {
    boolean removed = vinyls.remove(vinyl);
    if (removed)
    {
      support.firePropertyChange("vinylRemoved", vinyl, null);
    }
  }

  public synchronized void borrow(Vinyl vinyl, Customer customer)
  {
    if (vinyl != null)
    {
      vinyl.setBorrowName(customer.getName());
      vinyl.borrowVinyl();
      support.firePropertyChange("vinylBorrowed", null, vinyl);
    }
  }

  public synchronized void reserve(Vinyl vinyl, Customer customer)
  {
    if (vinyl != null)
    {
      vinyl.setReserveName(customer.getName());
      vinyl.reserveVinyl();
      support.firePropertyChange("vinylReserved", null, vinyl);
    }
  }

  public synchronized void returnVinyl(Vinyl vinyl)
  {
    if (vinyl != null)
    {
      vinyl.returnVinyl();
      support.firePropertyChange("vinylReturned", null, vinyl);
    }
  }

  public synchronized void markForRemoval(Vinyl vinyl)
  {
    if (vinyl != null)
    {
      vinyl.removeVinyl();
      support.firePropertyChange("vinylMarkedForRemoval", null, vinyl);
    }
  }

  public String toString()
  {
    String result = "";
    for (Vinyl vinyl : vinyls)
    {
      result += vinyl + "\n";
    }
    return result;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    VinylList other = (VinylList) obj;
    return vinyls.equals(other.vinyls);
  }

  public void addVinyl(Vinyl vinyl)
  {
    vinyls.add(vinyl);
  }
}
