package model;

public class Reserved extends State
{

  @Override public String getStateName()
  {
    return "Reserved";
  }

  @Override public void toBorrow(Vinyl vinyl)
  {
    vinyl.setState(new Borrowed());
  }

  @Override public String status()
  {
    return "reserved";
  }
}
