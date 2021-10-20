/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfxmlhangman;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class HangmanGUIController implements Initializable {

    FXMLDocumentController fxml = new FXMLDocumentController();
    @FXML
    private TextField txtGuessOneLetter;
    @FXML
    private Label totalOfLetters;
    @FXML
    private TextArea guessedLetters;
    @FXML
    private Label correctLetters;
    @FXML
    private Label label;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void check(ActionEvent event/*, String guessingWord*/) {
/*        String letter;
        String[] guessingWordLetters = guessingWord.split("");
        
        for (String guessingWordLetter : guessingWordLetters) {
            letter = guessingWordLetter;
            
        }
        String letter1 = guessingWordLetters[0];
        label.setText(letter1);
*/        
        String label;
        label = txtGuessOneLetter.getText();
    }
    
    public void guessWord (String guessingWord) {
        label.setText(guessingWord);
    }
    
}
