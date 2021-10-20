/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bärenhöhlenspiel_diegoosswald;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Diego
 */
public class FXMLDocumentController implements Initializable {

    public Label würfel1;
    public Label würfel2;
    public Label würfel3;
    public Label würfel4;
    public Label würfel5;

    @FXML
    private Label lösung;

    int augenZahl1;
    int augenZahl2;
    int augenZahl3;
    int augenZahl4;
    int augenZahl5;
    int anzahlHöhlen = 0;
    int anzahlBären = 0;

    int höhleberechnen;
    int bärenberechnen;

    @FXML
    private TextField anzahlhöhlen;
    @FXML
    private TextField anzahlbären;
    @FXML
    private Label lösungB;
    @FXML
    private Label lösungBH;

    @FXML
    private void würfeln(ActionEvent event) {
        Random würfeln1 = new Random();
        augenZahl1 = 1 + würfeln1.nextInt(6);
        würfel1.setText(String.valueOf(augenZahl1));

        Random würfeln2 = new Random();
        augenZahl2 = 1 + würfeln2.nextInt(6);
        würfel2.setText(String.valueOf(augenZahl2));

        Random würfeln3 = new Random();
        augenZahl3 = 1 + würfeln3.nextInt(6);
        würfel3.setText(String.valueOf(augenZahl3));

        Random würfeln4 = new Random();
        augenZahl4 = 1 + würfeln4.nextInt(6);
        würfel4.setText(String.valueOf(augenZahl4));

        Random würfeln5 = new Random();
        augenZahl5 = 1 + würfeln5.nextInt(6);
        würfel5.setText(String.valueOf(augenZahl5));

        höhleberechnen = höhle(augenZahl1, augenZahl2, augenZahl3, augenZahl4, augenZahl5);
        bärenberechnen = bären(augenZahl1, augenZahl2, augenZahl3, augenZahl4, augenZahl5);
    }

    @FXML
    private void prüfen(ActionEvent event) throws IOException {

        String höhle = anzahlhöhlen.getText();
        String bären = anzahlbären.getText();
        String lhöhle = String.valueOf(höhleberechnen);
        String lbären = String.valueOf(bärenberechnen);
        if (lhöhle.equalsIgnoreCase(höhle) && lbären.equalsIgnoreCase(bären)) {
            lösung.setText("Deine Antwort ist richtig!");
        } else {
            lösung.setText("Deine Antwort ist falsch. Du solltest die Regeln durchlesen.");
        }

    }

    public int höhle(int würfel1, int würfel2, int würfel3, int würfel4, int würfel5) {

        int rest1 = würfel1 % 2;
        if (würfel1 == 1 || rest1 == 1) {
            anzahlHöhlen++;
        }

        int rest2 = würfel2 % 2;
        if (würfel2 == 1 || rest2 == 1) {
            anzahlHöhlen++;
        }

        int rest3 = würfel3 % 2;
        if (würfel3 == 1 || rest3 == 1) {
            anzahlHöhlen++;
        }

        int rest4 = würfel4 % 2;
        if (würfel4 == 1 || rest1 == 1) {
            anzahlHöhlen++;
        }

        int rest5 = würfel5 % 2;
        if (würfel5 == 1 || rest1 == 1) {
            anzahlHöhlen++;
        }
        return anzahlHöhlen;
    }

    public int bären(int würfel1, int würfel2, int würfel3, int würfel4, int würfel5) {
        //Würfel 1
        int restbetrag1 = würfel1 % 2;

        if (restbetrag1 == 1) {
            if (würfel1 == 1) {
                würfel1 = 6;
                anzahlBären = anzahlBären + würfel1;
            }

            if (würfel1 == 3) {
                würfel1 = 4;
                anzahlBären = anzahlBären + würfel1;
            }

            if (würfel1 == 5) {
                würfel1 = 2;
                anzahlBären = anzahlBären + würfel1;
            }
        }

        //Würfel 2
        int restbetrag2 = würfel2 % 2;

        if (restbetrag2 == 1) {
            if (würfel2 == 1) {
                würfel2 = 6;
                anzahlBären = anzahlBären + würfel2;
            }

            if (würfel2 == 3) {
                würfel2 = 4;
                anzahlBären = anzahlBären + würfel2;
            }

            if (würfel2 == 5) {
                würfel2 = 2;
                anzahlBären = anzahlBären + würfel2;
            }
        }

        //Würfel 3
        int restbetrag3 = würfel3 % 2;

        if (restbetrag3 == 1) {
            if (würfel3 == 1) {
                würfel3 = 6;
                anzahlBären = anzahlBären + würfel3;
            }

            if (würfel3 == 3) {
                würfel3 = 4;
                anzahlBären = anzahlBären + würfel3;
            }

            if (würfel3 == 5) {
                würfel3 = 2;
                anzahlBären = anzahlBären + würfel3;
            }
        }

        //Würfel 4
        int restbetrag4 = würfel4 % 2;

        if (restbetrag4 == 1) {
            if (würfel4 == 1) {
                würfel4 = 6;
                anzahlBären = anzahlBären + würfel4;
            }

            if (würfel4 == 3) {
                würfel4 = 4;
                anzahlBären = anzahlBären + würfel4;
            }

            if (würfel4 == 5) {
                würfel4 = 2;
                anzahlBären = anzahlBären + würfel4;
            }
        }

        //Würfel 5
        int restbetrag5 = würfel5 % 2;

        if (restbetrag5 == 1) {
            if (würfel5 == 1) {
                würfel5 = 6;
                anzahlBären = anzahlBären + würfel5;
            }

            if (würfel5 == 3) {
                würfel5 = 4;
                anzahlBären = anzahlBären + würfel5;
            }

            if (würfel5 == 5) {
                würfel5 = 2;
                anzahlBären = anzahlBären + würfel5;
            }
        }

        return anzahlBären;
    }

    @FXML
    private void hilfeFenster(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Hilfe.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
