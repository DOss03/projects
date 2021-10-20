/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundboard;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author A.Nguyen.inf19
 */
public class FXMLDocumentController implements Initializable {

    String path = "sounds\\\\CAPITAL BRA - BERLIN LEBT (PROD.BY THE CRATEZ).mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);

    String path2 = "sounds\\\\Juice WRLD - Robbery (Directed by Cole Bennett).mp3";
    Media media2 = new Media(new File(path2).toURI().toString());
    MediaPlayer mediaplayer2 = new MediaPlayer(media2);

    String path3;

    String path4;

    String changeSound;

    String message;

    @FXML
    private Button button1;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label lblSound1;
    @FXML
    private Label lblSound2;
    private RadioButton rd1;
    @FXML
    private ToggleGroup Sound;
    private RadioButton rd2;
    @FXML
    private Button btnSound2;
    @FXML
    private RadioButton rd3;
    @FXML
    private RadioButton rd4;
    @FXML
    private Button btnSound3;
    @FXML
    private Label lblSound12;
    @FXML
    private Label lblSound121;
    @FXML
    private Button btnSound4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button1.setShape(new Circle(1.5));
        btnSound2.setShape(new Circle(1.5));
    }

    @FXML
    private void handleSound1(ActionEvent event) {
        mediaplayer.play();
    }

    @FXML
    private void radioSound(ActionEvent event) {
        if (rd1.isSelected()) {
            message = rd3.getText();
        }
        if (rd2.isSelected()) {
            message = rd4.getText();
        }
    }

    @FXML
    private void handleSound2(ActionEvent event) {
        mediaplayer2.play();
    }

    @FXML
    private void handleSoundÄndern(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File Dialog");
        Stage stage = (Stage) pane.getScene().getWindow();

        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            changeSound = file.getPath().toString();
            System.out.println(changeSound);
        }
        
        path3 = changeSound;
        System.out.println(path3);
    }

    @FXML
    private void handleSoundStop(ActionEvent event) {
        mediaplayer.stop();
    }

    @FXML
    private void handleSoundStop2(ActionEvent event) {
        mediaplayer2.stop();
    }

    @FXML
    private void handleSoundChange(ActionEvent event) {
        
        if (rd3.isSelected()) {
            path3 = changeSound;
        }
        if (rd4.isSelected()) {
            path4 = changeSound;
        }
    }

    @FXML
    private void handleSound3(ActionEvent event) {
        Media media3 = new Media(new File(path3).toURI().toString());
        MediaPlayer mediaplayer3 = new MediaPlayer(media3);
        mediaplayer3.play();
    }

    @FXML
    private void handleSound4(ActionEvent event) {
        Media media4 = new Media(new File(path4).toURI().toString());
        MediaPlayer mediaplayer4 = new MediaPlayer(media4);
        mediaplayer4.play();
    }

    @FXML
    private void help(ActionEvent event) {
        System.out.println("Bei unserem Programm können Sie Sounds abspielen und hinzufügen.");
    }


}
