package model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Vinyl implements Serializable
{
  private String title;
  private String artist;
  private String year;
  private State state;
  private boolean markedForRemoval;
  private String reserveName;
  private String borrowName;

  public Vinyl(String title, String artist, String year)
  {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.state = new Available();
    this.markedForRemoval = false;
    setState(new Available());
    this.reserveName = null;
    this.borrowName = null;
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

  public State getState()
  {
    return state;
  }

  public boolean isMarkedForRemoval()
  {
    return markedForRemoval;
  }

  public void markForRemoval()
  {
    this.markedForRemoval = true;
  }

  public String getReserveName()
  {
    return reserveName;
  }

  public String getBorrowName()
  {
    return borrowName;
  }

  public void setReservedBy(String reservedBy) {
    this.reserveName = reservedBy;
  }

  public void setBorrowedBy(String borrowedBy) {
    this.borrowName = borrowedBy;
  }

  public void setState(State state)
  {
    if (!markedForRemoval)
    {
      this.state = state;
    }
    else
    {
      System.out.println("Cannot change state: vinyl is removed");
    }
  }

  public synchronized void borrowVinyl()
  {
    state.toBorrow(this);
  }

  public synchronized void reserveVinyl()
  {
    String oldState = state.getStateName();
    state.toReserve(this);
  }

  public synchronized void returnVinyl()
  {
    String oldState = state.getStateName();
    state.toReturn(this);
  }

  public synchronized void removeVinyl()
  {
    String oldState = state.getStateName();
    state.toRemove(this);
  }

  @Override public String toString()
  {
    return title + ", " + artist + ", " + year + ", " + state;
  }
}
