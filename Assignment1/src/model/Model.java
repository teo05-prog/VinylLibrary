package model;

import java.util.List;

public interface Model
{
  void addListener(ModelListener listener);
  void removeListener(ModelListener listener);

  void addVinyl(String title, String artist, String year);
  void removeVinyl(Vinyl vinyl);
  List<Vinyl> getVinylList();

  void reserve(Vinyl vinyl, String userName) throws IllegalStateException;
  void borrow(Vinyl vinyl, String userName) throws IllegalStateException;
  void returnVinyl(Vinyl vinyl) throws IllegalStateException;

  Vinyl getVinylByIndex(int index);
}
