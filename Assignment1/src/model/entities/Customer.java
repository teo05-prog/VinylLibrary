package model.entities;

public class Customer
{
  private int customerID;
  private String name;

  public Customer(int id, String name)
  {
    customerID = id;
    this.name = name;
  }

  public int getCustomerID()
  {
    return customerID;
  }

  public String getName()
  {
    return name;
  }
}
