package model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Vinyl implements Serializable
{
  private String title;
  private String artist;
  private String year;
  private State vinylState;
  private String state = "Available";
  private boolean isRemoved;
  private PropertyChangeSupport propertyChangeSupport;
  private String reserveName;
  private String borrowName;

  public Vinyl(String title, String artist, String year)
  {
    propertyChangeSupport = new PropertyChangeSupport(this);
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.isRemoved = false;
    setState(new Available());
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public String getYear()
  {
    return year;
  }

  public String getState()
  {
    return state;
  }

  public String getReserveName()
  {
    return reserveName;
  }

  public String getBorrowName()
  {
    return borrowName;
  }

  public void setReserveName(String reserveName)
  {
    this.reserveName = reserveName;
  }

  public void setBorrowName(String borrowName)
  {
    this.borrowName = borrowName;
  }

  public State getVinylState()
  {
    return vinylState;
  }

  public void setState(State vinylState)
  {
    if (!isRemoved)
    {
      String oldState = String.valueOf(this.state);
      this.vinylState = vinylState;
      this.state = vinylState.getStateName();
      propertyChangeSupport.firePropertyChange("state", oldState, this.state);
    }
    else
    {
      System.out.println("Cannot change state: vinyl is removed");
    }
  }

  public synchronized void borrowVinyl()
  {
    vinylState.toBorrow(this);
  }

  public synchronized void reserveVinyl()
  {
    String oldState = vinylState.getStateName();
    vinylState.toReserve(this);
  }

  public synchronized void returnVinyl()
  {
    String oldState = vinylState.getStateName();
    vinylState.toReturn(this);
  }

  public synchronized void removeVinyl()
  {
    String oldState = vinylState.getStateName();
    vinylState.toRemove(this);
  }

  @Override public String toString()
  {
    return title + ", " + artist + ", " + year + ", " + vinylState.status();
  }
}
