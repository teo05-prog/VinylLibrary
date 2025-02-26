package view.manage;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;
import view.ViewHandler;
import viewmodel.FrontVM;

public class ManageController
{
  @FXML private Label titleLabel;
  @FXML private Label artistLabel;
  @FXML private Label yearLabel;
  @FXML private Label stateLabel;
  @FXML private Label errorLabel;

  @FXML private TextField titleField;
  @FXML private TextField artistField;
  @FXML private TextField yearField;
  @FXML private TextField stateField;

  @FXML private Button borrowButton;
  @FXML private Button reserveButton;
  @FXML private Button returnButton;
  @FXML private Button removeButton;
  @FXML private Button cancelButton;

  private ViewHandler viewHandler;
  private Scene scene;
  private Vinyl selectedVinyl;
  private FrontVM frontVM;

  public void init(ViewHandler viewHandler, Scene scene, FrontVM frontVM) {
    this.viewHandler = viewHandler;
    this.scene = scene;
    this.frontVM = frontVM;
  }

  public Scene getScene()
  {
    return scene;
  }

  public void setSelectedVinyl(Vinyl vinyl)
  {
    this.selectedVinyl = vinyl;
    updateUI();
  }

  private void updateUI()
  {
    if (selectedVinyl != null)
    {
      titleField.setText(selectedVinyl.getTitle());
      artistField.setText(selectedVinyl.getArtist());
      yearField.setText(String.valueOf(selectedVinyl.getYear()));
      stateField.setText(selectedVinyl.getState().toString());
    }
  }

  @FXML private void onReturnToFrontViewClick()
  {
    viewHandler.openFrontView();
  }

  @FXML private void onBorrowButtonClick()
  {
    if (selectedVinyl != null)
    {
      selectedVinyl.borrowVinyl();
      updateUI();
    }
  }

  @FXML private void onReserveButtonClick()
  {
    if (selectedVinyl != null)
    {
      selectedVinyl.reserveVinyl();
      updateUI();
    }
  }

  @FXML private void onReturnButtonClick()
  {
    if (selectedVinyl != null)
    {
      selectedVinyl.returnVinyl();
      updateUI();
    }
  }

  @FXML private void onRemoveButtonClick()
  {
    if (selectedVinyl != null)
    {
      selectedVinyl.removeVinyl();
      updateUI();
    }
  }
}