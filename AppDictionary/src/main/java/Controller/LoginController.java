package Controller;

import database.DBConnection;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button cancel;
    @FXML
    private AnchorPane SliderPane;

    @FXML
    private TextField idField;

    @FXML
    private CheckBox checkPass;

    @FXML
    private CheckBox checkPassInfo;

    @FXML
    private TextField showRePassInfo;

    @FXML
    private TextField nameInfo;

    @FXML
    private PasswordField passInfo;

    @FXML
    private Button signUp;

    @FXML
    private TextField showPassInfo;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField rePassInfo;

    @FXML
    private TextField showPassField;

    @FXML
    private Button signIn;

    @FXML
    private TextField idInfo;

    @FXML
    private Button ok;

    @FXML
    private BorderPane info;
    private Connection connection = DBConnection.getConnection();
    Alert alert = new Alert(Alert.AlertType.ERROR);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPassField.setVisible(false);
        showPassInfo.setVisible(false);
        showRePassInfo.setVisible(false);

        checkPass.setOnMouseClicked(event -> {
            showPassword(passField, showPassField, checkPass);
        });

        checkPassInfo.setOnMouseClicked(event -> {
            showPassword(passInfo, showPassInfo, checkPassInfo);
            showPassword(rePassInfo, showRePassInfo, checkPassInfo);
        });

        signUp.setOnMouseClicked(event -> {
            clearData();
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5),info);
            anim.setToX(440);
            anim.play();
        });

        cancel.setOnMouseClicked(event -> {
            clearData();
            TranslateTransition anim = new TranslateTransition(Duration.seconds(0.5), info);
            anim.setToX(0);
            anim.play();

        });

        ok.setOnMouseClicked(event -> {
            create();
        });

        signIn.setOnMouseClicked(event -> {
            logIn();
        });

    }

    private void showPassword(PasswordField passField, TextField showPassField, CheckBox checkPass) {
        if (checkPass.isSelected()) {
            showPassField.setText(passField.getText());
            showPassField.textProperty().addListener((observable, oldValue, newValue) -> {
                passField.setText(showPassField.getText());
            });
            showPassField.setVisible(true);
            passField.setVisible(false);
        } else {
            passField.setText(showPassField.getText());
            passField.textProperty().addListener((observable, oldValue, newValue) -> {
                showPassField.setText(passField.getText());
            });
            showPassField.setVisible(false);
            passField.setVisible(true);
        }

    }

    private void create() {
        if (nameInfo.getText().isEmpty() || idInfo.getText().isEmpty()
                || passInfo.getText().isEmpty() || rePassInfo.getText().isEmpty()) {
            alert.setHeaderText(null);
            alert.setContentText("Nhập chưa đủ dữ liệu!");
            alert.showAndWait();
        } else if (!(passInfo.getText().equals(rePassInfo.getText()))) {
            alert.setHeaderText(null);
            System.out.println(passInfo.getText() + " " + rePassInfo.getText());
            System.out.println(showPassInfo.getText() + " " + showRePassInfo.getText());
            alert.setContentText("Mật khẩu không trùng khớp!");
            alert.showAndWait();
        } else if (passInfo.getText().equals(rePassInfo.getText())) {
            String query1 = "SELECT * FROM libraly.account WHERE name = '"
                    + nameInfo.getText() + "'";
            String query2 = "SELECT * FROM libraly.account WHERE " + "id = ? and pass = ?";
            try {
                Statement statement = connection.createStatement();
                ResultSet result1 = statement.executeQuery(query1);
                PreparedStatement preparedStatement = connection.prepareStatement(query2);
                preparedStatement.setString(1, idInfo.getText());
                preparedStatement.setString(2, passInfo.getText());
                ResultSet result2 = preparedStatement.executeQuery();
                if (result1.next()) {
                    alert.setHeaderText(null);
                    alert.setContentText("Tên người dùng đã tồn tại!");
                    alert.showAndWait();
                } else if (result2.next()) {
                    alert.setHeaderText(null);
                    alert.setContentText("Tài khoản đã tồn tại!");
                    alert.showAndWait();
                } else {
                    String query = "INSERT INTO libraly.account (id, pass, name) VALUES (?, ?, ?)";
                    PreparedStatement prepStatement = connection.prepareStatement(query);
                    prepStatement.setString(1, idInfo.getText());
                    prepStatement.setString(2, passInfo.getText());
                    prepStatement.setString(3, nameInfo.getText());
                    prepStatement.executeUpdate();
                    clearData();
                    info.setVisible(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void logIn() {
        if (idField.getText().isEmpty() || passField.getText().isEmpty()) {
            alert.setHeaderText(null);
            alert.setContentText("Nhập chưa đủ dữ liệu!");
            alert.showAndWait();
        } else {
            String query = "SELECT * FROM libraly.account WHERE " + "id = ? and pass = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, idField.getText());
                preparedStatement.setString(2, passField.getText());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/main.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) signIn.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    mainController controller = loader.getController();
                    String name = resultSet.getString("name");
                    controller.change(name);
                    stage.show();
                } else {
                    alert.setHeaderText(null);
                    alert.setContentText("Tài khoản hoặc mật khẩu không đúng!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void clearData() {
        nameInfo.clear();
        idInfo.clear();
        passInfo.clear();
        rePassInfo.clear();
        showPassInfo.clear();
        showRePassInfo.clear();
        idField.clear();
        passField.clear();
        showPassField.clear();
        checkPass.setSelected(false);
        checkPassInfo.setSelected(false);
    }

}
