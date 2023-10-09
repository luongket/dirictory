package com.example.appdictionary;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    private ImageView dictionary;

    @FXML
    private ImageView home;

    @FXML
    private ImageView stadiaController;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private ImageView menu;

    @FXML
    private AnchorPane sliderNav;

    @FXML
    private BorderPane boder;

    @FXML
    private AnchorPane gameView;

    @FXML
    private AnchorPane dictionaryView;

    @FXML
    private AnchorPane HomeView;

    private boolean flip = true;

    private void setMainContent(AnchorPane anchorPane) {
        boder.setCenter(anchorPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("View/Game.fxml"));
            gameView = loader.load();
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("View/Dictionary.fxml"));

            dictionaryView = loader.load();
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

        menu.setOnMouseClicked(event -> {
            flip = !flip;
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5), sliderNav);
            if (!flip) {
                anim.setToX(-200);
                anim.play();
            } else {
                anim.setToX(0);
                anim.play();
            }
        });
        mainContent.setOnMouseClicked(event -> {
            flip = false;
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5), sliderNav);
            anim.setToX(-200);
            anim.play();
        });

        dictionaryView.setOnMouseClicked(event -> {
            flip = false;
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5), sliderNav);
            anim.setToX(-200);
            anim.play();
        });

        gameView.setOnMouseClicked(event -> {
            flip = false;
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5), sliderNav);
            anim.setToX(-200);
            anim.play();
        });

        stadiaController.setOnMouseClicked(event -> {
            showGameView();
        });

        dictionary.setOnMouseClicked(event -> {
            showDictionary();
        });
        home.setOnMouseClicked(event -> {
            showHome();
        });
    }

    @FXML
    public void showGameView() {
        setMainContent(gameView);
    }

    @FXML
    public void showDictionary() {
        setMainContent(dictionaryView);
    }

    @FXML
    public void showHome() {
        setMainContent(mainContent);
    }

}
