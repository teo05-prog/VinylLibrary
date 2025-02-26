package model.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
  private ArrayList<Customer> customers;

  public CustomerList()
  {
    customers = new ArrayList<Customer>();
  }

  public Customer get(int index)
  {
    if (index < customers.size())
    {
      return customers.get(index);
    }
    else
    {
      return null;
    }
  }

  public int size()
  {
    return customers.size();
  }

  public void add(Customer customer)
  {
    customers.add(customer);
  }

  public void remove(Customer customer)
  {
    customers.remove(customer);
  }

  public String toString()
  {
    String result = "";
    for (Customer customer : customers)
    {
      result += customer + "\n";
    }
    return result;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    CustomerList other = (CustomerList) obj;
    return customers.equals(other.customers);
  }
}
