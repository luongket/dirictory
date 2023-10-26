package Cotroller;

import Base.TransLateApi;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TranslateController {
    String languageFrom = "en";
    String languageTo = "vi";
    @FXML
    private TextArea area1;
    @FXML
    private TextArea area2;
    private  TransLateApi translateApi=new TransLateApi();
    @FXML
    void translate() throws IOException {
        if (!Objects.equals(area1.getText(), "")) {

            area2.setText(translateApi.translate(languageFrom, languageTo, area1.getText()));
        }
    }
}
