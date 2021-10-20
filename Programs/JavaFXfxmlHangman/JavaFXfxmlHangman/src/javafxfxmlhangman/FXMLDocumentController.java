/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlhangman;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtGuessingWord;

    public static String guessingWord;

    @FXML
    private String confirm(ActionEvent event) throws IOException {
        guessingWord = txtGuessingWord.getText();
        if (guessingWord.matches("^[a-zA-Z]*$")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HangmanGUI.fxml"));
            Parent root = loader.load();

            //get Controller of HangmanGUI
            HangmanGUIController hangmanGUIController = loader.getController();

            //Pass data
            hangmanGUIController.guessWord(guessingWord);

            //show HangmanGUI in new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Hangman game");
            stage.show();
        }
        return guessingWord;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
