/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static test.FXMLDocumentController.txtLimited;

/**
 *
 * @author Diego
 */
public class Test extends Application {

    private static int LBLANZAHLZEICHEN;
    private static final int LIMIT = LBLANZAHLZEICHEN;//Eigentlich nicht 10, sondern Anzahl Zeichen die abgetippt werden sollen

    @Override
    public void start(final Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

//        FXMLDocumentController fxmlDocumentController = new FXMLDocumentController();
//        String txtInput = fxmlDocumentController.getTxtLimitedStr();
        txtLimited.lengthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    // Check if the new character is greater than LIMIT
                    if (txtLimited.getText().length() >= LIMIT) {

                        // if it's 11th character then just setText to previous
                        // one
                        txtLimited.setText(txtLimited.getText().substring(0, LIMIT));
                    }
                }
            }
        });

        Scene scene = new Scene(root);
        primaryStage.setTitle("Test");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

//Der Code um ein Textfeld in dieser Klasse zu erstellen:
/*
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {
    private static final int LIMIT = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {

        final TextField textField = new TextField();
        textField.lengthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    // Check if the new character is greater than LIMIT
                    if (textField.getText().length() >= LIMIT) {

                        // if it's 11th character then just setText to previous
                        // one
                        textField.setText(textField.getText().substring(0, LIMIT));
                    }
                }
            }
        });

        VBox vbox = new VBox(20);
        vbox.getChildren().add(textField);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
 */
