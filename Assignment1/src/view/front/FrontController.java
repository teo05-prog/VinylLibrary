package view.front;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Vinyl;
import view.ViewHandler;

public class FrontController
{
  private Scene scene;
  private ViewHandler viewHandler;

  @FXML private TableView<Vinyl> vinylTable;
  @FXML private TableColumn<Vinyl, String> titleColumn;
  @FXML private TableColumn<Vinyl, String> artistColumn;
  @FXML private TableColumn<Vinyl, String> yearColumn;
  @FXML private TableColumn<Vinyl, String> statusColumn;

  @FXML private Button manageButton;

  private TableView.TableViewSelectionModel<Vinyl> defaultSelectionModel;

  @FXML private void initialize()
  {
    setupTableColumns();
    defaultSelectionModel = vinylTable.getSelectionModel();
  }

  private void setupTableColumns()
  {
    titleColumn.setCellValueFactory(
        new PropertyValueFactory<>("title"));
    artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
    yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
  }

  public Scene getScene()
  {
    return scene;
  }

  public void init(ViewHandler viewHandler, Scene scene) {
    this.viewHandler = viewHandler;
    this.scene = scene;
  }

  @FXML
  private void onManageButtonClick() {
    viewHandler.openManageView();
  }
}
