package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField idField;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField showPassField;

    @FXML
    private CheckBox showPass;

    @FXML
    private Button signIn;

    @FXML
    private Button signUp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void updateTextField(TextField textField){

    }

}
