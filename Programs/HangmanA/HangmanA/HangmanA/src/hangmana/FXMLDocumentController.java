/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmana;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author A.Nguyen.inf19
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtEingabe;
    @FXML
    private Button btnTesten;
    @FXML
    private Label lblVersuche;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Button btnZiel;
    @FXML
    private Label lblTextAusgabe;
    @FXML
    private Button btnLöschen;
    @FXML
    private ImageView hangman1;

    String geheimesWort;
    String rad = "RAD";
    int anzahlVersuche = 0;
    private boolean isCount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleTesten(ActionEvent event) {
        lblTextAusgabe.setText("");
        hangman1.visibleProperty();
        String eingabe = txtEingabe.getText();
        //Prüft ob zahlen oder +- eingegeben wurde, wenn dies zustimmt dann wird "Ungültige Eingabe!" ausgegeben.
        if (eingabe.isEmpty()) {
            lblTextAusgabe.setText("Keine Eingabe!");
        } else {

            if (!eingabe.matches("^[a-zA-Z]*$")) {
                lblTextAusgabe.setText("Ungültige Eingabe!");
            }

            if (eingabe.length() > 1) {
                lblTextAusgabe.setText("Zu viele Zeichen!");
            }

            if (eingabe.equalsIgnoreCase("R")) {
                lbl1.setText("R");
                geheimesWort += "R";
                lblTextAusgabe.setText("Das Geheimewort beinhaltet den Buchstaben 'R'");
            }

            if (eingabe.equalsIgnoreCase("A")) {
                lbl2.setText("A");
                geheimesWort += "A";
                lblTextAusgabe.setText("Das Geheimewort beinhaltet den Buchstaben 'A'");
            }

            if (eingabe.equalsIgnoreCase("D")) {
                lbl3.setText("D");
                geheimesWort += "D";
                lblTextAusgabe.setText("Das Geheimewort beinhaltet den Buchstaben 'D'");
            }

            if (eingabe.matches("^[a-zA-Z]*$") && !(eingabe.length() > 1)) {
                isCount = true;
                if (lbl1.getText().equals(eingabe)) {
                    isCount = false;
                }

                if (lbl2.getText().equals(eingabe)) {
                    isCount = false;
                }

                if (lbl3.getText().equals(eingabe)) {
                    isCount = false;
                }

                if (isCount == true) {
                    anzahlVersuche++;
                }
            }
            lblVersuche.setText(String.valueOf(anzahlVersuche));
        }

        /*
        if(eingabe != "D" || eingabe != "R" || eingabe != "A"){
            lblTextAusgabe.setText("Das Geheimewort beinhaltet den Buchstaben " + eingabe + " nicht");
        }*/
        if (lbl1.getText()
                == "R" && lbl2.getText() == "A" && lbl3.getText() == "D") {
            lblTextAusgabe.setText("Du hast das Wort in " + String.valueOf(anzahlVersuche) + " Versuchen erraten.");
        }

    }

    @FXML
    private void handleZiel(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Ziel.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void handleLöschen(ActionEvent event) {
        txtEingabe.setText("");
        lblTextAusgabe.setText("");
    }

}
