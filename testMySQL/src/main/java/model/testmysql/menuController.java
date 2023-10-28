package model.testmysql;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class menuController {
    @FXML
    private Circle myCircle;
    private double x;
    private double y;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    FXMLLoader loader =new FXMLLoader();
    public void Up(ActionEvent e) {
        myCircle.setCenterY(y-=10);
    }
    public void Down(ActionEvent e) {
        myCircle.setCenterY(y+=10);
    }
    public void Left(ActionEvent e) {
        myCircle.setCenterX(x-=10);
    }
    public void Right(ActionEvent e) {
        myCircle.setCenterX(x+=10);
    }
    public void switchToScene1(ActionEvent event) throws IOException {
        root = loader.load(getClass().getResource("menu-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        root = loader.load(getClass().getResource("libraly.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
