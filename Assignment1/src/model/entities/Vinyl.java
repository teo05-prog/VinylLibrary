package model.entities;

public class Vinyl
{
  private String title;
  private String artist;
  private int year;
  private String state;

  public Vinyl(String title, String artist, int year, String state)
  {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.state = state;
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public int getYear()
  {
    return year;
  }

  public String getState()
  {
    return state;
  }

  public void setState(String state)
  {
    this.state = state;
  }
}
