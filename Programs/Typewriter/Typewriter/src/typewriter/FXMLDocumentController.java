/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typewriter;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author rajar
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField Input;
    @FXML
    private Label Text;
    @FXML
    private Label geschafft;

    int counter;
    int mcounter;
    @FXML
    private Label geschafft1;
    @FXML
    private Label errorText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Text.setStyle("-fx-color:Green;");
        //Text.setText(fl.getText());
    }

    @FXML
    private void enterEvent(ActionEvent event) {
        if (Text.getText().length() > Input.getText().length()) {
            errorText.setVisible(true);
            errorText.setText("Der eingegebene Text muss mindestens so gross sein wie der angezeigte Text!");
        } else {
            for (int i = 0; i < Text.getText().length(); i++) {
                if (Text.getText().charAt(i) == Input.getText().charAt(i)) {
                    //geschafft.setText("richtig");
                    counter++;
                } else {
                    //geschafft.setText("falsch");
                    mcounter++;
                }
            }
            System.out.println("Hallo");
            geschafft.setText("Fehler: " + (Integer.toString(mcounter)));
            geschafft1.setText("Richtig: " + (Integer.toString(counter)));
        }
    }

    @FXML
    private void CreateFileAction(ActionEvent event) {
        String m = JOptionPane.showInputDialog("Type in the name of the textfile you want to create.(including .txt)");
        try {
            if (new File(m).createNewFile()) {
                System.out.println("File created: " + new File(m).getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    private void WriteFileAction(ActionEvent event) {
        String FileWritename = JOptionPane.showInputDialog("Type in the name of the textfile you want to write into.(including .txt)");
        String FileWritetext = JOptionPane.showInputDialog("Type in the text you want to write into the chosen textfile.");
        try {
            FileWriter myWriter = new FileWriter(FileWritename);
            myWriter.write(FileWritetext);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    private void ChooseTextAction(ActionEvent event) {
        String FileChoose = JOptionPane.showInputDialog("Type in the name of the textfile you have created and or written into.(including .txt");
        Filereader fl = new Filereader(new File(FileChoose));
        Text.setText(fl.getText());
    }

    @FXML
    private void DeleteFileAction(ActionEvent event) {
        String FileDelete = JOptionPane.showInputDialog("Type in the name of the textfile you want to delete.(including .txt");
        File myObj = new File(FileDelete);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
