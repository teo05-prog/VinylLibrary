package view.manage;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import view.ViewHandler;

public class ManageController
{


  @FXML private Button borrowButton;
  @FXML private Button reserveButton;
  @FXML private Button returnButton;
  @FXML private Button removeButton;
  @FXML private Button cancelButton;

  private ViewHandler viewHandler;
  private Scene scene;

  public void init(ViewHandler viewHandler, Scene scene) {
    this.viewHandler = viewHandler;
    this.scene = scene;
  }

  public Scene getScene() {
    return scene;
  }

  @FXML
  private void onReturnToFrontViewClick() {
    viewHandler.openFrontView();
  }
}
