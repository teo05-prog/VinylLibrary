package model;

public class Reserved extends State
{
  private String reservedBy;

  public Reserved(String reservedBy)
  {
    this.reservedBy = reservedBy;
  }

  @Override public String getStateName()
  {
    return "Reserved by " + reservedBy;
  }

  @Override public void toBorrow(Vinyl vinyl)
  {
    vinyl.setState(new Borrowed());
  }

  @Override public String status()
  {
    return "reserved";
  }

  public String getReservedBy()
  {
    return reservedBy;
  }
}
