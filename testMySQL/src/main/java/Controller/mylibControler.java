package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class mylibControler implements Initializable {

    @FXML
    private TableColumn<?, ?> editCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> meaningCol;

    @FXML
    private TableColumn<?, ?> noteCol;

    @FXML
    private TableView<?> tableWord;

    @FXML
    private TableColumn<?, ?> wordCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
