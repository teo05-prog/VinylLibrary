package model;

import java.io.Serializable;

public class Customer implements Serializable
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
