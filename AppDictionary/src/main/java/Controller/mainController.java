package Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    private ToggleButton dictionary;

    @FXML
    private ToggleButton game;

    @FXML
    private ToggleButton home;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private ImageView menu;

    @FXML
    private Label name;

    @FXML
    private ToggleButton note;

    @FXML
    private Button signOut;

    @FXML
    private AnchorPane sliderNav;

    private boolean flip = false;

    private void setMainContent(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            AnchorPane component = (AnchorPane) loader.load();
            mainContent.getChildren().clear();
            mainContent.getChildren().add(component);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gameController.combinedTransition != null) {
            gameController.combinedTransition.stop();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHome();

        menu.setOnMouseClicked(event -> {
            flip = !flip;
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5), sliderNav);
            if (!flip) {
                anim.setToX(0);
                anim.play();
            } else {
                anim.setToX(224);
                anim.play();
            }
        });
        mainContent.setOnMouseClicked(event -> {
            flip = false;
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5), sliderNav);
            anim.setToX(0);
            anim.play();
        });

        game.setOnMouseClicked(event -> {
            showGameView();
        });

        dictionary.setOnMouseClicked(event -> {
            showDictionary();
        });
        home.setOnMouseClicked(event -> {
            showHome();
        });
        note.setOnMouseClicked(event -> {
            showNoteView();
        });
        signOut.setOnMouseClicked(event -> {
            logOut();
        });
    }


    @FXML
    private void showGameView() {
        setMainContent("/View/Game.fxml");
        clearButton();
        game.setSelected(true);
    }

    @FXML
    private void showDictionary() {
        setMainContent("/View/Dictionary.fxml");
        clearButton();
        dictionary.setSelected(true);
    }

    @FXML
    private void showHome() {
        setMainContent("/View/translateView.fxml");
        clearButton();
        home.setSelected(true);
    }

    @FXML
    private void showNoteView() {
        setMainContent("/View/Note.fxml");
        clearButton();
        note.setSelected(true);
    }

    private void clearButton(){
        home.setSelected(false);
        dictionary.setSelected(false);
        game.setSelected(false);
        note.setSelected(false);
    }

    private void logOut() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/LoginView.fxml")));
            Stage stage = (Stage) signOut.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void change(String s){
        name.setText(s);
    }
}
