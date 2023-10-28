package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;


public class menuController_view {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    FXMLLoader loader =new FXMLLoader();

    public void switchToScene2(ActionEvent event) throws IOException {
        root = loader.load(getClass().getResource("table-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
