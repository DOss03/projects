/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Diego
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public static TextField txtLimited;
    @FXML
    private Label lblAnzahlZeichen;
    private String lblAnzahlZeichenInput;
    private static int LBLANZAHLZEICHEN;

    /*
    public static String getTxtLimitedStr() {
        String txtLimitedStr = String.valueOf(txtLimited);
        return txtLimitedStr;
    }
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        lblAnzahlZeichenInput = String.valueOf(lblAnzahlZeichen);
        LBLANZAHLZEICHEN = lblAnzahlZeichenInput.length();
    }

}
