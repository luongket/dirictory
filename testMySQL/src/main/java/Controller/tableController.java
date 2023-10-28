package Controller;

import dao.BookDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.testmysql.book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class tableController implements Initializable {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    FXMLLoader loader =new FXMLLoader();
    @FXML
    private TableView<book> tableView;
    @FXML
    private TableColumn<book, String> idCollumn;
    @FXML
    private TableColumn<book, String> nameCollumn;
    @FXML
    private TableColumn<book, Float> giaBanCollun;
    @FXML
    private TableColumn<book, Integer> namCollumn;
    private ObservableList<book> bookList;
    @FXML
    private TextField idText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField giaBanText;
    @FXML
    private TextField namText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<book> list = BookDAO.getInstance().selectAll();
        bookList = FXCollections.observableArrayList();
        for (book boooks: list) {
            bookList.add(new book(boooks.getId(),boooks.getTenSach(),boooks.getGiaBan(), boooks.getNamXuatBan()));
        }
        idCollumn.setCellValueFactory(new PropertyValueFactory<book, String>("id"));
        nameCollumn.setCellValueFactory(new PropertyValueFactory<book, String>("tenSach"));
        giaBanCollun.setCellValueFactory(new PropertyValueFactory<book, Float>("giaBan"));
        namCollumn.setCellValueFactory(new PropertyValueFactory<book, Integer>("namXuatBan"));
        tableView.setItems(bookList);
    }
    public void switchToScene1(ActionEvent event) throws IOException {
        root = loader.load(getClass().getResource("menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void add(ActionEvent event) {
        book newbook = new book();
        newbook.setId(idText.getText());
        newbook.setTenSach(nameText.getText());
        newbook.setGiaBan(Float.parseFloat(giaBanText.getText()));
        newbook.setNamXuatBan(Integer.parseInt(namText.getText()));
        //bookList.add(newbook);
        // Kiểm tra xem cuốn sách đã tồn tại trong cơ sở dữ liệu hay chưa
        book existingBook = BookDAO.getInstance().seclectById(newbook);

        if (existingBook == null) {
            // Nếu cuốn sách chưa tồn tại, thêm nó vào cơ sở dữ liệu
            int result = BookDAO.getInstance().insert(newbook);
            if (result > 0) {
                // Thêm vào danh sách hiển thị
                bookList.add(newbook);
            }
        }
    }
    public void delete(ActionEvent event) {
        book selected = tableView.getSelectionModel().getSelectedItem();
        bookList.remove(selected);
        //
        BookDAO.getInstance().delete(selected);
    }
    @FXML
    public void update(ActionEvent event) {
        String currentAnimalId = idText.getText();

        for (book animal : bookList) {
            if (animal.getId().equals(currentAnimalId)) {
                animal.setTenSach(nameText.getText());
                animal.setGiaBan(Float.parseFloat(giaBanText.getText()));
                animal.setNamXuatBan(Integer.parseInt(namText.getText()));

                BookDAO.getInstance().update(animal);
                tableView.setItems(bookList);
                tableView.refresh();
                break;
            }
        }
    }
    @FXML
    public void rowClicked(javafx.scene.input.MouseEvent mouseEvent) {
        book clickedAnimal = tableView.getSelectionModel().getSelectedItem();
        idText.setText(clickedAnimal.getId());
        nameText.setText(clickedAnimal.getTenSach());
        giaBanText.setText(String.valueOf(clickedAnimal.getGiaBan()));
        namText.setText(String.valueOf(clickedAnimal.getNamXuatBan()));
    }
}
