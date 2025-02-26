package utils;

import model.entities.CustomerList;
import model.entities.VinylList;

import java.io.*;

public class FileReader
{
  public static void main(String[] args)
  {
    try
    {
      FileInputStream customersFileIn = new FileInputStream("customers.bin");
      ObjectInputStream readCustomers = new ObjectInputStream(customersFileIn);
      try
      {
        CustomerList customerList = (CustomerList) readCustomers.readObject();
        for (int i = 0; i < customerList.size(); i++)
        {
          System.out.println(customerList.get(i));
        }
      }
      catch (EOFException eof)
      {
        System.out.println("End of file");
      }
      readCustomers.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
      e.printStackTrace();
      System.exit(1);
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
      e.printStackTrace();
      System.exit(1);
    }

    try
    {
      FileInputStream vinylFileIn = new FileInputStream("vinyl.bin");
      ObjectInputStream readVinyl = new ObjectInputStream(vinylFileIn);
      try
      {
        VinylList vinylList = (VinylList) readVinyl.readObject();
        for (int i = 0; i < vinylList.size(); i++)
        {
          System.out.println(vinylList.get(i));
        }
      }
      catch (EOFException eof)
      {
        System.out.println("End of file");
      }
      readVinyl.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found, or could not be opened");
      System.exit(1);
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
      e.printStackTrace();
      System.exit(1);
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
      e.printStackTrace();
      System.exit(1);
    }
  }
}
