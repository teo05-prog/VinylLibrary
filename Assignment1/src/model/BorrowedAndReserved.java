package model;

public class BorrowedAndReserved extends State
{
  private String reservedBy;

  public BorrowedAndReserved(String reservedBy)
  {
    this.reservedBy = reservedBy;
  }

  @Override public String getStateName()
  {
    return "Borrowed and Reserved";
  }

  @Override public void toReturn(Vinyl vinyl)
  {
    vinyl.setState(new Reserved(reservedBy));
  }

  @Override public String status()
  {
    return "borrowed and reserved";
  }

  public String getReservedBy()
  {
    return reservedBy;
  }
}
