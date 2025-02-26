package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Vinyl;
import view.front.FrontController;
import view.manage.ManageController;
import viewmodel.FrontVM;
import model.VinylList;

import java.io.IOException;

public class ViewHandler
{
  private Stage primaryStage;
  private FrontController frontController;
  private ManageController manageController;
  private VinylList vinylList;
  private FrontVM frontVM;

  public ViewHandler(Stage primaryStage, VinylList vinylList, FrontVM frontVM)
  {
    this.primaryStage = primaryStage;
    this.vinylList = vinylList;
    this.frontVM = frontVM;
  }

  public void start() throws IOException
  {
    loadFrontView();
    loadManageView();
    openFrontView();
  }

  private void loadFrontView() throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/front/Front.fxml"));
    Scene scene = new Scene(loader.load());
    frontController = loader.getController();
    frontController.init(this, frontVM, scene); // Pass scene to init
    primaryStage.setScene(scene);
  }

  private void loadManageView()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("/view/manage/Manage.fxml"));
      Scene scene = new Scene(loader.load());
      manageController = loader.getController();
      manageController.init(this, scene, frontVM);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openFrontView()
  {
    primaryStage.setTitle("Vinyl Library");
    primaryStage.setScene(frontController.getScene());
    frontController.updateVinylTable();
    primaryStage.show();
  }

  public void openManageView(Vinyl selectedVinyl)
  {
    manageController.setSelectedVinyl(selectedVinyl);
    primaryStage.setTitle("Vinyl Management");
    primaryStage.setScene(manageController.getScene());
    primaryStage.show();
  }
}