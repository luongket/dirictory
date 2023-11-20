import Base.App.Item;
import Base.App.Word;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {
    private ArrayList<Word> wordList = Item.getWordList();
    private ArrayList<Word> savedList = Item.getSavedList();
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("/View/LoginView.fxml"))));
        Scene scene = new Scene(root);
        stage.setTitle("Dirictory");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}