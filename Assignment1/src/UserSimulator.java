import model.Model;
import model.Vinyl;

import java.util.List;
import java.util.Random;

public class UserSimulator implements Runnable
{
  private final String userName;
  private final Model model;
  private final Random random;
  private boolean running;
  private Thread thread;

  public UserSimulator(String userName, Model model)
  {
    this.userName = userName;
    this.model = model;
    this.random = new Random();
    this.running = false;
  }

  public void start()
  {
    if (thread == null || !thread.isAlive())
    {
      running = true;
      thread = new Thread(this);
      thread.setDaemon(true);
      thread.start();
    }
  }

  public void stop()
  {
    running = false;
    if (thread != null)
    {
      thread.interrupt();
    }
  }

  @Override public void run()
  {
    System.out.println(userName + " simulator started");

    while (running)
    {
      try
      {
        Thread.sleep(random.nextInt(3000) + 2000);

        if (running)
        {
          performRandomAction();
        }
      }
      catch (InterruptedException e)
      {
        System.out.println(userName + " simulator interrupted");
        running = false;
      }
    }

    System.out.println(userName + " simulator stopped");
  }

  private void performRandomAction()
  {
    List<Vinyl> vinyls = model.getVinylList();

    if (vinyls.isEmpty())
    {
      return;
    }

    int vinylIndex = random.nextInt(vinyls.size());
    Vinyl vinyl = vinyls.get(vinylIndex);

    if (vinyl.getState().getStateName().equals("Removed")) {
      System.out.println(userName + " cannot perform action on vinyl: " +
          vinyl.getTitle() + " - Vinyl is removed");
      return;
    }

    int action = random.nextInt(3);

    System.out.println(userName + " attempting action " + actionToString(action)
        + " on vinyl: " + vinyl.getTitle());

    try
    {
      switch (action)
      {
        case 0:
          model.reserve(vinyl, userName);
          System.out.println(userName + " reserved: " + vinyl.getTitle());
          break;

        case 1:
          model.borrow(vinyl, userName);
          System.out.println(userName + " borrowed: " + vinyl.getTitle());
          break;

        case 2:
          model.returnVinyl(vinyl);
          System.out.println(userName + " returned: " + vinyl.getTitle());
          break;
      }
    }
    catch (Exception e)
    {
      System.out.println(
          userName + " couldn't " + actionToString(action) + " vinyl: "
              + vinyl.getTitle() + " - " + e.getMessage());
    }
  }

  private String actionToString(int action)
  {
    switch (action)
    {
      case 0:
        return "reserve";
      case 1:
        return "borrow";
      case 2:
        return "return";
      default:
        return "unknown";
    }
  }
}
