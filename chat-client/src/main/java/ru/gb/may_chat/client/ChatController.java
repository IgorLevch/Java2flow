package ru.gb.may_chat.client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    private VBox mainpanel;
    @FXML
    private TextArea chatArea;
    @FXML
    private ListView <String> contacts;
    @FXML
    private TextField inputField;
    @FXML
    private Button btnSend;

    public void mockAction(ActionEvent actionEvent) {

        System.out.println("mock");
    }

    public void closeApplication(ActionEvent actionEvent) {

        Platform.exit();
    }

    public void sendMessage(ActionEvent actionEvent) {
    String text = inputField.getText();
    String a = String.valueOf(contacts.getItems()); // метод не заработал, но я так и не понял, как его правильно написать,
    if (text == null || text.isBlank()) {
        return;
    } else if (contacts.isPressed()) {  // туда же
    chatArea.appendText(a+text + System.lineSeparator());
    inputField.clear();
    }
    else {
        chatArea.appendText("Broadcast:  "+text + System.lineSeparator()); // С броадкастом выводится.
        inputField.clear();
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    List<String> names = List.of("Vasya", "Masha", "Petya", "Valera", "Nastya");
    contacts.setItems(FXCollections.observableList(names));
    }

    public void opensomedoc(ActionEvent actionEvent) {
        chatArea.appendText("https://openjfx.io/");  //могу вывести в chatArea,  а чтобы он сразу открылся - это
        //наверное редайрект какой-то нужен -- не знаю. как его набирать в джаве.


    }
}
