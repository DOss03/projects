/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechner.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author A.Nguyen.inf19
 * @author D.Osswald.inf19
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private long number1 = 0;
    private String operator = "";
    private String imperial = "";
    private boolean start = true;
    @FXML
    private TextField textKurs;
    @FXML
    private TextField textCHF;
    
    Model model = new Model();
    ZusatzMethoden zusatzMethoden = new ZusatzMethoden();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void processNumbers(ActionEvent event) {
        if(start == true){
            label.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        label.setText(label.getText() + value);
    }

    @FXML
    private void processOperators(ActionEvent event) {
        //Wenn der Benutzer "=" drückt und der Inhalt leer ist -> Dann wird nichts zurückgegeben
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }  
            operator = value;
            number1 = Long.parseLong(label.getText());
            label.setText("");
        }else{
            if(operator.isEmpty())
                return;
            long number2 = Long.parseLong(label.getText());
            float output = model.calculate(number1, number2, operator);
            label.setText(String.valueOf(output));
        }
    }

    @FXML
    //Inches, Miles, Feed berechnen
    private void processZusatz(ActionEvent event) {
        number1 = Long.parseLong(label.getText());
        label.setText("");
        String value = ((Button)event.getSource()).getText();
        imperial = value;
        double output = zusatzMethoden.calculateImperial(number1, imperial);
        label.setText(String.valueOf(output + " " + imperial));
    }

    @FXML
    //Franken in Euro umrechnen
    private void processWährung(ActionEvent event) {
        String kurs = textKurs.getText();
        String chf = textCHF.getText();
        double dkurs = Double.parseDouble(kurs);
        double dchf = Double.parseDouble(chf);
        double dausgabe = dkurs * dchf;
        label.setText(String.valueOf(dausgabe + " EUR"));
    }

    @FXML
    private void delete(ActionEvent event) {
        label.setText("");
    }
    
}
