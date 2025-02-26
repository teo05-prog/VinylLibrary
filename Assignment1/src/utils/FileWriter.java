package utils;

import model.entities.Customer;
import model.entities.Vinyl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter
{
  public static void main(String[] args)
  {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("customers.bin")))
    {
      Customer[] customers = new Customer[2];

      customers[0] = new Customer(0, "Bob");
      customers[1] = new Customer(1, "Wendy");
    }
    catch (FileNotFoundException e)
    {
      throw new RuntimeException(e);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }

    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("vinyls.bin")))
    {
      Vinyl[] vinyls = new Vinyl[10];

      vinyls[0] = new Vinyl("Thriller", "Michael Jackson", 1982, "available");
      vinyls[1] = new Vinyl("Abbey - Road", "Beatles", 1969, "available");
      vinyls[2] = new Vinyl("Greatest Hits - 2", "Queen", 1981, "available");
      vinyls[3] = new Vinyl("Purple Rain", "Price", 1984, "available");
      vinyls[4] = new Vinyl("Master of Puppets", "Metallica", 1986, "available");
      vinyls[5] = new Vinyl("Curtain Call: The Hits", "Eminem", 2005, "available");
      vinyls[6] = new Vinyl("Back in Black", "AC/DC", 2003, "available");
      vinyls[7] = new Vinyl("Hotel California", "Eagles", 1976, "available");
      vinyls[8] = new Vinyl("Led Zeppelin IV", "Led Zeppelin", 1971, "available");
      vinyls[9] = new Vinyl("The Wall", "Pink Floyd", 1979, "available");
    }
    catch (FileNotFoundException e)
    {
      throw new RuntimeException(e);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
