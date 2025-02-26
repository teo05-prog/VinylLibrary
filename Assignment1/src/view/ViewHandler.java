package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.front.FrontController;
import view.manage.ManageController;

import java.io.IOException;

public class ViewHandler
{
  private Stage primaryStage;
  private FrontController frontController;
  private ManageController manageController;

  public ViewHandler(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  public void start()
  {
    loadFrontView();
    loadManageView();
    openFrontView();
  }

  private void loadFrontView() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/front/FrontView.fxml"));
      Scene scene = new Scene(loader.load());
      frontController = loader.getController();
      frontController.init(this, scene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadManageView() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manage/ManageView.fxml"));
      Scene scene = new Scene(loader.load());
      manageController = loader.getController();
      manageController.init(this, scene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void openFrontView() {
    primaryStage.setTitle("Vinyl Store - Front View");
    primaryStage.setScene(frontController.getScene());
    primaryStage.show();
  }

  public void openManageView() {
    primaryStage.setTitle("Vinyl Store - Management View");
    primaryStage.setScene(manageController.getScene());
    primaryStage.show();
  }
}
