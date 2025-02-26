package model.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class VinylList implements Serializable
{
  private ArrayList<Vinyl> vinyls;

  public VinylList()
  {
    vinyls = new ArrayList<Vinyl>();
  }

  public Vinyl get(int index)
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

  public int size()
  {
    return vinyls.size();
  }

  public void add(Vinyl vinyl)
  {
    vinyls.add(vinyl);
  }

  public void remove(Vinyl vinyl)
  {
    vinyls.remove(vinyl);
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
}
